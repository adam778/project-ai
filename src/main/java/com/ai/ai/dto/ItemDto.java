package com.ai.ai.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
public class ItemDto {
    @NotNull(message = "Item id can't be null")
    Long id;
    @NotBlank(message = "Item name can't be empty")
    String name;
}
