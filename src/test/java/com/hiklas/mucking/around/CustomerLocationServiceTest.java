package com.hiklas.mucking.around;

import com.hiklas.mucking.around.api.CustomerID;
import com.hiklas.mucking.around.api.CustomerLocationAPI;
import com.hiklas.mucking.around.api.LocationID;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

/**
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public class CustomerLocationServiceTest {

    public static final CustomerID UNKNOWN_CUSTOMER = new CustomerID("teatime");

    public static final CustomerID KNOWN_CUSTOMER_LONDON = new CustomerID("vimes");

    public static final CustomerID KNOWN_CUSTOMER_LIVEPOOL = new CustomerID("aching");

    private CustomerLocationAPI customerLocationServiceToTest;

    @Before
    public void setup()
    {
        customerLocationServiceToTest = new CustomerLocationService();
    }

    @Test
    public void known_customer_returns_non_null()
    {
        LocationID result = customerLocationServiceToTest.locationForCustomer(KNOWN_CUSTOMER_LONDON);
        assertThat(result, notNullValue());
    }

}
