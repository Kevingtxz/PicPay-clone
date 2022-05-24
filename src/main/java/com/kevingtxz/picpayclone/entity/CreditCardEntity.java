package com.kevingtxz.picpayclone.entity;

import com.kevingtxz.picpayclone.entity.enums.CardFlag;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "CREDIT_CARDS")
public class CreditCardEntity extends EntityBase implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name = "CC_NUMBER", nullable = false)
    private String number;
    @Enumerated(EnumType.STRING)
    @Column(name = "CC_FLAG")
    private CardFlag flag;
    @Column(name = "CC_TOKEN")
    private String numberToken;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "CC_USER_ID", nullable = false)
    private UserEntity user;
}
