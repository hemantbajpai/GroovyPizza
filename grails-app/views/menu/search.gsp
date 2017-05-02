<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'menu.label', default: 'Menu')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>

        <div class="searchpage">
            <g:form controller="Menu" >
                <table>
                    <tr>
                        <th class="col-xs-3">
                            <label>Rating</label>
                        </th>
                        <th class="col-xs-3">
                            <label>Price</label>
                        </th>
                        <th class="col-xs-3">
                            <g:select name="nutrition" from="${["calories","protein","fat","carbohydrate","fiber","sugar","calcium","iron","magnesium","potassium","sodium","vitaminC","vitaminB6","vitaminB12","vitaminA","vitaminD","fatSaturated","fatMono", "fatPoly", "cholesterol"]}"/>
                        </th>
                        <th class="col-xs-3">
                            <label>Type</label>
                        </th>
                    </tr>
                    <tr>
                        <td class="col-xs-3">
                            <g:checkBox name="lowRating"/><label>Low</label>
                        </td>
                        <td class="col-xs-3">
                            <g:checkBox name="lowPrice"/><label>$</label>
                        </td>
                        <td class="col-xs-3">
                            <g:checkBox name="lowNutrition"/><label>Low</label>
                        </td>
                        <td class="col-xs-3">
                            <g:checkBox name="veg"/><label>Veg</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="col-xs-3">
                            <g:checkBox name="mediumRating"/><label>Medium</label>
                        </td>
                        <td class="col-xs-3">
                            <g:checkBox name="mediumPrice"/><label>$$</label>
                        </td>
                        <td class="col-xs-3">
                            <g:checkBox name="mediumNutrition"/><label>Medium</label>
                        </td>
                        <td class="col-xs-3">
                            <g:checkBox name="nonveg"/><label>Non Veg</label>
                        </td>
                    </tr>
                    <tr>
                        <td class="col-xs-3">
                            <g:checkBox name="highRating"/><label>High</label>
                        </td>
                        <td class="col-xs-3">
                            <g:checkBox name="highPrice"/><label>$$$</label>
                        </td>
                        <td class="col-xs-3">
                            <g:checkBox name="highNutrition"/><label>High</label>
                        </td>
                    </tr>
                </table>
                <g:actionSubmit id="searchButton" name="search" value="Search Items" action="searchItems"/>
            </g:form>
        </div>
    </body>
</html>
