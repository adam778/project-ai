package com.ai.ai.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ClientDto {
    Long id;

    String name;
    String surname;
    String companyName;

    String adress;
    String phone;
    String email;

}
