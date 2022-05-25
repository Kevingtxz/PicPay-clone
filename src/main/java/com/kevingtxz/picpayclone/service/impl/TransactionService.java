package com.kevingtxz.picpayclone.service.impl;

import com.kevingtxz.picpayclone.dto.TransactionDTO;
import com.kevingtxz.picpayclone.dto.converter.TransactionConverter;
import com.kevingtxz.picpayclone.entity.TransactionEntity;
import com.kevingtxz.picpayclone.repository.TransactionRepository;
import com.kevingtxz.picpayclone.service.ICreditCardService;
import com.kevingtxz.picpayclone.service.ITransactionService;
import com.kevingtxz.picpayclone.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private TransactionRepository repo;
    @Autowired
    private TransactionConverter converter;
    @Autowired
    private IUserService userService;
    @Autowired
    private ICreditCardService creditCardService;


    @Override
    public TransactionDTO process(TransactionDTO dto) {
        TransactionEntity obj = this.save(dto);
        creditCardService.save(dto.getCreditCard());
        userService.updateBalance(obj, dto.getIsCreditCard());
        return converter.toDto(obj);
    }

    @Override
    public Page<TransactionDTO> findPage(Pageable pagination, String login) {
        Page<TransactionEntity> objPage =
                repo.findByUserOrigin_LoginOrUserDestiny_Login(login, login, pagination);
        return converter.toDtoPage(objPage);
    }

    private TransactionEntity save(TransactionDTO dto) {
        TransactionEntity obj = converter.toEntity(dto);
        userService.validate(obj.getUserOrigin(), obj.getUserDestiny());
        return repo.save(obj);
    }
}
