package com.ai.ai.database;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DatabaseTestData {

    public static void loadTestData(
            ClientRepository clientRepository,
            ItemRepository itemRepository,
            SellRepository sellRepository
    ) {
        clientRepository.deleteAll();
        clientRepository.save(new Client("Jan", "Tracz", "Okopowa 3/2", "123-123-123", "qwert@gmail.com"));
        clientRepository.save(new Client("Mateo", "Kowalski", "Zelazna 3/3", "999-999-999", "iopiop@gmail.com"));

        itemRepository.deleteAll();
        itemRepository.save(new Item("Coca-Cola"));
        itemRepository.save(new Item("Kostki WC"));
        itemRepository.save(new Item("Domestos"));

        sellRepository.deleteAll();

        Random r = new Random();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String dateS = dateFormat.format(date);

        for (Client c : clientRepository.findAll()) {
            for (Item i : itemRepository.findAll()) {
                sellRepository.save(new Sell(c.getId(), i.getId(), r.nextInt(1000), dateS));
            }
        }
    }

    public static void showTestData(
            ClientRepository clientRepository,
            ItemRepository itemRepository,
            SellRepository sellRepository
    ) {

        System.out.println("Client");
        System.out.println("---------------------------------------------");
        for (Client c : clientRepository.findAll()) {
            System.out.println(c.toString());
        }

        System.out.println();
        System.out.println("Item");
        System.out.println("---------------------------------------------");
        for (Item i : itemRepository.findAll()) {
            System.out.println(i.toString());
        }

        System.out.println();
        System.out.println("Sell");
        System.out.println("---------------------------------------------");
        for (Sell s : sellRepository.findAll()) {
            System.out.println(s.toString());
        }
    }

}
