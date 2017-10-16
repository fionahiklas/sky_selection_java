/**
 * Handle submit of the customerID form/input field
 */
function clickCustomerButton()
{
    alert("Button click");
}

/**
 * Convert a list of products into an object with keys
 * for category and a hash of products (by ID)
 * under those.
 *
 * The output will be something like this
 *
 *  {
 *    category1:
 *      {
 *         wibble1: { id: "wibble1", name: "Wibble1", category: "category1", location: "UK" },
 *         wibble2: { id: "wibble2", name: "Wibble2", category: "category1", location: "UK" }
 *      }
 *
 *    category2:
 *      {
 *         grunt1: { id: "grunt1", name: "Wibble1", category: "category2", location: "UK" },
 *         grunt2: { id: "grunt2", name: "Wibble2", category: "category2", location: "UK" }
 *      }
 *
 *  }
 *
 * TODO: This doesn't do any sorting, it would be better if it
 * TODO: did.  Also it might be even better if this was all
 * TODO: done on the server instead of here
 *
 */
function convertProductListToCategoryHash(productList)
{
    categories = {};

    if (productList != null && productList.length != 0)
    {
        for(index=0; index<productList.length; index++)
        {
            product = productList[index];
            addProductToCategories(product, categories);
        }
    }

    return categories;
}

/**
 * Add the product object to the categories hash.
 * Needs to create a hash for the products category if
 * one doesn't exist.
 *
 * @param product
 * @param categories
 */
function addProductToCategories(product, categories)
{
    productId = product.id;
    category = product.category;

    categoryHash = categories[category];

    if( categoryHash == null )
    {
        categoryHash = {};
        categories[category] = categoryHash;
    }

    categoryHash[productId] = product;
}