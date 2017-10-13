package com.hiklas.mucking.around;

import com.hiklas.mucking.around.api.CustomerID;
import com.hiklas.mucking.around.api.CustomerLocationAPI;
import com.hiklas.mucking.around.api.LocationID;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public class CustomerLocationServiceTest {

    public static final CustomerID UNKNOWN_CUSTOMER = new CustomerID("teatime");

    public static final CustomerID KNOWN_CUSTOMER_LONDON = new CustomerID("vimes");

    public static final CustomerID KNOWN_CUSTOMER_LIVERPOOL = new CustomerID("aching");

    public static final LocationID LONDON = new LocationID("London");
    public static final LocationID LIVERPOOL = new LocationID("Liverpool");

    private CustomerLocationAPI customerLocationServiceToTest;

    @Before
    public void setup()
    {
        customerLocationServiceToTest = new CustomerLocationService();
    }

    @Test
    public void known_customer_returns_non_null() throws Exception
    {
        LocationID result = customerLocationServiceToTest.locationForCustomer(KNOWN_CUSTOMER_LONDON);
        assertThat(result, notNullValue());
    }

    @Test( expected = CustomerLocationAPI.UnknownCustomerException.class )
    public void unknown_customer_throws_exception() throws Exception
    {
        LocationID result = customerLocationServiceToTest.locationForCustomer(UNKNOWN_CUSTOMER);
        fail();
    }

    @Test( expected = IllegalArgumentException.class )
    public void null_customer_throws_exception() throws Exception
    {
        LocationID result = customerLocationServiceToTest.locationForCustomer(null);
        fail();
    }

    @Test( expected = IllegalArgumentException.class )
    public void trying_to_create_a_new_customer_with_null_results_in_exception()
    {
        CustomerID result = new CustomerID(null);
        fail();
    }

    @Test( expected = IllegalArgumentException.class )
    public void trying_to_create_a_new_customer_with_empty_string_results_in_exception()
    {
        CustomerID result = new CustomerID("");
        fail();
    }

    @Test( expected = IllegalArgumentException.class )
    public void trying_to_create_a_new_location_with_null_results_in_exception()
    {
        LocationID result = new LocationID(null);
        fail();
    }

    @Test( expected = IllegalArgumentException.class )
    public void trying_to_create_a_new_location_with_empty_string_results_in_exception()
    {
        LocationID result = new LocationID("");
        fail();
    }


    // Specific tests for known users - these wouldn't exist in a real implementation,
    // instead we'd have mocks for the database to inject query results

    @Test
    public void known_london_user_returns_london() throws Exception
    {
        LocationID result = customerLocationServiceToTest.locationForCustomer(KNOWN_CUSTOMER_LONDON);
        assertThat(result, equalTo(LONDON));
    }

    @Test
    public void known_liverpool_user_returns_liverpool() throws Exception
    {
        LocationID result = customerLocationServiceToTest.locationForCustomer(KNOWN_CUSTOMER_LIVERPOOL);
        assertThat(result, equalTo(LIVERPOOL));
    }

}
