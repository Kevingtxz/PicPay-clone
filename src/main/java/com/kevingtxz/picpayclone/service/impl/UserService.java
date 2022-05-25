package com.kevingtxz.picpayclone.service.impl;

import com.kevingtxz.picpayclone.dto.UserDTO;
import com.kevingtxz.picpayclone.dto.converter.UserConverter;
import com.kevingtxz.picpayclone.entity.TransactionEntity;
import com.kevingtxz.picpayclone.entity.UserEntity;
import com.kevingtxz.picpayclone.repository.UserRepository;
import com.kevingtxz.picpayclone.service.IUserService;
import com.kevingtxz.picpayclone.service.exceptions.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repo;
    @Autowired
    private UserConverter converter;


    @Override
    @Async("asyncExecutor")
    public void updateBalance(TransactionEntity transaction, Boolean isCreditCard) {
        increaseBalance(transaction);
        decreaseBalance(transaction, isCreditCard);
    }

    @Override
    public void validate(UserEntity... users) {
        Arrays.asList(users).stream()
                .forEach(user -> {
                    if (user == null)
                        throw new BusinessException("The user does not exist");
                });

    }

    @Override
    public List<UserDTO> findAllByLoginNotEqual(String login) {
        List<UserEntity> filteredUserList = repo.findAll().stream()
                .filter(obj -> !obj.getLogin().equals(login))
                .collect(Collectors.toList());
        return converter.toDtoList(filteredUserList);
    }

    @Override
    public UserEntity findByLoginEntity(String login) {
        return repo.findByLogin(login);
    }

    public UserDTO findByLogin(String login) {
        return converter.toDto(this.findByLoginEntity(login));
    }

    private void increaseBalance(TransactionEntity transaction) {
        repo.updateIncreaseBalance(transaction.getUserDestiny().getLogin(), transaction.getValue());
    }

    private void decreaseBalance(TransactionEntity transaction, Boolean isCreditCard) {
        if (!isCreditCard)
            repo.updateDecreaseBalance(transaction.getUserOrigin().getLogin(), transaction.getValue());

    }
}
