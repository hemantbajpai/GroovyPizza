<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'menu.label', default: 'Menu')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>

        <div class="menupage">
            <br>
            <ul class="nav nav-tabs">
                <li class="active"><a data-toggle="tab" href="#pizza">Pizza</a></li>
                <li><a data-toggle="tab" href="#side">Sides</a> </li>
                <li><a data-toggle="tab" href="#dessert">Dessert</a> </li>
                <li><a data-toggle="tab" href="#drink">Drink</a> </li>
            </ul>

            <div class="tab-content">
                <div id="pizza" class="tab-pane active">
                    <g:render template="pizzas" model="[bean:pizzas]" />
                </div>


                <div id="side" class="tab-pane fade">
                    <g:render template="sides" model="[bean:sides]" />
                </div>

                <div id="dessert" class="tab-pane fade">
                    <g:render template="desserts" model="[bean:desserts]" />
                </div>

                <div id="drink" class="tab-pane fade">
                    <g:render template="drinks" model="[bean:drinks]" />
                </div>
            </div>
        </div>

    </body>
</html>
