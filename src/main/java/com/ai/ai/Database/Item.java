package com.ai.ai.Database;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Items")
@Builder
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
