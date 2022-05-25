package com.kevingtxz.picpayclone.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kevingtxz.picpayclone.entity.enums.CardFlag;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardDTO {

    @NotBlank
    private String securityCode;
    @NotBlank
    private String expirationDate;
    @NotBlank
    private String ownerName;
    @NotBlank
    private CardFlag flag;
    @NotNull
    private UserDTO user;
    private String number;
    private String numberToken;
    private Boolean isSave = false;

}
