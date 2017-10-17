/**
 * Get the current set of available products
 *
 * This object is needed to look-up category and product names
 */
function getCurrentAvailableProducts()
{
    return window.skyAvailableProducts;
}


/**
 * Set the current set of available products
 *
 * This object is needed to look-up category and product names
 */
function setCurrentAvailableProducts(availableProductsObject)
{
    window.skyAvailableProducts = availableProductsObject;
}


/**
 * Get the current shopping basket.
 *
 * If this doesn't exist yet it's created
 */
function getCurrentShoppingBasket()
{
    var result = window.skyShoppingBasket;
    if (result == null)
    {
        result = createEmptyShoppingBasket();
    }

    return result;
}

/**
 * Clears the shopping basket and returns that
 *
 * @returns the empty shopping basket
 */
function createEmptyShoppingBasket()
{
    // TODO: I don't like having to repeat the "window.skyShoppingBasket"
    // TODO: can JavaScript return the last value like Ruby?
    window.skyShoppingBasket = { products: {} };
    return window.skyShoppingBasket;
}

/**
 * Add a product in a given category to the shopping basket
 *
 * @param categoryId
 * @param productId
 */
function addProductToShoppingBasket(categoryId, productId)
{
   var shoppingBasket = getCurrentShoppingBasket();
   var products = shoppingBasket.products;

   var availableProducts = getCurrentAvailableProducts();

   var category = availableProducts.categories[categoryId];
   var product = category.products[productId];

   // TODO: This doesn't protect against adding the same thing twice
   // TODO: or even a slightly different category to same productId
   products[productId] = {
       productId: product.id,
       categoryId: category.id,
       productName: product.name,
       categoryName: category.name
   }
}


/**
 * Remove a previously added product from the shopping basket
 *
 * TODO: Currently doesn't check that the product exists
 * TODO: We don't really need the category ID
 *
 * @param categoryId
 * @param productId
 */
function removeProductFromShoppingBasket(categoryId, productId)
{
    var shoppingBasket = getCurrentShoppingBasket();
    var products = shoppingBasket.products;

    delete products[productId];
}


