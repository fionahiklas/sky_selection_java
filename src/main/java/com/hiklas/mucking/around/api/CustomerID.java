package com.hiklas.mucking.around.api;

import com.hiklas.mucking.around.entity.Entity;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
public class CustomerID extends Entity<CustomerID> {

    /**
     * Create a new CustomerID from a StringID
     *
     * @param id
     * @throws IllegalArgumentException if the id is null or empty
     */
    public CustomerID(String id)
    {
        super(id);
    }

}
