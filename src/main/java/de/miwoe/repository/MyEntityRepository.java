package de.miwoe.repository;

import de.miwoe.model.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Created by mwoelm on 18.07.17.
 */
@Transactional
public interface MyEntityRepository extends JpaRepository<MyEntity, UUID> {
}
