package com.hiklas.mucking.around.api;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
public class Product {

    public final String id;
    public final String category;
    public final String name;

    public Product(String id, String name, String category)
    {
        this.id = id;
        this.name = name;
        this.category = category;
    }
}
