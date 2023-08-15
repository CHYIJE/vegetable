package com.baleun.vegetablestore.domain.auth.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baleun.vegetablestore.domain.auth.dto.ReqJoinDTO;
import com.baleun.vegetablestore.domain.auth.dto.ReqLoginDTO;
import com.baleun.vegetablestore.domain.auth.service.AuthServiceApiV1;

import jakarta.servlet.http.HttpSession;




@RestController
@RequestMapping("/api/v1/auth") // controller랑 같은 join을 
public class AuthControllerApiV1 {

    @Autowired //restcontroller에 new를 안쓰고 끌어오기 위해 
    private AuthServiceApiV1 authServiecApiV1;

    @PostMapping("/join")
    public ResponseEntity<?> join(@RequestBody ReqJoinDTO dto){

        ResponseEntity<?> responseEntity = authServiecApiV1.join(dto);

        return responseEntity;
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody ReqLoginDTO dto, HttpSession session){
        // session을 쓰는 이유  해당 요청한 유저의 정보가 들
        return authServiecApiV1.login(dto, session);
    }


    public static void main(String[] args) {
        
        // AuthControllerApiV1 authControllerApiV1 = new Auth
// 
        // JoinUserDTO joinUserDTO = new JoinUserDTO("asdf", 
// 
        // ReqJoinDTO reqJoinDTO = new ReqJoinDTO(joinUserDTO
// 
        // ResponseEntity<?> responseEntity = authControllerA

    }
}
