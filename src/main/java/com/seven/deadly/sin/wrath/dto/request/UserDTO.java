package com.seven.deadly.sin.wrath.dto.request;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String name;
    private int age;
    private String username;
    private String alias;
}
