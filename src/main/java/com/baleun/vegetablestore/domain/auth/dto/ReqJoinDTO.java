package com.baleun.vegetablestore.domain.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReqJoinDTO {
        private User user;

        @AllArgsConstructor
        @NoArgsConstructor
        @Getter
        public static class User{
        private String id;
        private String password;
        }
}
