package com.hiklas.mucking.around.rest;

import com.hiklas.mucking.around.api.CustomerID;
import com.hiklas.mucking.around.api.Product;
import com.hiklas.mucking.around.api.ProductSelectionAPI;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.List;

/**
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public class ProductSelectionResource {

    private ProductSelectionAPI productSelectionService;

    public void setProductSelectionService(ProductSelectionAPI productSelectionService)
    {
        this.productSelectionService = productSelectionService;
    }

    protected JsonObject productListForCustomerAsJson(String customerID)
    {
        JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();

        try
        {
            List<Product> productList =
                    productSelectionService.availableProductsForCustomer(new CustomerID(customerID));

        }
        catch(ProductSelectionAPI.CouldNotFindCustomerException cnfce)
        {
            // Do nothing at the moment
        }
        return jsonObjectBuilder.build();
    }
}
