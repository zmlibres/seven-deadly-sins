package com.seven.deadly.sin.wrath.dto.response;

import com.seven.deadly.sin.wrath.dto.common.enums.Status;
import com.seven.deadly.sin.wrath.entity.User;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

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
    private String createdBy;
    private Date createdDate;
    private String updatedBy;
    private Date updatedDate;
}
