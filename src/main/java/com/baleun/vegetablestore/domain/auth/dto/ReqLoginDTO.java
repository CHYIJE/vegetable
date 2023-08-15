package com.baleun.vegetablestore.domain.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReqLoginDTO {
    private User user;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class User {

        @NotBlank
        private String id;

        @NotBlank
        private String password;
    }
}
