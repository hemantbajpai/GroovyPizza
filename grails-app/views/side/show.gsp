<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'side.label', default: 'Side')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
        <style>
        .sidepage {
            text-align: center;
            vertical-align: middle;
            background-color: #fff;
        }
        tab1 { padding-left: 4em; }
        right {text-align: right}
        </style>
    </head>
    <body>
    <div class="sidepage">
        <br>
        <img src="${resource(dir:"images", file: "${side.name + ".png"}") }" style="width:600px;height:600px;border:0;"/> <br> <h1> ${side.name}</h1>
        <br><h2> Description: ${side.description} </h2>
        <h4><br> Price: $ ${side.price}  </h4>

        <h4><br><a data-toggle="modal" data-target="#createModal">Nutrition Facts</a></h4>
    </div>

    <div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="bookModalLabel">Nutrition Facts<br> ${side.name}</h4>
                </div>
                <div class="modal-body">
                    <div id="bookModalContent">
                        <table>
                            <tbody>
                            <tr>
                                <td><b>Amount Per 1</b> slice (${side.nutrition.weight} g)</td>
                            </tr>
                            <tr>
                                <td><b>Calories</b> ${side.nutrition.calories}</td>
                            </tr>
                            <tr>
                                <td><b>Total Fat</b> ${side.nutrition.fat} g</td>
                            </tr>
                            <tr>
                                <td><tab1>Saturated fat ${side.nutrition.fatSaturated} g</tab1></td>
                            </tr>
                            <tr>
                                <td><tab1>Polyunsaturated fat ${side.nutrition.fatPoly} g</tab1></td>
                            </tr>
                            <tr>
                                <td><b>Cholesterol</b> ${side.nutrition.cholesterol} mg</td>
                            </tr>
                            <tr>
                                <td><b>Sodium</b> ${side.nutrition.sodium} mg</td>
                            </tr>
                            <tr>
                                <td><b>Potassium</b> ${side.nutrition.potassium} mg</td>
                            </tr>
                            <tr>
                                <td><b>Total Carbohydrate</b> ${side.nutrition.carbohydrate} g</td>
                            </tr>
                            <tr>
                                <td><tab1>Dietary fiber ${side.nutrition.fiber} g</tab1></td>
                            </tr>
                            <tr>
                                <td><tab1>Sugar ${side.nutrition.sugar} g</tab1></td>
                            </tr>
                            <tr>
                                <td><b>Protein</b> ${side.nutrition.protein} g</td>
                            </tr>
                            <tr>
                                <td>Vitamin A <tab1>${side.nutrition.vitaminA} %</tab1></td>
                                <td>Vitamin C <tab1>${side.nutrition.vitaminC} %</tab1></td>
                            </tr>
                            <tr>
                                <td>Calcium <tab1>${side.nutrition.calcium} %</tab1></td>
                                <td>Iron <tab1>${side.nutrition.iron} %</tab1></td>
                            </tr>
                            <tr>
                                <td>Vitamin D <tab1>${side.nutrition.vitaminD} %</tab1></td>
                                <td>Vitamin B-6 <tab1>${side.nutrition.vitaminB6} %</tab1></td>
                            </tr>
                            <tr>
                                <td>Vitamin B-12 <tab1>${side.nutrition.vitaminB12} %</tab1></td>
                                <td>Magnesium <tab1>${side.nutrition.magnesium} %</tab1></td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>
