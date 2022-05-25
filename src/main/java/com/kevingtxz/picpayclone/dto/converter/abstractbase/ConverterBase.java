package com.kevingtxz.picpayclone.dto.converter.abstractbase;

import java.util.ArrayList;
import java.util.List;

public abstract class ConverterBase<E, D> {

    public abstract D toDto(E obj);

    public abstract E toEntity(D dto);

    public List<E> toEntityList(List<D> dtoList) {
        List<E> objList = new ArrayList<>();
        dtoList.stream().forEach(dto -> objList.add(toEntity(dto)));
        return objList;
    }

    public List<D> toDtoList(List<E> objList) {
        List<D> dtoList = new ArrayList<>();
        objList.stream().forEach(obj -> dtoList.add(toDto(obj)));
        return dtoList;
    }
}
