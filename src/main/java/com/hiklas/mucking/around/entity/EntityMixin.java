package com.hiklas.mucking.around.entity;

/**
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public interface EntityMixin<T extends EntityId> extends EntityId {

    default int calculateHashCode()
    {
        return getId().hashCode();
    }

    default boolean calculateEquals(Object equalTo)
    {
        try
        {
            if( equalTo != null)
                return getId().equals( ((T)equalTo).getId() );
        }
        catch (ClassCastException cce) {}

        return false;
    }
}
