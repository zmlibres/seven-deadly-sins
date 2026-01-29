package com.seven.deadly.sin.wrath.dto.common;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseDTO<T> {

    private T body;
    private String message;

    public static <T> ResponseDTO<T> of(T body) {
        return ResponseDTO.<T>builder()
                .body(body)
                .message("success")
                .build();
    }
}
