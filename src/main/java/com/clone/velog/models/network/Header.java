package com.clone.velog.models.network;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonAutoDetect
@Builder
public class Header<T> {

    private LocalDateTime transactionTime;

    private String resultCode;

    private String description;

    private T data;

    public static <T> Header<T> OK(){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    public static <T> Header<T> OK(T data) { // 통신객체를 만듬
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    public static <T> Header<T> ERROR(String description) {
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(description)
                .build();
    }

    public static <T> Header<T> ERROROfNull() {
        return (Header<T>) Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description(null)
                .build();
    }
}
