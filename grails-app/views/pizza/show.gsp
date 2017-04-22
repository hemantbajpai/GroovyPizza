<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'pizza.label', default: 'Pizza')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
        <style>
        .pizzapage {
            text-align: center;
            vertical-align: middle;
            background-color: #fff;
        }
        tab1 { padding-left: 4em; }
        right {text-align: right}
        </style>
    </head>
    <body>

    <div class="pizzapage">
        <img src="${resource(dir:"images", file: "${pizza.name + ".png"}") }"/> <br> <h1> ${pizza.name}</h1>
        <br><h2> Description: ${pizza.description} </h2>
        <h4><br> Price: $ ${pizza.price}  </h4>

        <h4><br><a data-toggle="modal" data-target="#createModal">Nutrition Facts</a></h4>
    </div>

        <div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="bookModalLabel">Nutrition Facts<br>Pizza, 14" regular crust</h4>
                        </div>
                        <div class="modal-body">
                            <div id="bookModalContent">
                                <table>
                                    <tbody>
                                        <tr>
                                            <td><b>Amount Per 1</b> slice (${pizza.nutrition.weight} g)</td>
                                        </tr>
                                        <tr>
                                            <td><b>Calories</b> ${pizza.nutrition.calories}</td>
                                        </tr>
                                        <tr>
                                            <td><b>Total Fat</b> ${pizza.nutrition.fat} g</td>
                                        </tr>
                                        <tr>
                                            <td><tab1>Saturated fat ${pizza.nutrition.fatSaturated} g</tab1></td>
                                        </tr>
                                        <tr>
                                            <td><tab1>Polyunsaturated fat ${pizza.nutrition.fatPoly} g</tab1></td>
                                        </tr>
                                        <tr>
                                            <td><b>Cholesterol</b> ${pizza.nutrition.cholesterol} mg</td>
                                        </tr>
                                        <tr>
                                            <td><b>Sodium</b> ${pizza.nutrition.sodium} mg</td>
                                        </tr>
                                        <tr>
                                            <td><b>Potassium</b> ${pizza.nutrition.potassium} mg</td>
                                        </tr>
                                        <tr>
                                            <td><b>Total Carbohydrate</b> ${pizza.nutrition.carbohydrate} g</td>
                                        </tr>
                                        <tr>
                                            <td><tab1>Dietary fiber ${pizza.nutrition.fiber} g</tab1></td>
                                        </tr>
                                        <tr>
                                            <td><tab1>Sugar ${pizza.nutrition.sugar} g</tab1></td>
                                        </tr>
                                        <tr>
                                            <td><b>Protein</b> ${pizza.nutrition.protein} g</td>
                                        </tr>
                                        <tr>
                                            <td>Vitamin A <tab1>${pizza.nutrition.vitaminA} %</tab1></td>
                                            <td>Vitamin C <tab1>${pizza.nutrition.vitaminC} %</tab1></td>
                                        </tr>
                                        <tr>
                                            <td>Calcium <tab1>${pizza.nutrition.calcium} %</tab1></td>
                                            <td>Iron <tab1>${pizza.nutrition.iron} %</tab1></td>
                                        </tr>
                                        <tr>
                                            <td>Vitamin D <tab1>${pizza.nutrition.vitaminD} %</tab1></td>
                                            <td>Vitamin B-6 <tab1>${pizza.nutrition.vitaminB6} %</tab1></td>
                                        </tr>
                                        <tr>
                                            <td>Vitamin B-12 <tab1>${pizza.nutrition.vitaminB12} %</tab1></td>
                                            <td>Magnesium <tab1>${pizza.nutrition.magnesium} %</tab1></td>
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
