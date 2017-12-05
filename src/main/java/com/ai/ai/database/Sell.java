package com.ai.ai.database;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Sells")
@Builder
@NoArgsConstructor
@AllArgsConstructor
class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long customerId;
    Long itemId;
    int amount;

    String sellDate;

    Sell(Long customerId, Long itemId, int amount, String sellDate) {
        this.customerId = customerId;
        this.itemId = itemId;
        this.amount = amount;
        this.sellDate = sellDate;
    }
}
