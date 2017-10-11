package com.hiklas.mucking.around.api;

import java.util.List;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
public interface CatalogueAPI {

    /**
     * Return a list of products that include those specific to a given
     * location and also any which are nationwide.
     *
     * TODO: This method assumes that the location ID is valid and will
     * TODO: simply return the nationwide products if an incorrect
     * TODO: value is passed in.  Some further thought is needed as to
     * TODO: whether this is the correct way to handle this condition
     *
     * @param locationID
     * @return List of products
     */
    List<Product> productsForLocation(LocationID locationID);
}
