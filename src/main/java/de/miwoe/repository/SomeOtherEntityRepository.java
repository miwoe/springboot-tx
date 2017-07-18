package de.miwoe.repository;

import de.miwoe.model.SomeOtherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by mwoelm on 18.07.17.
 */
public interface SomeOtherEntityRepository extends JpaRepository<SomeOtherEntity, UUID>{

}
