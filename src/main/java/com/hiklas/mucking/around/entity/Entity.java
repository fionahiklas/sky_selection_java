package com.hiklas.mucking.around.entity;

/**
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public abstract class Entity<T extends EntityId> implements EntityMixin<T> {

    public final String id;

    public Entity(String id)
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
