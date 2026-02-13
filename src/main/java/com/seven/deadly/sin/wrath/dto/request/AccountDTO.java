package com.seven.deadly.sin.wrath.dto.request;


import com.seven.deadly.sin.wrath.dto.common.enums.AccountStatus;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {

    private String accountId;
    private String username;
    private AccountStatus status;

}
