package com.hiklas.mucking.around;

import com.hiklas.mucking.around.api.CatalogueAPI;
import com.hiklas.mucking.around.api.LocationID;
import com.hiklas.mucking.around.api.Product;

import java.util.List;

/**
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public class CatalogueService implements CatalogueAPI {

    @Override
    public List<Product> productsForLocation(LocationID locationID) {
        return null;
    }
}
