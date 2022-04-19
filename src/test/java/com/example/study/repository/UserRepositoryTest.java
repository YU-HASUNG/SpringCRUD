package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class UserRepositoryTest extends StudyApplicationTests {

    //Dependency Injection (DI)
    @Autowired
    private UserRepository userRepository;

    @Test
    public void create(){
        User user = new User();
        // user.setId();
        // mysql에서 id의 경우 auto increment이기 때문에 데이터베이스에서 자동으로 숫자를 올리기 때문에 지정할 필요 없음
        user.setAccount("TestUser01");
        user    .setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println(newUser);

    }

    public void read(){

    }

    public void update(){

    }

}

