package com.kevingtxz.picpayclone.entities;

import com.kevingtxz.picpayclone.entities.enums.CardFlag;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TRANSACTIONS")
public class TransactionEntity extends EntityBase implements Serializable {
    public static final long serialVersionUID = 1L;

    @Column(name = "TR_CODE", nullable = false)
    private String code;
    @Column(name = "TR_DATETIME", nullable = false)
    private LocalDateTime dateTime;
    @Column(name = "TR_VALUE", nullable = false)
    private Double value;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "TR_USER_ORIGIN_ID", nullable = false)
    private UserEntity userOrigin;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "TR_USER_DESTINY_ID")
    private UserEntity userDestiny;
}
