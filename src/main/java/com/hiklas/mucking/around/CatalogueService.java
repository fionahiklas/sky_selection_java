package com.hiklas.mucking.around;

import com.hiklas.mucking.around.api.CatalogueAPI;
import com.hiklas.mucking.around.api.LocationID;
import com.hiklas.mucking.around.api.Product;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Fiona Bianchi
 * @since 11/10/2017.
 */
public class CatalogueService implements CatalogueAPI {

    // TODO: Maybe move to a constants class
    public static final LocationID NATIONAL = new LocationID("UK");

    private static final LocationID LONDON = new LocationID("London");
    private static final LocationID LIVERPOOL = new LocationID("Liverpool");

    private static final List<Product> ALL_PRODUCTS = new ArrayList<Product>() {{

        // National
        add(new Product("skyNews1", "Sky News", "News", NATIONAL));
        add(new Product("skySportsNews1", "Sky Sports News", "News", NATIONAL));

        // London
        add(new Product("arsenalTV", "Arsenal TV", "Sports", LONDON));
        add(new Product("chelseaTV", "Chelsea TV", "Sports", LONDON));

        // Liverpool
        add(new Product("liverpoolTV", "Liverpool TV", "Sports", LIVERPOOL));
    }};

    @Override
    public List<Product> productsForLocation(LocationID locationID) {
        Stream<Product> allProductsStream = ALL_PRODUCTS.stream();

        List<Product> productList =
                allProductsStream
                    .filter(filterForLocation(locationID))
                    .collect(Collectors.toList());

        return productList;
    }

    /**
     * The filter to use to figure out which products to return
     *
     * @return Predicate function to use for filtering
     */
    private Predicate<Product> filterForLocation(LocationID locationId)
    {
        return product ->
                NATIONAL.equals(product.location) || product.location.equals(locationId);
    }


}
