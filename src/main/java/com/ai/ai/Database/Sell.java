package com.ai.ai.Database;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Sells")
@Builder
class Sell {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    Long customerId;
    Long itemId;
    int amount;

    String sellDate;

    public Sell() {
    }

    Sell(Long customerId, Long itemId, int amount, String sellDate) {
        this.customerId = customerId;
        this.itemId = itemId;
        this.amount = amount;
        this.sellDate = sellDate;
    }
}
