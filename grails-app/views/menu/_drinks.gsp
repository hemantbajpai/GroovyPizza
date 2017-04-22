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
    <g:set var="drinks" value="${bean}"/>

    <table>
        <tbody>
        <tr>
            <td>
                <a href="/drink/show/${drinks[0].id}"><img src="${resource(dir:"images", file: "${drinks[0].name + ".jpg"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${drinks[0].name}</h4>
            </td>
            <td>
                <a href="/drink/show/${drinks[1].id}"><img src="${resource(dir:"images", file: "${drinks[1].name + ".jpg"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${drinks[1].name}</h4>
            </td>
            <td>
                <a href="/drink/show/${drinks[2].id}"><img src="${resource(dir:"images", file: "${drinks[2].name + ".jpg"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${drinks[2].name}</h4>
            </td>
            <td>
                <a href="/drink/show/${drinks[3].id}"><img src="${resource(dir:"images", file: "${drinks[3].name + ".jpg"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${drinks[3].name}</h4>
            </td>
        </tr>
        </tbody>
    </table>
    </body>
</html>