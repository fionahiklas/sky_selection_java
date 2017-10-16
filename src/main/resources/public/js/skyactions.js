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
    window.availableProductsTemplate = compileTemplate("availableProducts");
}

/**
 * Render the product data
 *
 * TODO: Protect against empty/null jsonData (assuming we need to)
 */
function renderAllProducts(jsonData)
{
    console.log("Transforming raw data: " + JSON.stringify(jsonData) );

    categoriesHash = convertProductListToCategoryHash(jsonData.products);

    console.log("Got categories hash: " + JSON.stringify(categoriesHash) );

    categoriesObject = categoriesOfCategories( categoriesHash );

    console.log("Passing data to render with: " + JSON.stringify(categoriesObject) );

    renderTemplate( window.availableProductsTemplate, categoriesObject, "availableProducts" );
}


/**
 * A customer has been entered and we need to retrieve the relevant data
 */
function customerButtonClicked()
{
    console.log("Customer button clicked");

    customerIDValue = $("#customerIDinput").val();
    window.Cookies.set( "customerID", customerIDValue );

    console.log("Getting product data for customer: " + customerIDValue);

    $.getJSON(getProductsUrl(), "", function(jsonData) {
            console.log('Got product data, rendering ...');
            renderAllProducts(jsonData);
    });
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