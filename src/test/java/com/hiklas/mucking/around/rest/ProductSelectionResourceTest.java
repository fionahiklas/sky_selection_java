package com.hiklas.mucking.around.rest;


import com.hiklas.mucking.around.api.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

import static com.hiklas.mucking.around.CatalogueService.NATIONAL;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductSelectionResourceTest
{

    public static String KNOWN_CUSTOMER_MAGRAT = "Magrat";
    public static String UNKNOWN_CUSTOMER_TEATIME = "Teatime";


    public static LocationID KNOWN_LOCATION_LANCRE = new LocationID("Lancre");

    private static final List<Product> PRODUCTS = new ArrayList<Product>() {{

        // National
        add(new Product("discNews", "Disc News", "News", NATIONAL));
        add(new Product("wizardNews", "Wizard News", "News", NATIONAL));
        add(new Product("witchHour", "Witch Hour", "Witches", KNOWN_LOCATION_LANCRE));
        add(new Product("broomstickReview", "Which broomstick", "Witches", KNOWN_LOCATION_LANCRE));
    }};

    @Mock
    private ProductSelectionAPI mockProductSelectionService;

    @InjectMocks
    private ProductSelectionResource productSelectionResourceToTest;

    @Test
    public void calls_through_to_product_selection_service() throws Exception
    {
        setupMockProductSelectionService();

        productSelectionResourceToTest.productListForCustomerAsJson(KNOWN_CUSTOMER_MAGRAT);

        verify(mockProductSelectionService, times(1)).availableProductsForCustomer(any());
    }

    @Test
    public void result_for_known_user_is_non_null() throws Exception
    {
        setupMockProductSelectionService();

        JsonObject result = productSelectionResourceToTest.productListForCustomerAsJson(KNOWN_CUSTOMER_MAGRAT);
        assertThat( result, notNullValue());
    }

    @Test
    public void result_for_unknown_user_is_error_object() throws Exception
    {
        setupMockProductSelectionService();

        JsonObject result = productSelectionResourceToTest.productListForCustomerAsJson(UNKNOWN_CUSTOMER_TEATIME);

        assertThat( result, notNullValue());
        assertThat( result.getJsonObject("error"), notNullValue());
        assertThat( result.getJsonObject("error").getString("message"), notNullValue());
        assertThat( result.getJsonObject("error").getString("message"),
                equalTo(ProductSelectionResource.CUSTOMER_NOT_FOUND_ERROR));

    }

    @Test
    public void result_for_known_user_array_of_products() throws Exception
    {
        setupMockProductSelectionService();

        JsonObject result = productSelectionResourceToTest.productListForCustomerAsJson(KNOWN_CUSTOMER_MAGRAT);

        assertThat( result, notNullValue());
        assertThat( result.getJsonArray("products"), notNullValue());
        assertThat( result.getJsonArray("products").size(), equalTo(4));
    }


    private void setupMockProductSelectionService() throws Exception
    {
        when(mockProductSelectionService.availableProductsForCustomer(new CustomerID(KNOWN_CUSTOMER_MAGRAT)))
                .thenReturn(PRODUCTS);

        when(mockProductSelectionService.availableProductsForCustomer(new CustomerID(UNKNOWN_CUSTOMER_TEATIME)))
                .thenThrow(new ProductSelectionAPI.CouldNotFindCustomerException());


    }

}
