package com.hiklas.mucking.around.api;

import com.hiklas.mucking.around.entity.Entity;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
public class Product extends Entity<Product> {

    public final String id;
    public final String category;
    public final String name;

    public Product(String id, String name, String category)
    {
        this.id = id;
        this.name = name;
        this.category = category;
    }

    @Override
    public String getId()
    {
        return id;
    }
}
