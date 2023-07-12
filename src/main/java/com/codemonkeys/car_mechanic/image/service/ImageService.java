package com.codemonkeys.car_mechanic.image.service;

import com.codemonkeys.car_mechanic.api.model.Car;
import com.codemonkeys.car_mechanic.api.repository.CarRepository;
import com.codemonkeys.car_mechanic.exception.FileStorageException;
import com.codemonkeys.car_mechanic.image.model.Image;
import com.codemonkeys.car_mechanic.image.repository.ImageRepository;
import com.codemonkeys.car_mechanic.property.ConfigProperties;
import com.codemonkeys.car_mechanic.user.model.User;
import com.codemonkeys.car_mechanic.user.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class ImageService {

    private final ImageRepository imageRepository;
    private final CarRepository carRepository;
    private final UserRepository userRepository;
    private final Path fileStorageLocation;

    //TODO fix image storing procedure

    public ImageService(ImageRepository imageRepository, CarRepository carRepository, UserRepository userRepository, ConfigProperties configProperties) {
        this.imageRepository = imageRepository;
        this.carRepository = carRepository;
        this.userRepository = userRepository;

        this.fileStorageLocation = Paths.get(configProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public ResponseEntity<Resource> getImage(String id){
        Image image = imageRepository.findById(id).get();

        try {
            this.checkFilenameValid(image.getName());

            Resource resource = new UrlResource(this.fileStorageLocation.toUri() + image.getName());

            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .contentType(MediaType.parseMediaType(image.getType()))
                        .body(resource);
            } else {
                throw new RuntimeException("Could not read the file!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

    }

    public Image saveImage(MultipartFile file) throws IOException {

        String fileName = RandomStringUtils.randomAlphabetic(12);

        try {
            this.checkFilenameValid(fileName);

            // Copy file to the target location (Replacing existing file with the same name)
            String fileExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());

            String fileFullName = fileName + "." + fileExtension;

            Path targetLocation = this.fileStorageLocation.toAbsolutePath().resolve(fileFullName);

            Files.copy(file.getInputStream(), targetLocation.toAbsolutePath(), StandardCopyOption.REPLACE_EXISTING);

            Image image = new Image();
            image.setName(fileFullName);
            image.setType(file.getContentType());

            return image;

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    private void checkFilenameValid(String fileName){
        // Check if the file's name contains invalid characters
        if(fileName.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
        }
    }

    public ResponseEntity<Image> setUserImg(Long id, MultipartFile file) {
        try {
            User user = this.userRepository.findById(id).get();
            if(user.getImage() == null){
                Image carImg = this.saveImage(file);
                user.setImage(carImg);
                this.userRepository.save(user);
                return ResponseEntity.ok(carImg);
            } else return ResponseEntity.badRequest().body(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<Image> setCarImg(Long id, MultipartFile file) {
        try {
            Car car = this.carRepository.findById(id).get();
            if(car.getImage() == null){
                Image carImg = this.saveImage(file);
                car.setImage(carImg);
                this.carRepository.save(car);
                return ResponseEntity.ok(carImg);
            } else {
                Image carImg = car.getImage();
                car.setImage(null);
                deleteCarImage(carImg);
                Image newCarImg = this.saveImage(file);
                car.setImage(newCarImg);
                this.carRepository.save(car);
                return ResponseEntity.ok(newCarImg);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteCarImage(Image image) {
        deleteImage(image);
        this.imageRepository.delete(image);
    }

    public void deleteImage(Image image){
        try {
            this.checkFilenameValid(image.getName());

            Path targetLocation = this.fileStorageLocation.toAbsolutePath().resolve(image.getName());

            Files.deleteIfExists(targetLocation.toAbsolutePath());

        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
