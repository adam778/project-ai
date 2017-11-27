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
