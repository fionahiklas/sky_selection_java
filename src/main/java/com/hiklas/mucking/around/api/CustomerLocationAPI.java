package com.hiklas.mucking.around.api;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
public interface CustomerLocationAPI {

    class UnknownCustomerException extends Exception {}

    /**
     * Find the location for the given customer
     *
     * @param customerId
     * @return LocationID for the given customer
     * @throws UnknownCustomerException if customer isn't recognised
     * @throws IllegalArgumentException if the customerID is null
     */
    LocationID locationForCustomer(CustomerID customerId) throws UnknownCustomerException;
}
