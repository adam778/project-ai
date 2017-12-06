package com.ai.ai.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
public class ClientDto {
    //Zakładam, że klient zawsze ma imię i nazwisko a nazwa firmy jest opcjonalna.

    Long id;

    @NotBlank(message = "Client name can't be empty")
    String name;

    @NotBlank(message = "Client surname can't be empty")
    String surname;

    String companyName;

    @NotBlank(message = "Client adress can't be empty")
    String adress;

    @NotBlank(message = "Client phon can't be empty")
    String phone;

    @Email(message = "Client email is invalid")
    String email;

}
