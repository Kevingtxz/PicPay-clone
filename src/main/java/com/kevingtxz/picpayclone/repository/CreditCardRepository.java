package com.kevingtxz.picpayclone.repository;

import com.kevingtxz.picpayclone.entity.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCardEntity, Integer> {}
