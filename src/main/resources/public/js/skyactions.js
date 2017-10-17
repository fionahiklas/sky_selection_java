/**
 *
 * Collection of functions for handling actions in the page
 * which includes the setup triggered by the document load.
 *
 * TODO: Ideally these should all be TDD, but this is getting into
 * TODO: UI stuff and it's much harder to test, so leaving that for now.
 * TODO: In reality this UI probably needs alot of work anyway
 */


/**
 * Clear available products
 */
function clearAvailableProducts()
{
    $("#availableProducts").html("");
}

/**
 * Clear shopping basket
 */
function clearShoppingBasket()
{
    $("#shoppingBasket").html("");
}

/**
 * Base location for handlebars templates
 *
 * @returns {string}
 */
function templateBaseUrl()
{
    return "/js/templates";
}

/**
 * URL for the products REST API
 *
 * @returns {string}
 */
function getProductsUrl()
{
    return "/products";
}


/**
 * Load all of the templates for the application
 */
function loadAllTemplates()
{
    require_template("availableProducts", templateBaseUrl());
    require_template("shoppingBasket", templateBaseUrl());
    window.availableProductsTemplate = compileTemplate("availableProducts");
    window.shoppingBasketTemplate = compileTemplate("shoppingBasket");
}

/**
 * Render the product data
 */
function renderAllProducts(categories)
{
    renderTemplate( window.availableProductsTemplate, categories, "availableProducts" );
}

/**
 * Render the shopping basket
 */
function renderShoppingBasket(shopping)
{
    renderTemplate( window.shoppingBasketTemplate, shopping, "shoppingBasket" );
}


/**
 *
 * Take the received data and process it.  The call the render functions
 *
 * TODO: Protect against empty/null jsonData
 */
function updateAvailableProductsFromJsonData(jsonData)
{
    console.log("Received raw JSON data: " + JSON.stringify(jsonData) );
    var categories = convertProductListToCategoryHash(jsonData.products);

    setCurrentAvailableProducts(categories);
    createEmptyShoppingBasket();

    renderAllProducts(categories);
    renderShoppingBasket(getCurrentShoppingBasket());
}

/**
 * A customer has been entered and we need to retrieve the relevant data
 */
function customerButtonClicked()
{
    console.log("Customer button clicked");

    var customerIDValue = $("#customerIDinput").val();
    window.Cookies.set( "customerID", customerIDValue );

    console.log("Getting product data for customer: " + customerIDValue);

    $.getJSON(getProductsUrl(), "", function(jsonData) {
            console.log('Got product data, rendering ...');
            updateAvailableProductsFromJsonData(jsonData);
    });
}

/**
 * Called when a product check box is clicked
 *
 * @param productId
 * @param categoryId
 */
function availableProductClicked(productId, categoryId)
{
   console.log("Available product clicked: " + productId + " in category: " + categoryId);

   addProductToShoppingBasket(categoryId, productId);
   renderShoppingBasket(getCurrentShoppingBasket());
}

/**
 * Needed to load the templates and parse them
 */
$(document).ready(function () {
    console.log('Sky selection ready function called');

    loadAllTemplates();
    clearAvailableProducts();
    clearShoppingBasket(); // TODO: In reality we probably don't want to clear this on reload, need to persist

    console.log('Loaded templates and ready to start the application');
});