package com.kevingtxz.picpayclone.dto.converter;

import com.kevingtxz.picpayclone.dto.CreditCardDTO;
import com.kevingtxz.picpayclone.dto.converter.abstractbase.ConverterBase;
import com.kevingtxz.picpayclone.entity.CreditCardEntity;
import com.kevingtxz.picpayclone.service.IUserService;
import com.kevingtxz.picpayclone.util.CreditCardUtil;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditCardConverter extends ConverterBase<CreditCardEntity, CreditCardDTO> {


    @Autowired
    private IUserService userService;


    @Override
    public CreditCardDTO toDto(CreditCardEntity obj) {
        ModelMapper modelMaper = new ModelMapper();
        modelMaper.addMappings(new PropertyMap<CreditCardEntity, CreditCardDTO>() {
            @Override
            protected void configure(){}
        });
        return modelMaper.map(obj, CreditCardDTO.class);
    }

    @Override
    public CreditCardEntity toEntity(CreditCardDTO dto) {
        return CreditCardEntity.builder()
                .flag(dto.getFlag())
                .number(CreditCardUtil.mask(dto.getNumber()))
                .numberToken(dto.getNumberToken())
                .user(userService.findByLoginEntity(dto.getUser().getLogin()))
                .build();
    }
}
