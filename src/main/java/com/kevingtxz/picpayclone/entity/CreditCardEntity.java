package com.kevingtxz.picpayclone.entity;

import com.kevingtxz.picpayclone.entity.abstractbase.EntityBase;
import com.kevingtxz.picpayclone.entity.enums.CardFlag;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CREDIT_CARDS")
public class CreditCardEntity extends EntityBase implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name = "CC_NUMBER", nullable = false)
    private String number;
    @Enumerated(EnumType.STRING)
    @Column(name = "CC_FLAG", nullable = false)
    private CardFlag flag;
    @Column(name = "CC_TOKEN")
    private String numberToken;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "CC_USER_ID", nullable = false)
    private UserEntity user;
}
