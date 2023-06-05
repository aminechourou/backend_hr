package com.supportportal;

import com.supportportal.domain.Mission;
import com.supportportal.domain.Projet;
import com.supportportal.domain.User;
import com.supportportal.repository.MissionRepository;
import com.supportportal.repository.ProjetRepository;
import com.supportportal.service.impl.MissionServiceImpl;
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
public class MissionTests {
    @Mock
    MissionRepository fr;
    @InjectMocks
    MissionServiceImpl fs;
    Mission p =new Mission(new Long(444), "ddddddd", "dddddd", "eeeeeee");
    @Test
    @Order(0)
    void TestaddMission() {
        Mission fo = new Mission();
        List<Mission> Missions = new ArrayList<>();
        for (Long i=1L;i<=10L;i++) {
            fo.setId(i);
            fo.setFeedBackManager("ad5Sxcs45");
            fo.setAutoEval("54jrs");

            Mission ca=fr.save(fo);
            Missions.add(ca);
        }
        assertEquals(10,Missions.size());
    }

    @Test
    @Order(2)
    void TestdeleteAllMission() {
        fr.deleteAll();
        assertEquals(0,fr.findAll().spliterator().estimateSize());
    }

    @Test
    @Order(3)
    void TestgetAllMission(){
        Iterable<Mission> Missions = fr.findAll();
        Assertions.assertNotNull(Missions);
    }
}
