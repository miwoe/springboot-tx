package de.miwoe.service;

import de.miwoe.model.MyEntity;
import de.miwoe.model.SomeOtherEntity;
import de.miwoe.repository.MyEntityRepository;
import de.miwoe.repository.SomeOtherEntityRepository;
import org.fluttercode.datafactory.impl.DataFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void addEntityWithoutTransaction(MyEntity myEntity) {
        log.debug("addEntityWithoutTransaction start");
        myEntityRepository.save(myEntity);
        log.debug("addEntityWithoutTransaction end");
    }

    @Transactional
    public void addEntityTransaction(MyEntity myEntity) {
        log.debug("addEntityTransaction start");
        myEntityRepository.save(myEntity);
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
}
