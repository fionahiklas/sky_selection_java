package com.hiklas.mucking.around.api;

import com.hiklas.mucking.around.entity.Entity;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
public class LocationID extends Entity<LocationID> {

    /**
     * Create a new LocationID object from a StringID
     *
     * @param id
     * @throws IllegalArgumentException if the id is null or empty
     */
    public LocationID(String id)
    {
        super(id);
    }


}
