package de.miwoe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.UUID;

/**
 * Created by mwoelm on 20.07.17.
 */
@Entity
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Item {

    @Id
    UUID id;

    private String name;

    @ManyToOne
    MyEntity myEntity;
}
