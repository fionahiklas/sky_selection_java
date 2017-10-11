package com.hiklas.mucking.around.entity;

/**
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public abstract class Entity<T extends EntityId> implements EntityMixin<T> {

    @Override
    public int hashCode()
    {
        return calculateHashCode();
    }

    @Override
    public boolean equals(Object equalTo)
    {
        return calculateEquals(equalTo);
    }
}
