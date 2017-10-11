package com.hiklas.mucking.around;

import com.hiklas.mucking.around.api.CatalogueAPI;
import com.hiklas.mucking.around.api.LocationID;
import com.hiklas.mucking.around.api.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public class CatalogueServiceTest {


    public static final LocationID INVALID_LOCATION = new LocationID("Ankh Morpork");
    public static final LocationID LONDON = new LocationID("London");
    public static final LocationID LIVERPOOL = new LocationID("Liverpool");

    private CatalogueAPI catalogueServiceToTest;

    @Before
    public void setup()
    {
        catalogueServiceToTest = new CatalogueService();
    }

    @Test
    public void for_valid_location_result_is_non_null() throws Exception
    {
        List<Product> result = catalogueServiceToTest.productsForLocation(LONDON);
        assertThat(result, notNullValue());
    }

    @Test
    public void for_invalid_location_result_length_non_zero() throws Exception
    {
        List<Product> result = catalogueServiceToTest.productsForLocation(INVALID_LOCATION);
        assertThat(result, notNullValue());
        assertThat(result.size(), greaterThan(0));
    }

    @Test
    public void for_valid_location_result_length_greater_than_invalid() throws Exception
    {
        List<Product> invalidLocationProducts = catalogueServiceToTest.productsForLocation(INVALID_LOCATION);
        List<Product> liverpoolProducts = catalogueServiceToTest.productsForLocation(LIVERPOOL);

        assertThat(liverpoolProducts.size(), greaterThan( invalidLocationProducts.size() ));
    }

}
