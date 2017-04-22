<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'drink.label', default: 'Drink')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
        <style>
        .drinkpage {
            text-align: center;
            vertical-align: middle;
            background-color: #fff;
        }
        tab1 { padding-left: 4em; }
        right {text-align: right}
        </style>
    </head>
    <body>
    <div class="drinkpage">
        <br>
        <img src="${resource(dir:"images", file: "${drink.name + ".jpg"}") }" style="width:600px;height:600px;border:0;"/> <br> <h1> ${drink.name}</h1>
        <br><h2> Description: ${drink.description} </h2>
        <h4><br> Price: $ ${drink.price}  </h4>
    </div>

    </body>
</html>
