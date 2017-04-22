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
    <g:set var="sides" value="${bean}"/>

    <table>
        <tbody>
        <tr>
            <td>
                <a href="/side/show/${sides[0].id}"><img src="${resource(dir:"images", file: "${sides[0].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${sides[0].name}</h4>
            </td>
            <td>
                <a href="/side/show/${sides[1].id}"><img src="${resource(dir:"images", file: "${sides[1].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${sides[1].name}</h4>
            </td>
            <td>
                <a href="/side/show/${sides[2].id}"><img src="${resource(dir:"images", file: "${sides[2].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${sides[2].name}</h4>
            </td>
            <td>
                <a href="/side/show/${sides[3].id}"><img src="${resource(dir:"images", file: "${sides[3].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${sides[3].name}</h4>
            </td>
        </tr>
        <tr>
            <td>
                <a href="/side/show/${sides[4].id}"><img src="${resource(dir:"images", file: "${sides[4].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${sides[4].name}</h4>
            </td>
            <td>
                <a href="/side/show/${sides[5].id}"><img src="${resource(dir:"images", file: "${sides[5].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${sides[5].name}</h4>
            </td>
            <td>
                <a href="/side/show/${sides[6].id}"><img src="${resource(dir:"images", file: "${sides[6].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${sides[6].name}</h4>
            </td>
            <td>
                <a href="/side/show/${sides[7].id}"><img src="${resource(dir:"images", file: "${sides[7].name + ".png"}")}" style="width:240px;height:240px;border:0;"/></a>
                <br>
                <h4>${sides[7].name}</h4>
            </td>
        </tr>
        </tbody>
    </table>
    </body>
</html>
