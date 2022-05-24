package com.kevingtxz.picpayclone.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @NotBlank
    private String login;
    private String password;
    private String email;
    private String fullName;
    private String cpf;
    private String phoneNumber;
    private Double balance;
    private LocalDate birthDate;
}
