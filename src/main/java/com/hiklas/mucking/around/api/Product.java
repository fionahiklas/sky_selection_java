package com.hiklas.mucking.around.api;

import com.hiklas.mucking.around.entity.Entity;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
public class Product extends Entity<Product> {

    public final String category;
    public final String name;
    public final LocationID location;

    /**
     * TODO: Need to think about handling null/empty for name, category, location
     *
     * Create a new Product object
     *
     * @param id
     * @param name
     * @param category
     * @param location
     * @throws IllegalArgumentException if the ID is null or empty
     */
    public Product(String id, String name, String category, LocationID location)
    {
        super(id);
        this.name = name;
        this.category = category;
        this.location = location;
    }

}
