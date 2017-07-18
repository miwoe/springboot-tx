package de.miwoe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by mwoelm on 18.07.17.
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SomeOtherEntity {

    @Id
    UUID id;

    private String name;
}
