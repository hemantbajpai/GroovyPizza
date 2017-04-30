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
        <asset:javascript src="application.js"></asset:javascript>
        <script>
            $(function() {

                $('#btn-approved').on('click', function (event) {
                    var button = $(event.relatedTarget),
                        feedbackId = $(this).data('id');

                    var request = $.ajax({
                        url: '/drink/approveFeedback/' + feedbackId + '?format=json',
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
                        url: '/drink/rejectFeedback/' + feedbackId + '?format=json',
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
    <div class="drinkpage">
        <br>
        <img src="${resource(dir:"images", file: "${drink.name + ".jpg"}") }" style="width:600px;height:600px;border:0;"/> <br> <h1> ${drink.name}</h1>
        <br><h2> Description: ${drink.description} </h2>
        <h4><br> Price: $ ${drink.price}  </h4>

        <br>
        <g:form controller="MyOrder" params="[name:drink.name, price:drink.price]">
            <g:actionSubmit value="Add to Order" action="addToOrder"/>
        </g:form>

        <br>
        <hr>
        <br>
        <sec:ifNotGranted roles="ROLE_ANONYMOUS, ROLE_ADMIN">
            <button type="button" id="modalButton" class="btn-primary btn-sm" data-toggle="modal" data-target="#createCommentModal">Post Feedback</button>
            <br>
        </sec:ifNotGranted>
        <g:each var="feedback" in="${drink.feedbacks}">
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
                <g:form controller="Drink" params="[id:drink.id]">
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

    </body>
</html>
