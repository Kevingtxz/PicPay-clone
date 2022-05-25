package com.kevingtxz.picpayclone.service;

import com.kevingtxz.picpayclone.dto.UserDTO;
import com.kevingtxz.picpayclone.entity.TransactionEntity;
import com.kevingtxz.picpayclone.entity.UserEntity;

import java.util.List;

public interface IUserService {

    UserDTO findByLogin(String login);

    UserEntity findByLoginEntity(String login);

    void validate(UserEntity... users);

    void updateBalance(TransactionEntity transaction, Boolean isCreditCard);

    List<UserDTO> findAllByLoginNotEqual(String login);
}
