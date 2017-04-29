<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'menu.label', default: 'Menu')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
        <style>
        td {
            text-align: center;
            vertical-align: middle;
            background-color: #fff;
        }

        td:hover {
            background-color: #eee;
        }
        </style>
    </head>
    <body>
    <g:set var="pizzas" value="${bean}"/>

    <table>
        <tbody>
        <tr>
            <g:if test="${pizzas.size() >= 1}">
            <td>
                <a href="/pizza/show/${pizzas[0].id}"><img src="${resource(dir:"images", file: "${pizzas[0].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${pizzas[0].name}</h4>
            </td>
            </g:if>
            <g:if test="${pizzas.size() >= 2}">
            <td>
                <a href="/pizza/show/${pizzas[1].id}"><img src="${resource(dir:"images", file: "${pizzas[1].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${pizzas[1].name}</h4>
            </td>
            </g:if>
            <g:if test="${pizzas.size() >= 3}">
            <td>
                <a href="/pizza/show/${pizzas[2].id}"><img src="${resource(dir:"images", file: "${pizzas[2].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${pizzas[2].name}</h4>
            </td>
            </g:if>
            <g:if test="${pizzas.size() >= 4}">
            <td>
                <a href="/pizza/show/${pizzas[3].id}"><img src="${resource(dir:"images", file: "${pizzas[3].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${pizzas[3].name}</h4>
            </td>
            </g:if>
        </tr>
        <tr>
            <g:if test="${pizzas.size() >= 5}">
            <td>
                <a href="/pizza/show/${pizzas[4].id}"><img src="${resource(dir:"images", file: "${pizzas[4].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${pizzas[4].name}</h4>
            </td>
            </g:if>
            <g:if test="${pizzas.size() >= 6}">
            <td>
                <a href="/pizza/show/${pizzas[5].id}"><img src="${resource(dir:"images", file: "${pizzas[5].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${pizzas[5].name}</h4>
            </td>
            </g:if>
            <g:if test="${pizzas.size() >= 7}">
            <td>
                <a href="/pizza/show/${pizzas[6].id}"><img src="${resource(dir:"images", file: "${pizzas[6].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${pizzas[6].name}</h4>
            </td>
            </g:if>
            <g:if test="${pizzas.size() >= 8}">
            <td>
                <a href="/pizza/show/${pizzas[7].id}"><img src="${resource(dir:"images", file: "${pizzas[7].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${pizzas[7].name}</h4>
            </td>
            </g:if>
        </tr>
        <tr>
            <g:if test="${pizzas.size() >= 9}">
            <td>
                <a href="/pizza/show/${pizzas[8].id}"><img src="${resource(dir:"images", file: "${pizzas[8].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${pizzas[8].name}</h4>
            </td>
            </g:if>
            <g:if test="${pizzas.size() >= 10}">
            <td>
                <a href="/pizza/show/${pizzas[9].id}"><img src="${resource(dir:"images", file: "${pizzas[9].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${pizzas[9].name}</h4>
            </td>
            </g:if>
            <g:if test="${pizzas.size() >= 11}">
            <td>
                <a href="/pizza/show/${pizzas[10].id}"><img src="${resource(dir:"images", file: "${pizzas[10].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${pizzas[10].name}</h4>
            </td>
            </g:if>
            <g:if test="${pizzas.size() >= 12}">
            <td>
                <a href="/pizza/show/${pizzas[11].id}"><img src="${resource(dir:"images", file: "${pizzas[11].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${pizzas[11].name}</h4>
            </td>
            </g:if>
        </tr>
        </tbody>
    </table>
    </body>
</html>
