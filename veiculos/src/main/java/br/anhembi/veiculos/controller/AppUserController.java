package br.anhembi.veiculos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.anhembi.veiculos.dto.AppUserDto;
import br.anhembi.veiculos.security.AppUser;
import br.anhembi.veiculos.service.AppUserService;

@RestController
@RequestMapping("/user")
public class AppUserController {
    
    @Autowired
    private AppUserService service;

    @PostMapping
    public ResponseEntity<AppUser> create(@RequestBody AppUserDto userDto) {
         AppUser createUser = service.createUser(userDto.getUsername(), userDto.getPassword());

        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }
}
