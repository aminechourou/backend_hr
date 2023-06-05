package com.supportportal;

import com.supportportal.domain.Projet;
import com.supportportal.domain.User;
import com.supportportal.repository.ProjetRepository;
import com.supportportal.repository.UserRepository;
import com.supportportal.service.impl.ProjetServiceImpl;
import com.supportportal.service.impl.UserServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserTests {
    @Mock
    UserRepository fr;
    @InjectMocks
    UserServiceImpl fs;
    User p =new User(new Long("44445"), "adaad", "dadadad", "dadadada", "dadadadaadad", "ddjad", "dhadhad");
    @Test
    @Order(0)
    void TestaddUser() {
        User fo = new User();
        List<User> Users = new ArrayList<>();
        for (Long i=1L;i<=10L;i++) {
            fo.setId(i);
            fo.setUsername("ad5Sxcs45");
            fo.setFirstName("54jrs");

            User ca=fr.save(fo);
            Users.add(ca);
        }
        assertEquals(10,Users.size());
    }

    @Test
    @Order(2)
    void TestdeleteAllUser() {
        fr.deleteAll();
        assertEquals(0,fr.findAll().spliterator().estimateSize());
    }

    @Test
    @Order(3)
    void TestgetAllUser(){
        Iterable<User> Users = fr.findAll();
        Assertions.assertNotNull(Users);
    }

}
