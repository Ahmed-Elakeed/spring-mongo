package com.study.springmongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("groceryItem")
@AllArgsConstructor
@Data
@ToString
@NoArgsConstructor
public class GroceryItem {

    @Id
    private String id;
    private String name;
    private Integer quantity;
    private String category;
}
