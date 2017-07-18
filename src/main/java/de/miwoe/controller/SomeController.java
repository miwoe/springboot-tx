package de.miwoe.controller;

import de.miwoe.model.MyEntity;
import de.miwoe.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by mwoelm on 15.07.17.
 */
@RestController
@RequestMapping("test")
public class SomeController {

    @Autowired
    EntityService entityService;

    public void add(MyEntity entity) {

    }
}
