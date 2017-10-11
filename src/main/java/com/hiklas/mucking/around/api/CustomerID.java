package com.hiklas.mucking.around.api;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
public class CustomerID {
    public final String id;

    /**
     * TODO: Need to protect against null ID, otherwise hashCode and
     * TODO: equals methods will break
     *
     * @param id
     */
    public CustomerID(String id)
    {
        this.id = id;
    }

    @Override
    public int hashCode()
    {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object equalTo)
    {
        if (equalTo instanceof CustomerID)
        {
            return id.equals( ((CustomerID)equalTo).id );
        }
        return false;
    }
}
