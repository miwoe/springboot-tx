package de.miwoe.service;

import de.miwoe.model.MyEntity;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static org.junit.Assert.*;

/**
 * Created by mwoelm on 18.07.17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EntityServiceTest {

    @Autowired
    EntityService entityService;

    @Autowired
    DataFactory dataFactory;

    @Test
    public void addEntityWithoutTransaction() throws Exception {
        entityService.addEntityWithoutTransaction(getMyEntity());
    }


    @Test
    public void addEntityTransaction() throws Exception {
        entityService.addEntityTransaction(getMyEntity());
    }

    @Test
    public void addEntityPlusSomeOther() throws Exception {
        entityService.addEntityPlusSomeOther(getMyEntity());
    }

    @Test
    public void addEntityPlusSomeOtherWithTransaction() throws Exception {
        entityService.addEntityPlusSomeOtherWithTransaction(getMyEntity());
    }

    private MyEntity getMyEntity() {
        return MyEntity.builder()
                .id(UUID.randomUUID())
                .name(dataFactory.getRandomText(10))
                .build();
    }


}