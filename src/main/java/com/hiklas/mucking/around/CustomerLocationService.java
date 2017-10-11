package com.hiklas.mucking.around;

import com.hiklas.mucking.around.api.CustomerID;
import com.hiklas.mucking.around.api.CustomerLocationAPI;
import com.hiklas.mucking.around.api.LocationID;

import java.util.HashMap;

import static com.hiklas.mucking.around.api.CustomerLocationAPI.UnknownCustomerException;

/**
 * Dummy implementation of the CustomerLocationAPI
 *
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public class CustomerLocationService implements CustomerLocationAPI {

    private static final LocationID LONDON = new LocationID("London");
    private static final LocationID LIVERPOOL = new LocationID("Liverpool");

    public HashMap<CustomerID, LocationID> customerLocationMapping = new HashMap<CustomerID, LocationID>()
    {{
         put(new CustomerID("vimes"), LONDON);
    }};

    @Override
    public LocationID locationForCustomer(CustomerID customerId) throws UnknownCustomerException {
        LocationID locationId = customerLocationMapping.get(customerId);
        if (locationId == null) throw new UnknownCustomerException();
        return locationId;
    }
}
