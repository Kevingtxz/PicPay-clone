package com.kevingtxz.picpayclone.resource;

import com.kevingtxz.picpayclone.dto.TransactionDTO;
import com.kevingtxz.picpayclone.resource.abstractbase.ResourceBase;
import com.kevingtxz.picpayclone.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/transactions")
public class TransactionResource extends ResourceBase<TransactionDTO> {

    @Autowired
    private ITransactionService service;


    @GetMapping
    public ResponseEntity<Page<TransactionDTO>> findPage(
            @PageableDefault(page = 0, size = 20) Pageable pagination,
            @RequestParam String login) {
        Page<TransactionDTO> objDtoPage = service.findPage(pagination, login);
        return this.resItemPage(objDtoPage);
    }

    @PostMapping
    public ResponseEntity<TransactionDTO> save(
            @RequestBody @Valid TransactionDTO objDto,
            UriComponentsBuilder uriBuilder) {
        TransactionDTO objCreated = service.process(objDto);
        return resItemCreatedWithURL(objCreated, uriBuilder, "/transactions/{code}", objCreated.getCode());
    }
}
