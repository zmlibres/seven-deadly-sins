package com.seven.deadly.sin.wrath.controller;

import com.seven.deadly.sin.wrath.dto.common.PageResponseDTO;
import com.seven.deadly.sin.wrath.dto.request.UserDTO;
import com.seven.deadly.sin.wrath.dto.response.UserResultDTO;
import com.seven.deadly.sin.wrath.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;


@RestController
@RequestMapping("/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<PageResponseDTO<UserResultDTO>> getAllUser(Pageable pageable) {
        return ResponseEntity.ok(userService.getAllUser(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResultDTO> getUserById(@PathVariable("id") String id) {

        UserResultDTO result = userService.getUserById(id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserDTO request) throws URISyntaxException {
        String id = userService.saveUser(request);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                                             .path("/{id}")
                                             .buildAndExpand(id)
                                             .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResultDTO> updateUser(@PathVariable("id") String id, UserDTO request) {

        return new ResponseEntity<>(userService.putUser(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {

        userService.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
