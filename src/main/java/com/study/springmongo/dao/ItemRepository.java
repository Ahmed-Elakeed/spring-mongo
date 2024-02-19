package com.study.springmongo.dao;

import com.study.springmongo.model.GroceryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ItemRepository extends MongoRepository<GroceryItem, String> {

    @Query("{name:'?0'}")
    GroceryItem findItemByName(String name);

    @Query(value = "{category:'?0'}", fields = "{'name' : 1, 'quantity' : 1}")
    List<GroceryItem> findAll(String category);

    @Query(value = "{}", fields = "{'name':  ?0,'quantity': ?0, 'category':  ?0}")
    List<GroceryItem> findAllWithResultFlag(Integer flag);

    long count();
}
