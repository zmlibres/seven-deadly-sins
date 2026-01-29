package com.seven.deadly.sin.wrath.controller;

import com.seven.deadly.sin.wrath.dto.common.PageResponseDTO;
import com.seven.deadly.sin.wrath.dto.request.UserDTO;
import com.seven.deadly.sin.wrath.dto.response.UserResultDTO;
import com.seven.deadly.sin.wrath.service.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResultDTO> getUserById(@PathVariable("id") String id) {

        UserResultDTO result = userService.getUserById(id);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody UserDTO request) {

        userService.saveUser(request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<PageResponseDTO<UserResultDTO>> getAllUser(Pageable pageable) {

        return ResponseEntity.ok(userService.getAllUser(pageable));

    }
}
