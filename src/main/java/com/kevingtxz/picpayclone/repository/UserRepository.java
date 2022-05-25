package com.kevingtxz.picpayclone.repository;

import com.kevingtxz.picpayclone.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Transactional(readOnly = true)
    UserEntity findByLogin(String login);

    @Modifying
    @Transactional
    @Query("UPDATE UserEntity obj set obj.balance = obj.balance + :value WHERE obj.login = :login")
    void updateIncreaseBalance(@Param("login") String login, @Param("value") Double value);

    @Modifying
    @Transactional
    @Query("UPDATE UserEntity obj set obj.balance = obj.balance - :value WHERE obj.login = :login")
    void updateDecreaseBalance(String login, Double value);
}
