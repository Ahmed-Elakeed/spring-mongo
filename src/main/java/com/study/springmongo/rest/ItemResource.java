package com.study.springmongo.rest;

import com.study.springmongo.model.GroceryItem;
import com.study.springmongo.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/items")
@RequiredArgsConstructor
public class ItemResource {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<GroceryItem>> fetchAllItems(@RequestParam(required = false, defaultValue = "true") Boolean showFlag){
        return ResponseEntity.ok(this.itemService.getAllItems(showFlag));
    }

    @GetMapping(path = "/{itemId}")
    public ResponseEntity<GroceryItem> fetchItemById(@PathVariable(value = "itemId") String itemId){
        return ResponseEntity.ok(this.itemService.getItemById(itemId));
    }

    @PostMapping
    public ResponseEntity<GroceryItem> saveItem(@RequestBody GroceryItem groceryItem){
        return ResponseEntity.ok(this.itemService.saveItem(groceryItem));
    }

    @DeleteMapping(path = "/{itemId}")
    public ResponseEntity<String> deleteItem(@PathVariable(value = "itemId") String itemId){
        this.itemService.deleteItemById(itemId);
        return ResponseEntity.ok("deleted");
    }

    @PutMapping
    public ResponseEntity<GroceryItem> updateItem(@RequestBody GroceryItem groceryItem){
        return ResponseEntity.ok(this.itemService.updateItem(groceryItem));
    }
}
