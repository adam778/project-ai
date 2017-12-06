package com.ai.ai;

import com.ai.ai.database.ClientRepository;
import com.ai.ai.database.DatabaseTestData;
import com.ai.ai.database.ItemRepository;
import com.ai.ai.database.SellRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class AiApplication implements CommandLineRunner {

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    SellRepository sellRepository;


	public static void main(String[] args) {
		SpringApplication.run(AiApplication.class, args);
	}

    @Override
    public void run(String... strings) throws Exception {
        DatabaseTestData.loadTestData(this.clientRepository, this.itemRepository, this.sellRepository);
        //DatabaseTestData.showTestData(this.clientRepository, this.itemRepository, this.sellRepository);
    }
}
