package com.ai.ai.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class SellDto {

    Long id;

    Long customerId;
    Long itemId;
    int amount;

    String sellDate;
}
