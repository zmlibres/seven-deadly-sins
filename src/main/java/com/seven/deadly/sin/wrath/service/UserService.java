package com.seven.deadly.sin.wrath.service;

import com.seven.deadly.sin.wrath.dto.common.PageResponseDTO;
import com.seven.deadly.sin.wrath.dto.request.UserDTO;
import com.seven.deadly.sin.wrath.dto.response.UserResultDTO;
import org.springframework.data.domain.Pageable;

public interface UserService {

    UserResultDTO getUserById(String id);

    String saveUser(UserDTO request);

    PageResponseDTO<UserResultDTO> getAllUser(Pageable pageable);

    UserResultDTO putUser(String id, UserDTO request);

    void deleteUser(String id);
}
