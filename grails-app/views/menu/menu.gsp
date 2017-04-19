<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'menu.label', default: 'Menu')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>

    <div class="menupage">

        <ul class="nav nav-tabs">
            <li class="active"><a data-toggle="tab" href="#pizza">Pizza</a></li>
            <li><a data-toggle="tab" href="#appetizer">Appetizer</a> </li>
            <li><a data-toggle="tab" href="#dessert">Dessert</a> </li>
            <li><a data-toggle="tab" href="#drink">Drink</a> </li>
        </ul>

        <div class="tab-content">
            <div id="pizza" class="tab-pane active">
                <g:render template="pizzas" model="[bean:pizzas]" />
            </div>
        </div>

        <div id="appetizer" class="tab-pane fade">

        </div>

        <div id="dessert" class="tab-pane fade">

        </div>

        <div id="drink" class="tab-pane fade">

        </div>

    </div>

    </body>
</html>
