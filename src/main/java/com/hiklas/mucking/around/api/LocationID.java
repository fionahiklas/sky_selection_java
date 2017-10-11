package com.hiklas.mucking.around.api;

import com.hiklas.mucking.around.entity.Entity;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
public class LocationID extends Entity<LocationID> {
    public final String id;

    /**
     * TODO: Need to protect against null ID, otherwise hashCode and
     * TODO: equals methods will break
     *
     * @param id
     */
    public LocationID(String id)
    {
        this.id = id;
    }

    @Override
    public String getId()
    {
        return id;
    }
}
