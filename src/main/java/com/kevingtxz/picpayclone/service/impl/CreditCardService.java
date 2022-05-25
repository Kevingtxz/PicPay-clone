package com.kevingtxz.picpayclone.service.impl;

import com.kevingtxz.picpayclone.dto.CreditCardDTO;
import com.kevingtxz.picpayclone.dto.converter.CreditCardConverter;
import com.kevingtxz.picpayclone.entity.CreditCardEntity;
import com.kevingtxz.picpayclone.repository.CreditCardRepository;
import com.kevingtxz.picpayclone.service.ICreditCardService;
import com.kevingtxz.picpayclone.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService implements ICreditCardService {

    @Autowired
    private CreditCardRepository repo;
    @Autowired
    private CreditCardConverter converter;
    @Autowired
    private IUserService userService;


    @Override
    public CreditCardDTO save(CreditCardDTO dto) {
        CreditCardDTO creditCardReturn = null;
        if (dto.getIsSave()) {
            CreditCardEntity obj = converter.toEntity(dto);
            userService.validate(obj.getUser());
            CreditCardEntity creditCardSaved = repo.save(obj);
            creditCardReturn = converter.toDto(creditCardSaved);
        }
        return creditCardReturn;
    }
}
