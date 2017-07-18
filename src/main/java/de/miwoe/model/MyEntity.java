package de.miwoe.model;

import de.miwoe.enums.MyStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * Created by mwoelm on 15.07.17.
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyEntity {

    @Id
    UUID id;

    private String name;

    private String someValue;

    MyStatus status;
}
