package service;

import annotation.MyAutowired;

public class UserRepository {
    @MyAutowired
    ProductRepository productRepository;

    @Override
    public String toString() {
        return "UserRepository [productRepository=" + productRepository + "]";
    }
}
