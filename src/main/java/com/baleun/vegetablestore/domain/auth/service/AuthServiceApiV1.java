package com.baleun.vegetablestore.domain.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baleun.vegetablestore.domain.auth.dto.ReqJoinDTO;
import com.baleun.vegetablestore.domain.auth.dto.ReqLoginDTO;
import com.baleun.vegetablestore.model.user.entity.UserEntity;
import com.baleun.vegetablestore.model.user.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class AuthServiceApiV1 {

    @Autowired // db를 가져오기 위해서 
    private UserRepository userRepository; // user정보를 가져온다 
    
    // 회원가입
    @Transactional  //데이터베이스를 넣을 때는 꼭 넣어야함
    public ResponseEntity<?> join(ReqJoinDTO reqJoinDTO) {

        // 유저가 제대로된 데이터를 보냈는지 확인
        if(reqJoinDTO.getUser().getId() == null){
          return new ResponseEntity<>(
            "아이디를 입력해주세요.",
            HttpStatus.BAD_REQUEST
        );  
    }

    if(reqJoinDTO.getUser().getId().length() < 3) {
          return new ResponseEntity<>(
            "아이디는 3글자 이상 입력해주세요.",
            HttpStatus.BAD_REQUEST
        );     
    }

        // DB에 넣기 전에 해당 id를 가진 유저가 잇는지 찾고
        Optional<UserEntity> userEntityOptional = userRepository.findById(reqJoinDTO.getUser().getId());

        // 있으면 이미 사용중인 아이디 입니다 라는 메세지 보내주기
        if(userEntityOptional.isPresent()){ //present:존재하면
            return new ResponseEntity<>(
            "이미 사용중인 아이디입니다.",
            HttpStatus.BAD_REQUEST
            );
        }
        
        

        //DTO를 USERENTITY로 바꿔야한다
        UserEntity userEntity = new UserEntity(null, reqJoinDTO.getUser().getId(), reqJoinDTO.getUser().getPassword(), null, null, null, null);


        userRepository.save(userEntity);
        //insert into user values(...)

        return new ResponseEntity<>(
            "회원가입에 성공했습니다.",
            HttpStatus.OK
        );

    }
    
    // 로그인
    @Transactional
    public ResponseEntity<?> login(ReqLoginDTO dto, HttpSession session){

        Optional<UserEntity> userEntityOptional = userRepository.findById(dto.getUser().getId());

        // 엔티티가 null이면 아이디를 잘못 입력한것
        if (userEntityOptional.isEmpty()) {
            return new ResponseEntity<>(
                "해당 아이디가 존재하지 않습니다.",
                HttpStatus.BAD_REQUEST
            );
        }

        // 옵셔널에서 유저엔티티 가져오기
        UserEntity userEntity = userEntityOptional.get();

        // 비밀번호 체크해서 다르면 잘못 입력한 것
        if (!userEntity.getPassword().equals((dto.getUser().getPassword()))){
            return new ResponseEntity<>(
            "비밀번호가 일치하지 않습니다.",
             HttpStatus.BAD_REQUEST
            );
        }

        // 인증 완료. 세션에 유저 정보 입력 
        session.setAttribute("userIdx", userEntity.getIdx());
        session.setAttribute("userId", userEntity.getId());

        return new ResponseEntity<>(
            "로그인에 성공하였습니다.",
            HttpStatus.OK);
    };
}
