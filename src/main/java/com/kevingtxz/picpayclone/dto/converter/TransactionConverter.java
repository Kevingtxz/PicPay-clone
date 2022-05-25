package com.kevingtxz.picpayclone.dto.converter;

import com.kevingtxz.picpayclone.dto.TransactionDTO;
import com.kevingtxz.picpayclone.dto.converter.abstractbase.ConverterBase;
import com.kevingtxz.picpayclone.entity.TransactionEntity;
import com.kevingtxz.picpayclone.service.IUserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class TransactionConverter extends ConverterBase<TransactionEntity, TransactionDTO> {

    @Autowired
    private IUserService userService;


    @Override
    public TransactionDTO toDto(TransactionEntity obj) {
        ModelMapper modelMaper = new ModelMapper();
        modelMaper.addMappings(new PropertyMap<TransactionEntity, TransactionDTO>() {
            @Override
            protected void configure(){}
        });
        return modelMaper.map(obj, TransactionDTO.class);
    }

    @Override
    public TransactionEntity toEntity(TransactionDTO dto) {
        return TransactionEntity.builder()
                .code(dto.getCode())
                .dateTime(dto.getDateTime())
                .value(dto.getValue())
                .userOrigin(userService.findByLoginEntity(dto.getUserOrigin().getLogin()))
                .userDestiny(userService.findByLoginEntity(dto.getUserDestiny().getLogin()))
                .build();
    }

    @SuppressWarnings("unchecked")
    public Page<TransactionDTO> toDtoPage(Page<TransactionEntity> objPage) {
        ModelMapper modelMaper = new ModelMapper();
        modelMaper.addMappings(new PropertyMap<Page<TransactionEntity>, Page<TransactionDTO>>() {
            @Override
            protected void configure(){}
        });
        return modelMaper.map(objPage, Page.class);
    }
}
