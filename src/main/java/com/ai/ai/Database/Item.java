package com.ai.ai.Database;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Items")
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;


    Item(String name) {
        this.name = name;
    }

    Long getId() {
        return id;
    }
}
