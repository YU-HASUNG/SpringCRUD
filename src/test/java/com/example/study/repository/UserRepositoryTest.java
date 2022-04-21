package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@WebAppConfiguration
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
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-1111");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println(newUser);

    }

    @Test
    @Transactional
    public void read(){
        Optional<User> user = userRepository.findByAccount("TestUser01");

        user.ifPresent(selectUser ->{
            selectUser.getOrderDetailList().stream().forEach(detail ->{
                Item item = detail.getItem();
                System.out.println(detail.getItem());
            });
        });
    }

    @Test
    public void update(){
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser ->{
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional //test 실행하고 다시 롤백해주는 기능
    public void delete(){
        Optional<User> user = userRepository.findById(3L);

        Assert.assertTrue(user.isPresent()); //반드시 존재해야 하기에, Assert로 확인

        user.ifPresent(selectUser ->{
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        Assert.assertFalse(deleteUser.isPresent());

        /*
        if(deleteUser.isPresent()){
            System.out.println("데이터 존재 : "+deleteUser.get());
        }
        else {
            System.out.println("데이터 삭제");
        }
        */
    }

}

