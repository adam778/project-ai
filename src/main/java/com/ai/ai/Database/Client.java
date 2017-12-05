package com.ai.ai.Database;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Clients")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
