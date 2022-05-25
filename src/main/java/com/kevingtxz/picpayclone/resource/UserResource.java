package com.kevingtxz.picpayclone.resource;

import com.kevingtxz.picpayclone.dto.UserDTO;
import com.kevingtxz.picpayclone.resource.abstractbase.ResourceBase;
import com.kevingtxz.picpayclone.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource extends ResourceBase<UserDTO> {

    @Autowired
    private IUserService service;


    @GetMapping("/{login}")
    public ResponseEntity<UserDTO> findByLogin(
            @PathVariable String login) {
        UserDTO objDto = service.findByLogin(login);
        return resSuccessWithItem(objDto);
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<UserDTO>> findAll(
            @RequestParam String login) {
        List<UserDTO> objDtoList = service.findAllByLoginNotEqual(login);
        return resItemList(objDtoList);
    }

    @GetMapping("/{login}/balance")
    public ResponseEntity<UserDTO> findBalanceByLogin(
            @PathVariable String login) {
        UserDTO objDto = service.findByLogin(login);
        return resSuccessWithItem(objDto);
    }
}
