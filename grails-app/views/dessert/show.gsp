<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'dessert.label', default: 'Dessert')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
        <style>
        .dessertpage {
            text-align: center;
            vertical-align: middle;
            background-color: #fff;
        }
        tab1 { padding-left: 4em; }
        right {text-align: right}
        </style>
    </head>
    <body>
    <div class="dessertpage">
        <br>
        <img src="${resource(dir:"images", file: "${dessert.name + ".jpg"}") }"  style="width:600px;height:600px;border:0;"/> <br> <h1> ${dessert.name}</h1>
        <br><h2> Description: ${dessert.description} </h2>
        <h4><br> Price: $ ${dessert.price}  </h4>

        <h4><br><a data-toggle="modal" data-target="#createModal">Nutrition Facts</a></h4>

        <br>
        <g:form controller="MyOrder" params="[name:dessert.name, price:dessert.price]">
            <g:actionSubmit value="Add to Order" action="addToOrder"/>
        </g:form>
    </div>

    <div class="modal fade" id="createModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="bookModalLabel">Nutrition Facts<br> ${dessert.name}</h4>
                </div>
                <div class="modal-body">
                    <div id="bookModalContent">
                        <table>
                            <tbody>
                            <tr>
                                <td><b>Weight</b> (${dessert.nutrition.weight} g)</td>
                            </tr>
                            <tr>
                                <td><b>Calories</b> ${dessert.nutrition.calories}</td>
                            </tr>
                            <tr>
                                <td><b>Total Fat</b> ${dessert.nutrition.fat} g</td>
                            </tr>
                            <tr>
                                <td><tab1>Saturated fat ${dessert.nutrition.fatSaturated} g</tab1></td>
                            </tr>
                            <tr>
                                <td><tab1>Polyunsaturated fat ${dessert.nutrition.fatPoly} g</tab1></td>
                            </tr>
                            <tr>
                                <td><b>Cholesterol</b> ${dessert.nutrition.cholesterol} mg</td>
                            </tr>
                            <tr>
                                <td><b>Sodium</b> ${dessert.nutrition.sodium} mg</td>
                            </tr>
                            <tr>
                                <td><b>Potassium</b> ${dessert.nutrition.potassium} mg</td>
                            </tr>
                            <tr>
                                <td><b>Total Carbohydrate</b> ${dessert.nutrition.carbohydrate} g</td>
                            </tr>
                            <tr>
                                <td><tab1>Dietary fiber ${dessert.nutrition.fiber} g</tab1></td>
                            </tr>
                            <tr>
                                <td><tab1>Sugar ${dessert.nutrition.sugar} g</tab1></td>
                            </tr>
                            <tr>
                                <td><b>Protein</b> ${dessert.nutrition.protein} g</td>
                            </tr>
                            <tr>
                                <td>Vitamin A <tab1>${dessert.nutrition.vitaminA} %</tab1></td>
                                <td>Vitamin C <tab1>${dessert.nutrition.vitaminC} %</tab1></td>
                            </tr>
                            <tr>
                                <td>Calcium <tab1>${dessert.nutrition.calcium} %</tab1></td>
                                <td>Iron <tab1>${dessert.nutrition.iron} %</tab1></td>
                            </tr>
                            <tr>
                                <td>Vitamin D <tab1>${dessert.nutrition.vitaminD} %</tab1></td>
                                <td>Vitamin B-6 <tab1>${dessert.nutrition.vitaminB6} %</tab1></td>
                            </tr>
                            <tr>
                                <td>Vitamin B-12 <tab1>${dessert.nutrition.vitaminB12} %</tab1></td>
                                <td>Magnesium <tab1>${dessert.nutrition.magnesium} %</tab1></td>
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
