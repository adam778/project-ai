package com.ai.ai.Database;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@ToString(includeFieldNames = true)
class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;

    public Item() {
    }

    Item(String name) {
        this.name = name;
    }

    Long getId() {
        return id;
    }
}
