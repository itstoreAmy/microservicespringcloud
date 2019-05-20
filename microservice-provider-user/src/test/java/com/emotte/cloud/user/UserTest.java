package com.emotte.cloud.user;

import com.emotte.cloud.MicroserviceProviderUserApplication;
import com.emotte.cloud.controller.UserController;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={MicroserviceProviderUserApplication.class,UserTest.class})
public class UserTest {

    @Autowired
    private UserController userController;
//
//    @Autowired
//    private ConfigController configClientController;
//
//    @Test
//    public void testProfile(){
//        String profile = configClientController.getProfile();
//        System.err.println("profile的值为:-----"+profile);
//    }

}
