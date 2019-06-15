package com.parkview.controller;

import com.parkview.dao.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/v2")
public class UserController {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    @GetMapping(value = "/users", produces = "application/json")
    public ResponseEntity<User> getUser (RequestEntity<User> request){
        ResponseEntity<User> responseEntity = null;
        HttpEntity<User> newRequest = new HttpEntity<>(new User(1L, "Nigel", "secret", "nigel.norman@gmail.com" ));
        logger.info("request body : " + newRequest.getBody().getName());

        HttpHeaders headers = request.getHeaders();
        logger.info("request headers : " + headers);
        logger.info("request url :" + request.getUrl());

        responseEntity = new ResponseEntity<>(newRequest.getBody(), headers, HttpStatus.OK);

        return responseEntity;
    }
}
