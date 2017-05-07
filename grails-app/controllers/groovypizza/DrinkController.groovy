package groovypizza

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import order.Role
import order.User

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('permitAll')
class DrinkController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def springSecurityService
    def show(Drink drink) {
        respond drink
    }

    @Secured([Role.ROLE_ADMIN])
    def rejectFeedback (Feedback feedback) {
        feedback.pending = false
        feedback.approved = false;
        feedback.save(flush:true, failOnError:true)
        render feedback as JSON
    }

    @Secured([Role.ROLE_ADMIN])
    def approveFeedback (Feedback feedback) {
        feedback.pending = false
        feedback.approved = true;
        feedback.save(flush:true, failOnError:true)
        render feedback as JSON
    }

    def publishFeedack() {

        def user = springSecurityService.getCurrentUser()
        Drink drink = Drink.get(params.id)
        def feedback = new DrinkFeedback(rating: params.rating, text:params.text, dateCreated:new Date(), user:user, approved:false, pending:true, drink: drink)

        feedback.save(flush:true, failOnError:true)

        drink.feedbacks << feedback
        drink.save(flush:true, failOnError:true)
        redirect(uri: request.getHeader('referer') )
    }
}
