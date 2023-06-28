package service;

import annotation.MyAutowired;

public class ProductRepository {
    @MyAutowired
    ItemRepository itemRepository;

    @Override
    public String toString() {
        return "ProductRepository [itemRepository=" + itemRepository + "]";
    }
}
