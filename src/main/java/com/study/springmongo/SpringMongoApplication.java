package com.study.springmongo;

import com.study.springmongo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@RequiredArgsConstructor
public class SpringMongoApplication implements CommandLineRunner {

    private final ItemService itemService;

    public static void main(String[] args) {
        SpringApplication.run(SpringMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----CREATE GROCERY ITEMS-----\n");

        this.itemService.createGroceryItems();

        System.out.println("\n-----SHOW ALL GROCERY ITEMS-----\n");

        this.itemService.showAllGroceryItems();

       System.out.println("\n-----GET ITEM BY NAME-----\n");

        this.itemService.getGroceryItemByName("Whole Wheat Biscuit");

        System.out.println("\n-----GET ITEMS BY CATEGORY-----\n");

        this.itemService.getItemsByCategory("millets");

        System.out.println("\n-----UPDATE CATEGORY NAME OF SNACKS CATEGORY-----\n");

        this.itemService.updateCategoryName("snacks");

        System.out.println("\n-----DELETE A GROCERY ITEM-----\n");

        this.itemService.deleteGroceryItem("Kodo Millet");

        System.out.println("\n-----FINAL COUNT OF GROCERY ITEMS-----\n");

        this.itemService.findCountOfGroceryItems();

        System.out.println("\n-----THANK YOU-----");
    }

}
