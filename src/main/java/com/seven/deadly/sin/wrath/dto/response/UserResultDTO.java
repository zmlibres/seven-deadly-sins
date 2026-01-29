package com.seven.deadly.sin.wrath.dto.response;

import com.seven.deadly.sin.wrath.dto.common.enums.Status;
import com.seven.deadly.sin.wrath.entity.User;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResultDTO {
    private String id;
    private String name;
    private int age;
    private String username;
    private String alias;
    private Status status;

    public static UserResultDTO from(User user) {
        return UserResultDTO.builder()
                            .id(String.valueOf(user.getUserId()))
                            .name(user.getName())
                            .age(user.getAge())
                            .username(user.getUsername())
                            .alias(user.getAlias())
                            .status(user.getStatus())
                            .build();
    }
}
