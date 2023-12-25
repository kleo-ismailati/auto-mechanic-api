package com.auto_mechanic.auto_mechanic_api.api.mapper;

import com.auto_mechanic.auto_mechanic_api.api.dto.auto.AutoDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.auto.auto_edit.AutoEditDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.auto.new_auto.NewAutoDto;
import com.auto_mechanic.auto_mechanic_api.api.dto.client.AutoClientListItemDto;
import com.auto_mechanic.auto_mechanic_api.api.model.Auto;
import com.auto_mechanic.auto_mechanic_api.api.model.Client;
import com.auto_mechanic.auto_mechanic_api.image.service.ImageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AutoMapper {
	
	private final ImageService imageService;


	public AutoMapper(ImageService imageService) {
        this.imageService = imageService;
    }

	public Auto toNewEntity(NewAutoDto autoDto, Client client) {
		
		Auto autoEntity = new Auto();
		
		autoEntity.setAutoType(autoDto.getAutoType().trim());
		autoEntity.setAutoModel(autoDto.getAutoModel().trim());
		autoEntity.setYear(autoDto.getYear().trim());
		autoEntity.setColor(autoDto.getColor().trim());
		autoEntity.setAutoDescription(autoDto.getAutoDescription().trim());
		autoEntity.setClient(client);
		
		return autoEntity;
	}

	public Auto updateEntity(AutoEditDto autoDto, Auto auto) {
		
		if(autoDto.getAutoType() != null) {
			auto.setAutoType(autoDto.getAutoType().trim());
		}
		
		if(autoDto.getAutoModel() != null) {
			auto.setAutoModel(autoDto.getAutoModel().trim());
		}
		
		if(autoDto.getYear() != null) {
			auto.setYear(autoDto.getYear().trim());
		}
		
		if(autoDto.getColor() != null) {
			auto.setColor(autoDto.getColor().trim());
		}
		
		if(autoDto.getAutoDescription() != null) {
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
		if(auto.getImage() != null){
			autoDto.setImageId(auto.getImage().getId());
		}

		return autoDto;
    }

	public AutoClientListItemDto toClientListItemDto(Auto auto) {
		AutoClientListItemDto autoDto = new AutoClientListItemDto();

		autoDto.setId(auto.getId());
		autoDto.setYear(auto.getYear());
		autoDto.setColor(auto.getColor());
		autoDto.setAutoModel(auto.getAutoModel());
		autoDto.setAutoType(auto.getAutoType());

		if(auto.getImage() != null){
			byte[] imageData = imageService.getImageData(auto.getImage().getId());

			autoDto.setThumbnail(imageData);
		}
		return autoDto;
	}

	public List<AutoClientListItemDto> toDtoListForClient(List<Auto> autos) {
		List<AutoClientListItemDto> autoDtoList = new ArrayList<>();

		for(Auto auto : autos) {
			autoDtoList.add(toClientListItemDto(auto));
		}

		return autoDtoList;
	}
}
