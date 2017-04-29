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
                    <th>
                        <label>Rating</label>
                    </th>
                    <th>
                        <label>Price</label>
                    </th>
                    <th>
                        <g:select name="nutrition" from="${["calories","protein","fat","carbohydrate","fiber","sugar","calcium","iron","magnesium","potassium","sodium","vitaminC","vitaminB6","vitaminB12","vitaminA","vitaminD","fatSaturated","fatMono", "fatPoly", "cholesterol"]}"/>
                    </th>
                    <th>
                        <label>Type</label>
                    </th>
                </tr>
                <tr>
                    <td>
                        <g:checkBox name="lowRating"/><label>Low</label>
                    </td>
                    <td>
                        <g:checkBox name="lowPrice"/><label>$</label>
                    </td>
                    <td>
                        <g:checkBox name="lowNutrition"/><label>Low</label>
                    </td>
                    <td>
                        <g:checkBox name="veg"/><label>Veg</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <g:checkBox name="mediumRating"/><label>Medium</label>
                    </td>
                    <td>
                        <g:checkBox name="mediumPrice"/><label>$$</label>
                    </td>
                    <td>
                        <g:checkBox name="mediumNutrition"/><label>Medium</label>
                    </td>
                    <td>
                        <g:checkBox name="nonveg"/><label>Non Veg</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <g:checkBox name="highRating"/><label>High</label>
                    </td>
                    <td>
                        <g:checkBox name="highPrice"/><label>$$$</label>
                    </td>
                    <td>
                        <g:checkBox name="highNutrition"/><label>High</label>
                    </td>
                </tr>
            </table>
            <g:actionSubmit id="searchButton" name="search" value="Search Items" action="searchItems"/>
        </g:form>
    </div>
%{--    <br>
    <hr>
    <div class="menupage">
        <br>
        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#pizza">Pizza</a></li>
            <li><a data-toggle="tab" href="#side">Sides</a> </li>
            <li><a data-toggle="tab" href="#dessert">Dessert</a> </li>
            <li><a data-toggle="tab" href="#drink">Drink</a> </li>
        </ul>

        <div class="tab-content">
            <g:if test="${pizzas != null}">
                <div id="pizza" class="tab-pane active">
                    <g:render template="pizzas" model="[bean:pizzas]" />
                </div>
            </g:if>
            <g:if test="${sides != null}">
                <div id="side" class="tab-pane fade">
                    <g:render template="sides" model="[bean:sides]" />
                </div>
            </g:if>
            <g:if test="${desserts != null}">
                <div id="dessert" class="tab-pane fade">
                    <g:render template="desserts" model="[bean:desserts]" />
                </div>
            </g:if>
            <g:if test="${drinks != null}">
                <div id="drink" class="tab-pane fade">
                    <g:render template="drinks" model="[bean:drinks]" />
                </div>
            </g:if>
        </div>
    </div>--}%
%{--    <g:each var="pizza" in="${pizzas}">
        <a href="/pizza/show/${pizza.id}"><img src="${resource(dir:"images", file: "${pizza.name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
        <br>
        <h4>${pizza.name}</h4>
    </g:each>
    <hr>--}%
    </body>
</html>
