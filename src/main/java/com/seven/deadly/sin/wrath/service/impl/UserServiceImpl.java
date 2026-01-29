package com.seven.deadly.sin.wrath.service.impl;

import com.seven.deadly.sin.wrath.dto.common.PageResponseDTO;
import com.seven.deadly.sin.wrath.dto.common.enums.Status;
import com.seven.deadly.sin.wrath.dto.request.UserDTO;
import com.seven.deadly.sin.wrath.dto.response.UserResultDTO;
import com.seven.deadly.sin.wrath.entity.User;
import com.seven.deadly.sin.wrath.exception.ResourceNotFoundException;
import com.seven.deadly.sin.wrath.repository.UserRepository;
import com.seven.deadly.sin.wrath.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResultDTO getUserById(String id) {

        User user = userRepository.findUserByUserId(id)
                .orElseThrow(() -> new ResourceNotFoundException("user not found."));

        return UserResultDTO.builder()
                            .id(user.getUserId())
                            .name(user.getName())
                            .age(user.getAge())
                            .username(user.getUsername())
                            .alias(user.getAlias())
                            .status(user.getStatus())
                            .build();

    }

    @Override
    public void saveUser(UserDTO request) {

        userRepository.save(User.builder()
                                .userId(UUID.randomUUID().toString())
                                .username(request.getUsername())
                                .name(request.getName())
                                .alias(request.getAlias())
                                .age(request.getAge())
                                .status(Status.ACTIVE)
                                .build());
    }

    @Override
    public PageResponseDTO<UserResultDTO> getAllUser(Pageable pageable) {

        Page<User> page = userRepository.findAll(pageable);

        List<UserResultDTO> content = page.getContent().stream().map(UserResultDTO::from).toList();

        return PageResponseDTO.<UserResultDTO>builder()
                .content(content)
                .page(page.getNumber())
                .size(page.getSize())
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .build();

    }
}
