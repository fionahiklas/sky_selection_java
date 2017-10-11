package com.hiklas.mucking.around.rest;

import com.hiklas.mucking.around.api.CustomerID;
import com.hiklas.mucking.around.api.Product;
import com.hiklas.mucking.around.api.ProductSelectionAPI;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import java.util.List;
import java.util.function.Function;

/**
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public class ProductSelectionResource
{

    // TODO: For a properly internationalized appliction this would be a key
    // TODO: that could be looked up
    public static final String CUSTOMER_NOT_FOUND_ERROR = "The customer couldn't be found";

    public static final String MESSAGE_KEY = "message";
    public static final String ERROR_KEY = "error";

    public static final String ID_KEY = "id";
    public static final String NAME_KEY = "name";
    public static final String CATEGORY_KEY = "category";

    public static final String PRODUCTS_KEY = "products";

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

            JsonArrayBuilder productListBuilder = Json.createArrayBuilder();
            productList.stream()
                    .map(productToJsonObjectMapper())
                    .forEach(productListBuilder::add);

            jsonObjectBuilder
                    .add( PRODUCTS_KEY, productListBuilder );
        }
        catch(ProductSelectionAPI.CouldNotFindCustomerException cnfce)
        {
            JsonObjectBuilder errorBuilder = Json.createObjectBuilder();
            errorBuilder.add(MESSAGE_KEY, CUSTOMER_NOT_FOUND_ERROR);

            jsonObjectBuilder
                    .add( ERROR_KEY,
                            errorBuilder.build() );
        }
        return jsonObjectBuilder.build();
    }

    private Function<Product, JsonObject> productToJsonObjectMapper()
    {
        return (product) ->
        {
            JsonObjectBuilder productObjectBuilder = Json.createObjectBuilder();
            productObjectBuilder.add(ID_KEY, product.id);
            productObjectBuilder.add(NAME_KEY, product.name);
            productObjectBuilder.add(CATEGORY_KEY, product.category);
            return productObjectBuilder.build();
        };
    }
}
