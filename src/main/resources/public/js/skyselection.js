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
 *    categories:
 *    {
 *      category1:
 *      {
 *         name: "category1",
 *         products:
 *         {
 *           wibble1: { id: "wibble1", name: "Wibble1", category: "category1", location: "UK" },
 *           wibble2: { id: "wibble2", name: "Wibble2", category: "category1", location: "UK" }
 *         }
 *      }
 *
 *      category2:
 *      {
 *         name: "catageory2",
 *         products:
 *         {
 *           grunt1: { id: "grunt1", name: "Wibble1", category: "category2", location: "UK" },
 *           grunt2: { id: "grunt2", name: "Wibble2", category: "category2", location: "UK" }
 *         }
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
    var result = { categories: {} };
    var categories = result.categories;

    if (productList != null && productList.length != 0)
    {
        for(var index=0; index<productList.length; index++)
        {
            var product = productList[index];
            addProductToCategories(product, categories);
        }
    }

    return result;
}

/**
 * Add the product object to the categories hash.
 * If the category doesn't exist a hash for it needs to be created
 *
 * @param product
 * @param categories
 */
function addProductToCategories(product, categories)
{
    var productId = product.id;
    var productCategoryName = product.category;

    // TODO: Really we need a category name from the server, this is just a hack
    var productCategoryId = productCategoryName.replace(' ', '-');

    var categoryObject = categories[productCategoryId];

    if( categoryObject == null )
    {
        categoryObject = {
            id: productCategoryId,
            name: productCategoryName,
            products: {}
        };

        categories[productCategoryId] = categoryObject;
    }

    categoryObject.products[productId] = product;
}
