package com.kevingtxz.picpayclone.dto.converter;

import com.kevingtxz.picpayclone.dto.UserDTO;
import com.kevingtxz.picpayclone.dto.converter.abstractbase.ConverterBase;
import com.kevingtxz.picpayclone.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends ConverterBase<UserEntity, UserDTO> {

    @Override
    public UserDTO toDto(UserEntity obj) {
        ModelMapper modelMaper = new ModelMapper();
        modelMaper.addMappings(new PropertyMap<UserEntity, UserDTO>() {
            @Override
            protected void configure(){}
        });
        return modelMaper.map(obj, UserDTO.class);
    }

    @Override
    public UserEntity toEntity(UserDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(new PropertyMap<UserDTO, UserEntity>() {
            @Override
            protected void configure(){}
        });
        return modelMapper.map(dto, UserEntity.class);
    }
}
