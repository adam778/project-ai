package com.ai.ai.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Builder
@Getter
@Setter
public class SellDto {
    Long id;
    @NotNull(message = "Sell customerId can't be null")
    Long customerId;
    @NotNull(message = "Sell itemId can't be null")
    Long itemId;
    @Positive(message = "Sell amount must be positive")
    int amount;
    @NotBlank(message = "Sell sellDate can't be empty")
    String sellDate;
}
