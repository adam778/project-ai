package com.ai.ai.Database;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Clients")
@Data
@Builder
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String name;
    String surname;
    String companyName;

    String adress;
    String phone;
    String email;

    public Client() {
    }

    Client(String name, String surname, String adress, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
    }

    Client(String companyName, String adress, String phone, String email) {
        this.companyName = companyName;
        this.adress = adress;
        this.phone = phone;
        this.email = email;
    }

    Long getId() {
        return id;
    }


}
