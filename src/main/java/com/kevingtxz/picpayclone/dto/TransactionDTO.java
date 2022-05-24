package com.kevingtxz.picpayclone.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionDTO {

    @NotBlank
    private String code;
    @NotNull
    private UserDTO userOrigin;
    @NotNull
    private LocalDateTime dateTime;
    @NotNull
    private UserDTO userDestiny;
    private CreditCardDTO creditCard;
    private Boolean isCreditCard = false;
}
