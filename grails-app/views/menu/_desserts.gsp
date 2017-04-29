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
    <g:set var="desserts" value="${bean}"/>

    <table>
        <tbody>
        <tr>
            <g:if test="${desserts.size() >= 1}">
            <td>
                <a href="/dessert/show/${desserts[0].id}"><img src="${resource(dir:"images", file: "${desserts[0].name + ".jpg"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${desserts[0].name}</h4>
            </td>
            </g:if>
            <g:if test="${desserts.size() >= 2}">
            <td>
                <a href="/dessert/show/${desserts[1].id}"><img src="${resource(dir:"images", file: "${desserts[1].name + ".jpg"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${desserts[1].name}</h4>
            </td>
            </g:if>
            <g:if test="${desserts.size() >= 3}">
            <td>
                <a href="/dessert/show/${desserts[2].id}"><img src="${resource(dir:"images", file: "${desserts[2].name + ".jpg"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${desserts[2].name}</h4>
            </td>
            </g:if>
            <g:if test="${desserts.size() >= 4}">
            <td>
                <a href="/dessert/show/${desserts[3].id}"><img src="${resource(dir:"images", file: "${desserts[3].name + ".jpg"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${desserts[3].name}</h4>
            </td>
            </g:if>
        </tr>
        </tbody>
    </table>
    </body>
</html>
