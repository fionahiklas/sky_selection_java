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