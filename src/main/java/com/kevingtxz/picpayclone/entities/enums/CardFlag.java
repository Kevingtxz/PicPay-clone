package com.kevingtxz.picpayclone.entities.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public enum CardFlag {
    VISA(1, "Visa"),
    MASTERCARD(2, "Master Card"),
    ELO(3, "Elo");

    private int cod;
    private String description;

    public static CardFlag toEnum(Integer cod) {
        if (cod == null) return null;
        for (CardFlag cardFlag : CardFlag.values())
            if (cod.equals(cardFlag.getCod()))
                return cardFlag;
        throw new IllegalStateException("Invalid ID: " + cod);
    }
}
