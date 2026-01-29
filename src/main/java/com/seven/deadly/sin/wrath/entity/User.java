package com.seven.deadly.sin.wrath.entity;


import com.seven.deadly.sin.wrath.dto.common.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id", nullable = false, unique = true, updatable = false)
    private String userId;

    @Column(name = "user_name", nullable = false, unique = true, updatable = false)
    private String username;

    private String alias;

    private String name;

    private int age;

    private Status status;

    private UUID getRandomUUID() {
        return UUID.randomUUID();
    }


}
