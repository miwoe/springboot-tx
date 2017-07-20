package de.miwoe.service;

import de.miwoe.model.Item;
import de.miwoe.model.MyEntity;
import de.miwoe.model.SomeOtherEntity;
import de.miwoe.repository.MyEntityRepository;
import de.miwoe.repository.SomeOtherEntityRepository;
import org.fluttercode.datafactory.impl.DataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import java.util.List;
import java.util.UUID;

/**
 * Created by mwoelm on 18.07.17.
 */
@Service
public class EntityService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MyEntityRepository myEntityRepository;

    @Autowired
    SomeOtherEntityRepository someOtherEntityRepository;

    @Autowired
    DataFactory dataFactory;

    @Autowired
    PlatformTransactionManager txManager;

    public void addEntityWithoutTransaction(MyEntity myEntity) {
        log.debug("addEntityWithoutTransaction start");
        myEntityRepository.save(myEntity);
//        if (true) throw new RuntimeException("Test BÄM"); // If in: The Entity is saved due to missing transaction
        log.debug("addEntityWithoutTransaction end");
    }

    @Transactional
    public void addEntityTransaction(MyEntity myEntity) {
        log.debug("addEntityTransaction start");
        myEntityRepository.save(myEntity);
//        if (true) throw new RuntimeException("Test BÄM"); // If in: The Entity is not saved due to transaction rollback
        log.debug("addEntityTransaction end");
    }

    @Transactional
    public void addEntityPlusSomeOther(MyEntity myEntity) {
        log.debug("addEntityPlusSomeOther start");
        myEntityRepository.save(myEntity);

        SomeOtherEntity someOtherEntity = SomeOtherEntity.builder()
                .id(UUID.randomUUID())
                .name(dataFactory.getRandomWord(10))
                .build();

        someOtherEntityRepository.save(someOtherEntity);
        log.debug("addEntityPlusSomeOther end");
    }

    public void addEntityPlusSomeOtherWithTransaction(MyEntity myEntity) {
        log.debug("addEntityPlusSomeOtherWithTransaction start");
        myEntityRepository.save(myEntity);

        SomeOtherEntity someOtherEntity = SomeOtherEntity.builder()
                .id(UUID.randomUUID())
                .name(dataFactory.getRandomText(10))
                .build();

        someOtherEntityRepository.save(someOtherEntity);
        log.debug("addEntityPlusSomeOtherWithTransaction end");
    }

    @Transactional
    public void getAllEntities() {
        List<MyEntity> myEntities = myEntityRepository.findAll();
        myEntities.forEach(entity -> entity.getItemSet().forEach(item -> System.out.println(item.getName())));
    }
}
