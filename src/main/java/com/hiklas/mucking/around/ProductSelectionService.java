package com.hiklas.mucking.around;

import com.hiklas.mucking.around.api.*;

import java.util.List;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
public class ProductSelectionService implements ProductSelectionAPI
{
    private CustomerLocationAPI customerLocationService;
    private CatalogueAPI catalogueService;

    @Override
    public List<Product> availableProductsForCustomer(CustomerID customerID) throws CouldNotFindCustomerException {

        List<Product> result = null;

        try
        {
            LocationID customerLocation = customerLocationService.locationForCustomer(customerID);
            result = catalogueService.productsForLocation(customerLocation);
        }
        catch(CustomerLocationAPI.UnknownCustomerException uce)
        {
            throw new ProductSelectionAPI.CouldNotFindCustomerException();
        }
        return result;
    }

    public void setCustomerLocationService(CustomerLocationAPI customerLocationService)
    {
        this.customerLocationService = customerLocationService;
    }

    public void setCatalogueService(CatalogueAPI catalogueService)
    {
        this.catalogueService = catalogueService;
    }
}