package com.example.shoppingcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store/order")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/add")
    public void addItems(@RequestBody List<Integer> itemIds) {
        itemIds.forEach(id -> cartService.addItem(new CartItem(id)));
    }

    @GetMapping("/get")
    public List<CartItem> getItems() {
        return cartService.getItems();
    }
}