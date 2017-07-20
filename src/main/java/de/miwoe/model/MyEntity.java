package de.miwoe.model;

import de.miwoe.enums.MyStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
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

    @OneToMany(mappedBy = "myEntity", cascade = CascadeType.ALL)
    private List<Item> itemSet = new ArrayList<>();

    private String someValue;

    MyStatus status;
}
