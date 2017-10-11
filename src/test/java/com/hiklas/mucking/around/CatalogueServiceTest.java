package com.hiklas.mucking.around;

import com.hiklas.mucking.around.api.CatalogueAPI;
import com.hiklas.mucking.around.api.CustomerLocationAPI;
import com.hiklas.mucking.around.api.LocationID;
import org.junit.Before;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

/**
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public class CatalogueServiceTest {


    public static final LocationID LONDON = new LocationID("London");
    public static final LocationID LIVERPOOL = new LocationID("Liverpool");

    private CatalogueAPI catalogueServiceToTest;

    @Before
    public void setup()
    {
        catalogueServiceToTest = new CatalogueService();
    }

}
