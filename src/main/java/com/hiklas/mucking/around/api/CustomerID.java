package com.hiklas.mucking.around.api;

import com.hiklas.mucking.around.entity.Entity;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
public class CustomerID extends Entity<CustomerID> {

    public final String id;

    /**
     * Create a new CustomerID from a StringID
     *
     * @param id
     * @throws IllegalArgumentException if the id is null or empty
     */
    public CustomerID(String id)
    {
        if( id == null || "".equals(id) )
            throw new IllegalArgumentException();

        this.id = id;
    }

    @Override
    public String getId()
    {
        return id;
    }

}
