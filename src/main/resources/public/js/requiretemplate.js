/**
 * This code is copied from the Sky Billing exercise I completed some time ago.
 * Ultimately it revolves around the idea of loading handlebars templates at
 * runtime so that display and rendering of the layout is dynamic and not
 * hard-coded in the application - update the templates and this can be changed :)
 *
 *
 */



/**
 * Convert a template ID into the name of the script node to hold it
 *
 * @param templateID
 */
function templateScriptName(templateID) {
    return 'template_' + templateID;
}

/**
 * Calculate a template name to a search string to find it
 *
 * @param templateID
 * @returns {string}
 */
function templateScriptSearchID(templateID) {
    return '#' + templateScriptName(templateID);
}

/**
 * Find the template source and compile
 *
 * @param templateID
 * @returns {*}
 */
function compileTemplate(templateID) {
    var templateHtml = $(templateScriptSearchID(templateID)).html();
    var result = undefined;

    if (templateHtml && templateHtml.length > 1) {
        console.log('There is some HTML template to compile');
        result = Handlebars.compile(templateHtml);
    } else {
        console.log('Couldn\'t find any HTML, skipping this template');
    }
    return result;
}

/**
 * Render a template to a given node
 *
 * @param templateToRender - actual Handlebars template object to render
 * @param jsonData - data used by the template for rendering
 * @param destinationDiv - the destination div to write the html output
 */
function renderTemplate(templateToRender, jsonData, destinationDiv) {

    var resultHtml = templateToRender(jsonData);
    console.log('Rendered to: ' + resultHtml);
    console.log('Sending to #' + destinationDiv);
    $('#'+destinationDiv).html(resultHtml);
}

/**
 * Copied from a solution on stackoverflow: http://stackoverflow.com/questions/8366733/external-template-in-underscore
 *
 * Allows loading of templates from separate files.
 *
 * @param templateName - the specific template we want
 * @param templatePath - the path to all templates
 */
function require_template(templateID, templatePath) {

    console.log('Loading template: ' + templateID + ' from path: ' + templatePath);

    var template = $(templateScriptSearchID(templateID));
    if (template.length === 0) {
        console.log('Couldn\'t find template, loading for: ' + templateID);
        var tmpl_url = templatePath + '/' + templateID + '.html';
        var tmpl_string = '';

        console.log('Loading data from: ' + tmpl_url);
        $.ajax({
            url: tmpl_url,
            method: 'GET',
            async: false,
            dataType: 'text',
            success: function (data) {
                console.log('Loaded data for template: ' + tmpl_url);
                tmpl_string = data;
            }
        });

        console.log('Loaded this template data: ' + tmpl_string + 'length: ' + tmpl_string.length);
        $('head').append('<script id="' + templateScriptName(templateID) + '" type="text/x-handlebars-template">' + tmpl_string + '<\/script>');
    }
}

