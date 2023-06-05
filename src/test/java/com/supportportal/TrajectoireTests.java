package com.supportportal;

import com.supportportal.domain.Mission;
import com.supportportal.domain.Trajectoire;
import com.supportportal.repository.MissionRepository;
import com.supportportal.repository.TrajectoireRepository;
import com.supportportal.service.impl.MissionServiceImpl;
import com.supportportal.service.impl.TrajectoireServiceImpl;
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
public class TrajectoireTests {
    @Mock
    TrajectoireRepository fr;
    @InjectMocks
    TrajectoireServiceImpl fs;
    Trajectoire p =new Trajectoire(new Long(444), "ddddddd", "dddddd", "eeeeeee");
    @Test
    @Order(0)
    void TestaddTrajectoire() {
        Trajectoire fo = new Trajectoire();
        List<Trajectoire> Trajectoires = new ArrayList<>();
        for (Long i=1L;i<=10L;i++) {
            fo.setId(i);
            fo.setProgression_tech("ad5Sxcs45");
            fo.setProgression_visee("54jrs");

            Trajectoire ca=fr.save(fo);
            Trajectoires.add(ca);
        }
        assertEquals(10,Trajectoires.size());
    }

    @Test
    @Order(2)
    void TestdeleteAllTrajectoire() {
        fr.deleteAll();
        assertEquals(0,fr.findAll().spliterator().estimateSize());
    }

    @Test
    @Order(3)
    void TestgetAllTrajectoire(){
        Iterable<Trajectoire> Trajectoires = fr.findAll();
        Assertions.assertNotNull(Trajectoires);
    }
}
