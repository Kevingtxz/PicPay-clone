package com.kevingtxz.picpayclone.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS")
public class UserEntity extends EntityBase implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name = "USER_LOGIN", nullable = false)
    private String login;
    @Column(name = "USER_PASSWORD", nullable = false)
    private String password;
    @Column(name = "USER_EMAIL", nullable = false)
    private String email;
    @Column(name = "USER_FULL_NAME", nullable = false)
    private String fullName;
    @Column(name = "USER_CPF", nullable = false)
    private String cfp;
    @Column(name = "USER_BIRTH_DATE", nullable = false)
    private LocalDate birthDate;
    @Column(name = "USER_PHONE_NUMBER", nullable = false)
    private String phoneNumber;
    @Column(name = "USER_BALANCE", nullable = false)
    private Double balance;
    @Column(name = "USER_ACTIVE", nullable = false)
    private Boolean active;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<CreditCardEntity> creditCardList;
}
