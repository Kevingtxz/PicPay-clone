package com.kevingtxz.picpayclone.service;

import com.kevingtxz.picpayclone.dto.TransactionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITransactionService {

    TransactionDTO process(TransactionDTO objDto);

    Page<TransactionDTO> findPage(Pageable pagination, String login);
}
