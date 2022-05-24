package com.kevingtxz.picpayclone.resource;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseResource<T> {

    protected ResponseEntity<T> resItemCreated(T obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    protected ResponseEntity<T> resItemCreatedWithURL(
            T obj,
            UriComponentsBuilder uriBuilder,
            String path,
            String code) {
        URI uri = uriBuilder.path(path).buildAndExpand(code).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    protected ResponseEntity<T> resItemNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    protected ResponseEntity<T> resSuccess() {
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    protected ResponseEntity<T> resSuccessWithItem(T obj) {
        return ResponseEntity.status(HttpStatus.OK).body(obj);
    }

    protected ResponseEntity<List<T>> resEmptyList() {
        List<T> emptyList = new ArrayList<>();
        return ResponseEntity.status(HttpStatus.OK).body(emptyList);
    }

    protected ResponseEntity<List<T>> resItemList(List<T> items) {
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }

    protected ResponseEntity<T> resUnsuccessfulRequest() {
        return ResponseEntity.badRequest().build();
    }

    protected ResponseEntity<Page<T>> resItemPage(Page<T> items) {
        return ResponseEntity.status(HttpStatus.OK).body(items);
    }
}
