package com.hiklas.mucking.around.rest;

import com.hiklas.mucking.around.CatalogueService;
import com.hiklas.mucking.around.CustomerLocationService;
import com.hiklas.mucking.around.ProductSelectionService;
import spark.Spark;


import static spark.Spark.get;

/**
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public class ProductSelectionApp {


    public static void main(String[] args)
    {
        CatalogueService catalogueService = new CatalogueService();
        CustomerLocationService customerLocationService = new CustomerLocationService();

        ProductSelectionService productSelectionService = new ProductSelectionService();
        productSelectionService.setCatalogueService(catalogueService);
        productSelectionService.setCustomerLocationService(customerLocationService);

        ProductSelectionResource productSelectionResource = new ProductSelectionResource();
        productSelectionResource.setProductSelectionService(productSelectionService);

        // Location for HTML, CSS, JS, etc
        Spark.staticFileLocation("/public");

        get("/products" , (req, res) ->
        {
          String customerID = req.cookie("customerID");
          String responseBody =
                  productSelectionResource
                          .productListForCustomerAsJson(customerID)
                          .toString();

          res.type("application/json");
          return responseBody;
        });
    }
}
