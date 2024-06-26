package com.xiaoxve.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class UserApplicationTests {

    @Test
    void contextLoads() {
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
//        String encode = bCryptPasswordEncoder.encode("123456");
//        String encode1 = bCryptPasswordEncoder.encode("123456");
//        System.out.println(encode);
//        System.out.println(encode1);
//        System.out.println(bCryptPasswordEncoder.matches("123456", encode));
//        System.out.println(bCryptPasswordEncoder.matches("123456", encode1));
        System.out.println(bCryptPasswordEncoder.matches("123456", "$2a$10$bq5a9eQboArhZrMolUOjhebd9RfOi0AJxNbsP.jz8L5.8wEfwxIGi"));
    }


}
