package com.ai.ai.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
public class ItemDto {
    Long id;
    @NotBlank(message = "Item name can't be empty")
    String name;
}
