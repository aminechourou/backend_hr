package com.supportportal;

import com.supportportal.domain.Projet;
import com.supportportal.domain.User;
import com.supportportal.repository.ProjetRepository;
import com.supportportal.service.impl.ProjetServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProjetTests {
    @Mock
    ProjetRepository fr;
    @InjectMocks
    ProjetServiceImpl fs;
    Projet p =new Projet(new Long(444), "ddddddd", "dddddd", "eeeeeee", "1", "dddd", new User());
    @Test
    @Order(0)
    void TestaddProjet() {
        Projet fo = new Projet();
        List<Projet> Projets = new ArrayList<>();
        for (Long i=1L;i<=10L;i++) {
            fo.setId(i);
            fo.setTitre("ad5Sxcs45");
            fo.setDure("54jrs");

            Projet ca=fr.save(fo);
            Projets.add(ca);
        }
        assertEquals(10,Projets.size());
    }

    @Test
    @Order(2)
    void TestdeleteAllProjet() {
        fr.deleteAll();
        assertEquals(0,fr.findAll().spliterator().estimateSize());
    }

    @Test
    @Order(3)
    void TestgetAllProjet(){
        Iterable<Projet> Projets = fr.findAll();
        Assertions.assertNotNull(Projets);
    }
}
