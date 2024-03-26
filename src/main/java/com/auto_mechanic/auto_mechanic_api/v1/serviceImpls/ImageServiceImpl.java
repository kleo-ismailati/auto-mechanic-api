package com.auto_mechanic.auto_mechanic_api.v1.serviceImpls;

import com.auto_mechanic.auto_mechanic_api.v1.config.ConfigProperties;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.ImageDataDto;
import com.auto_mechanic.auto_mechanic_api.v1.exceptions.FileStorageException;
import com.auto_mechanic.auto_mechanic_api.v1.models.Auto;
import com.auto_mechanic.auto_mechanic_api.v1.models.Image;
import com.auto_mechanic.auto_mechanic_api.v1.models.User;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.AutoRepository;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.ImageRepository;
import com.auto_mechanic.auto_mechanic_api.v1.repositories.UserRepository;
import com.auto_mechanic.auto_mechanic_api.v1.services.ImageService;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final AutoRepository autoRepository;
    private final UserRepository userRepository;
    private final Path fileStorageLocation;

    public ImageServiceImpl(ImageRepository imageRepository, AutoRepository autoRepository, UserRepository userRepository, ConfigProperties configProperties) {
        this.imageRepository = imageRepository;
        this.autoRepository = autoRepository;
        this.userRepository = userRepository;

        this.fileStorageLocation = Paths.get(configProperties.getUploadDir())
                .toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (IOException ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }

    public ResponseEntity<Resource> getImage(String id) {
        Image image = imageRepository.findById(id).orElseThrow();

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

    public ImageDataDto getImageData(String id) {
        Image image = imageRepository.findById(id).orElseThrow();

        try {
            this.checkFilenameValid(image.getName());

            Path imagePath = Paths.get(this.fileStorageLocation.toString(), image.getName());

            ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(imagePath));

            if (resource.exists() || resource.isReadable()) {
                ImageDataDto imageDto = new ImageDataDto();

                imageDto.setType(image.getType());
                imageDto.setName(image.getName());
                imageDto.setData(resource.getByteArray());

                return imageDto;
            } else {
                return null;
            }
        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }

    }

    public Image saveAndCompressImage(MultipartFile file) {

        String fileName = RandomStringUtils.randomAlphabetic(12);

        try {
            this.checkFilenameValid(fileName);

            // Copy file to the target location and compress to thumbnail (Replacing existing file with the same name)
            String fileExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());

            String fileFullName = fileName + "." + fileExtension;

            Path targetFile = this.fileStorageLocation.toAbsolutePath().resolve(fileFullName);

            File compressedImage = targetFile.toFile();

            Thumbnails.of(file.getInputStream())
                    .size(200, 200)
                    .toFile(compressedImage);

            Image image = new Image();
            image.setName(fileFullName);
            image.setType(file.getContentType());
            image.setLocation(this.fileStorageLocation.toAbsolutePath().toString());

            return image;

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    private void checkFilenameValid(String fileName) {
        // Check if the file's name contains invalid characters
        if (fileName.contains("..")) {
            throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
        }
    }

    public ResponseEntity<Image> setUserImg(Long id, MultipartFile file) {

        User user = this.userRepository.findById(id).orElseThrow();
        if (user.getImage() == null) {
            Image autoImg = this.saveAndCompressImage(file);
            user.setImage(autoImg);
            this.userRepository.save(user);
            return ResponseEntity.ok(autoImg);
        } else return ResponseEntity.badRequest().body(null);

    }

    public ResponseEntity<Image> setAutoImg(Long id, MultipartFile file) {
        Auto auto = this.autoRepository.findById(id).orElseThrow();
        if (auto.getImage() == null) {
            Image autoImg = this.saveAndCompressImage(file);
            auto.setImage(autoImg);
            this.autoRepository.save(auto);
            return ResponseEntity.ok(autoImg);
        } else {
            // Remove old image
            Image autoImg = auto.getImage();
            auto.setImage(null);
            deleteAutoImage(autoImg);

            // Add new image
            Image newAutoImg = this.saveAndCompressImage(file);
            auto.setImage(newAutoImg);
            this.autoRepository.save(auto);
            return ResponseEntity.ok(newAutoImg);
        }
    }

    private void deleteAutoImage(Image image) {
        deleteImage(image);
        this.imageRepository.delete(image);
    }

    public void deleteImage(Image image) {
        try {
            this.checkFilenameValid(image.getName());

            Path targetLocation = this.fileStorageLocation.toAbsolutePath().resolve(image.getName());

            Files.deleteIfExists(targetLocation.toAbsolutePath());

        } catch (IOException e) {
            throw new RuntimeException("Error: " + e.getMessage());
        }
    }
}
