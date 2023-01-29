package com.system.backend.inbound.controller;

import com.system.backend.core.exception.UserExceptionHandler;
import com.system.backend.inbound.dto.UserDTO;
import com.system.backend.inbound.facade.UserFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v01/tcc-spring-api/user")
public class UserController {

    @Autowired
    private UserFacade userFacade;

    @PostMapping(value = "/create")
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        if (userDTO != null) {
            userFacade.createUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        log.error("Empty body, please make sure that your body is present");
        throw UserExceptionHandler.UserException004_EmptyBody();
    }
}
