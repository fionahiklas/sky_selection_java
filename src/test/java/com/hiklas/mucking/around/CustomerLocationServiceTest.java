package com.hiklas.mucking.around;

import com.hiklas.mucking.around.api.CustomerLocationAPI;
import org.junit.Before;

/**
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public class CustomerLocationServiceTest {

    private CustomerLocationAPI customerLocationServiceToTest;

    @Before
    public void setup()
    {
        customerLocationServiceToTest = new CustomerLocationService();
    }
}
