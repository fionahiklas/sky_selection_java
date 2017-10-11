package com.hiklas.mucking.around.api;

import java.util.List;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
public interface ProductSelectionAPI {

    /**
     * Rather than pass back an exception from deep in the implementation code
     * we specify our own class here so that it's a clean API.  This means
     * we're not coupling users of this API with what our implementation uses.
     */
    class CouldNotFindCustomerException extends Exception {}

    /**
     * Get the list of available products for a given customer based on their location
     *
     * TODO: This might be more useful returning a Stream since it's going to be used
     * TODO: for more processing later on.  For now leave as a List
     *
     * @param customerID
     * @return List of available products
     * @throws CouldNotFindCustomerException if this customerID isn't recognised
     */
    List<Product> availableProductsForCustomer(CustomerID customerID) throws CouldNotFindCustomerException;
}
