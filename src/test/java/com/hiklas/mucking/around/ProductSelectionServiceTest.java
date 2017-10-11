package com.hiklas.mucking.around;


import com.hiklas.mucking.around.api.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;

import static com.hiklas.mucking.around.CatalogueService.NATIONAL;

/**
 * @author Fiona Bianchi
 * @since 2017-10-11
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductSelectionServiceTest
{

    public static CustomerID KNOWN_CUSTOMER_MAGRAT = new CustomerID("Magrat");
    public static CustomerID KNOWN_CUSTOMER_RINCEWIND = new CustomerID("Rincewind");
    public static CustomerID UNKNOWN_CUSTOMER_DUNGEON = new CustomerID("Dungeon Inhabitant");

    public static LocationID KNOWN_LOCATION_LANCRE = new LocationID("Lancre");
    public static LocationID KNOWN_LOCATION_XXXX = new LocationID("Four ecks");

    private static final List<Product> DISCWIDE_PRODUCTS = new ArrayList<Product>() {{

        // National
        add(new Product("discNews", "Disc News", "News", NATIONAL));
        add(new Product("wizardNews", "Wizard News", "News", NATIONAL));
    }};

    private static final List<Product> LANCRE_ONLY_PRODUCTS = new ArrayList<Product>() {{

        // National
        add(new Product("witchHour", "Witch Hour", "Witches", KNOWN_LOCATION_LANCRE));
        add(new Product("broomstickReview", "Which broomstick", "Witches", KNOWN_LOCATION_LANCRE));
    }};

    private static final List<Product>  LANCRE_PRODUCTS = new ArrayList<Product>()
    {{
        addAll(DISCWIDE_PRODUCTS);
        addAll(LANCRE_ONLY_PRODUCTS);
    }};

    @Mock
    private CustomerLocationAPI mockCustomerLocationService;

    @Mock
    private CatalogueAPI mockCatalogueService;

    @InjectMocks
    private ProductSelectionService productSelectionServiceToTest;

    @Test
    public void implementation_calls_customer_location_service() throws Exception
    {
        setupMockCustomerLocationService();
        List<Product> result = productSelectionServiceToTest.availableProductsForCustomer(KNOWN_CUSTOMER_MAGRAT);

        verify(mockCustomerLocationService, times(1) ).locationForCustomer(any());
    }

    @Test( expected = ProductSelectionAPI.CouldNotFindCustomerException.class )
    public void exception_thrown_when_unkown_customer() throws Exception
    {
        setupMockCustomerLocationService();

        productSelectionServiceToTest.availableProductsForCustomer(UNKNOWN_CUSTOMER_DUNGEON);
    }


    @Test
    public void implementation_calls_catalogue_service() throws Exception
    {
        setupMockCustomerLocationService();
        setupMockCatalogueService();

        List<Product> result = productSelectionServiceToTest.availableProductsForCustomer(KNOWN_CUSTOMER_MAGRAT);

        verify(mockCatalogueService, times(1) ).productsForLocation(any());
    }

    @Test
    public void known_customer_results_in_non_null_list() throws Exception
    {
        List<Product> result = productSelectionServiceToTest.availableProductsForCustomer(KNOWN_CUSTOMER_MAGRAT);
        assertThat(result, notNullValue());

    }

    @Test
    public void for_known_lancre_customer_get_lancre_products() throws Exception
    {
        setupMockCustomerLocationService();
        setupMockCatalogueService();

        List<Product> result = productSelectionServiceToTest.availableProductsForCustomer(KNOWN_CUSTOMER_MAGRAT);

        assertThat(result, equalTo(LANCRE_PRODUCTS));
    }

    @Test
    public void for_known_xxxx_customer_get_only_discwide_products() throws Exception
    {
        setupMockCustomerLocationService();
        setupMockCatalogueService();

        List<Product> result = productSelectionServiceToTest.availableProductsForCustomer(KNOWN_CUSTOMER_RINCEWIND);

        assertThat(result, equalTo(DISCWIDE_PRODUCTS));
    }


    private void setupMockCustomerLocationService() throws Exception
    {
        when(mockCustomerLocationService.locationForCustomer(KNOWN_CUSTOMER_MAGRAT))
                .thenReturn(KNOWN_LOCATION_LANCRE);

        when(mockCustomerLocationService.locationForCustomer(KNOWN_CUSTOMER_RINCEWIND))
                .thenReturn(KNOWN_LOCATION_XXXX);

        when(mockCustomerLocationService.locationForCustomer(UNKNOWN_CUSTOMER_DUNGEON))
                .thenThrow(new CustomerLocationAPI.UnknownCustomerException() );

    }

    private void setupMockCatalogueService()
    {
        when(mockCatalogueService.productsForLocation(KNOWN_LOCATION_XXXX))
                .thenReturn(DISCWIDE_PRODUCTS);

        when(mockCatalogueService.productsForLocation(KNOWN_LOCATION_LANCRE))
                .thenReturn(LANCRE_PRODUCTS);
    }
}
