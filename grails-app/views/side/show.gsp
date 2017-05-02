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

        <asset:javascript src="application.js"></asset:javascript>
        <script>
            $(function() {

                $('#btn-approved').on('click', function (event) {
                    var button = $(event.relatedTarget),
                    feedbackId = $(this).data('id');

                    var request = $.ajax({
                        url: '/side/approveFeedback/' + feedbackId + '?format=json',
                        method: 'POST'
                    });
                    request.done(function (data) {
                        $('#btn-' + data.id)[0].parentNode.removeChild($('#btn-' + data.id)[0])
                        console.log("success")
                    });
                    request.fail(function (data) {
                        console.log("failed")
                    });
                });

                $('#btn-reject').on('click', function (event) {
                    var button = $(event.relatedTarget),
                    feedbackId = $(this).data('id');

                    var request = $.ajax({
                        url: '/side/rejectFeedback/' + feedbackId + '?format=json',
                        method: 'POST'
                    });
                    request.done(function (data) {
                        $('#' + data.id)[0].parentNode.removeChild($('#' + data.id)[0])
                        $('#btn-' + data.id)[0].parentNode.removeChild($('#btn-' + data.id)[0])
                        console.log("success")
                    });
                    request.fail(function (data) {
                        console.log("failed")
                    });
                });
            })
        </script>

    </head>
    <body>
        <div class="sidepage">
            <br>
            <img src="${resource(dir:"images", file: "${side.name + ".png"}") }" style="width:600px;height:600px;border:0;"/> <br> <h1> ${side.name}</h1>
            <br><h2> Description: ${side.description} </h2>
            <h4><br> Price: $ ${side.price}  </h4>

            <h4><br><a data-toggle="modal" data-target="#createModal">Nutrition Facts</a></h4>

            <br>
            <g:form controller="MyOrder" params="[name:side.name, price:side.price]">
                <g:actionSubmit value="Add to Order" action="addToOrder"/>
            </g:form>


            <br>
            <hr>
            <br>
            <sec:ifNotGranted roles="ROLE_ANONYMOUS, ROLE_ADMIN">
                <button type="button" id="modalButton" class="btn-primary btn-sm" data-toggle="modal" data-target="#createCommentModal">Post Feedback</button>
                <br>
            </sec:ifNotGranted>
            <g:each var="feedback" in="${side.feedbacks}">
                <g:if test="${feedback.approved == true}">
                    <h3>Feedback:</h3>
                    <p>By: ${feedback.user.username}</p>
                    <p>Rating: ${feedback.rating}</p>
                    <p>Date Created: ${feedback.dateCreated}</p>
                    <p>Text: ${feedback.text}</p>
                </g:if>
                <g:elseif test="${feedback.pending == true}">
                    <g:if test="${sec.username() == feedback.user.username}">
                        <h3>Feedback:</h3>
                        <p>By: ${feedback.user.username}</p>
                        <p>Rating: ${feedback.rating}</p>
                        <p>Date Created: ${feedback.dateCreated}</p>
                        <p>Text: ${feedback.text}</p>
                        <p>AWAITING APPROVAL</p>
                    </g:if>
                    <g:else>
                        <sec:ifAnyGranted roles="ROLE_ADMIN">
                            <div id="${feedback.id}">
                                <h3>Feedback:</h3>
                                <p>By: ${feedback.user.username}</p>
                                <p>Rating: ${feedback.rating}</p>
                                <p>Date Created: ${feedback.dateCreated}</p>
                                <p>Text: ${feedback.text}</p>
                            </div>
                            <div id="btn-${feedback.id}">
                                <p>AWAITING APPROVAL</p>
                                <button type="button" id="btn-approved" data-id="${feedback.id}" class="btn-primary btn-xs">Approve</button>
                                <button type="button" id="btn-reject" data-id="${feedback.id}" class="btn-primary btn-xs">Reject</button>
                            </div>
                        </sec:ifAnyGranted>
                    </g:else>
                </g:elseif>
                <g:elseif test="${feedback.pending == false}">
                    <g:if test="${sec.username() == feedback.user.username}">
                        <h3><span style="opacity:0.5;"><del>Feedback:</del> </span></h3>
                        <p><span style="opacity:0.5;"><del>By: ${feedback.user.username}</del> </span></p>
                        <p><span style="opacity:0.5;"><del>Rating: ${feedback.rating}</del> </span></p>
                        <p><span style="opacity:0.5;"><del>Date Created: ${feedback.dateCreated}</del> </span></p>
                        <p><span style="opacity:0.5;"><del>Text: ${feedback.text}</del> </span></p>
                    </g:if>
                </g:elseif>
            </g:each>
        </div>

        <div class="modal fade" id="createCommentModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <g:form controller="Side" params="[id:side.id]">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                            <h4 class="modal-title" id="commentModalLabel">Write Feedback</h4>
                        </div>
                        <div class="modal-body">
                            <div id="commentModalContent">
                                <table>
                                    <tr>
                                        <td>
                                            <label>Rating:</label>
                                        </td>
                                        <td>
                                            <g:select name="rating" from="${1..5}"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>
                                            <label>Text:</label>
                                        </td>
                                        <td>
                                            <g:textArea style="width:400px;" name="text"/>
                                        </td>
                                    </tr>
                                </table>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <g:actionSubmit id="publishButton" name="publish" value="Publish" action="publishFeedack"/>
                        </div>
                    </g:form>
                </div>
            </div>
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
