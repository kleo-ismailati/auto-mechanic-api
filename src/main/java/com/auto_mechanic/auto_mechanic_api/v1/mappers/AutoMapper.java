package com.auto_mechanic.auto_mechanic_api.v1.mappers;

import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.create.AutoCreateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.requests.update.AutoUpdateDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.AutoDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.ClientAutoDto;
import com.auto_mechanic.auto_mechanic_api.v1.dto.responses.getSingle.ImageDataDto;
import com.auto_mechanic.auto_mechanic_api.v1.models.Auto;
import com.auto_mechanic.auto_mechanic_api.v1.models.Client;
import com.auto_mechanic.auto_mechanic_api.v1.serviceImpls.ImageServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoMapper {

    private final ImageServiceImpl imageService;


    public AutoMapper(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    public Auto toNewEntity(AutoCreateDto autoDto, Client client) {

        Auto autoEntity = new Auto();

        autoEntity.setAutoType(autoDto.getAutoType().trim());
        autoEntity.setAutoModel(autoDto.getAutoModel().trim());
        autoEntity.setYear(autoDto.getYear().trim());
        autoEntity.setColor(autoDto.getColor().trim());
        autoEntity.setAutoDescription(autoDto.getAutoDescription().trim());
        autoEntity.setClient(client);

        return autoEntity;
    }

    public Auto updateEntity(AutoUpdateDto autoDto, Auto auto) {

        if (autoDto.getAutoType() != null) {
            auto.setAutoType(autoDto.getAutoType().trim());
        }

        if (autoDto.getAutoModel() != null) {
            auto.setAutoModel(autoDto.getAutoModel().trim());
        }

        if (autoDto.getYear() != null) {
            auto.setYear(autoDto.getYear().trim());
        }

        if (autoDto.getColor() != null) {
            auto.setColor(autoDto.getColor().trim());
        }

        if (autoDto.getAutoDescription() != null) {
            auto.setAutoDescription(autoDto.getAutoDescription().trim());
        }

        return auto;
    }

    public AutoDto toDto(Auto auto) {
        AutoDto autoDto = new AutoDto();

        autoDto.setYear(auto.getYear());
        autoDto.setAutoDescription(auto.getAutoDescription());
        autoDto.setColor(auto.getColor());
        autoDto.setAutoModel(auto.getAutoModel());
        autoDto.setAutoType(auto.getAutoType());
        if (auto.getImage() != null) {
            autoDto.setImageId(auto.getImage().getId());
        }

        return autoDto;
    }

    public ClientAutoDto toClientAutoDto(Auto auto) {
        ClientAutoDto autoDto = new ClientAutoDto();

        autoDto.setId(auto.getId());
        autoDto.setYear(auto.getYear());
        autoDto.setColor(auto.getColor());
        autoDto.setAutoModel(auto.getAutoModel());
        autoDto.setAutoType(auto.getAutoType());

        if (auto.getImage() != null) {
            ImageDataDto imageData = imageService.getImageData(auto.getImage().getId());

            autoDto.setThumbnail(imageData);
        }
        return autoDto;
    }

    public List<ClientAutoDto> toClientAutoDtoList(List<Auto> autos) {
        List<ClientAutoDto> autoDtoList = new ArrayList<>();

        for (Auto auto : autos) {
            autoDtoList.add(toClientAutoDto(auto));
        }

        return autoDtoList;
    }
}
