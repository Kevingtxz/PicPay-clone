package com.kevingtxz.picpayclone.repository;

import com.kevingtxz.picpayclone.entity.TransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Integer> {

    Page<TransactionEntity> findByUserOrigin_LoginOrUserDestiny_Login(String login, String login1, Pageable pagination);
}
