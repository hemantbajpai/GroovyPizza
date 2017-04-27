package groovypizza

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import order.Role
import order.User

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
//@Secured([Role.ROLE_ADMIN])
@Secured('permitAll')
class PizzaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def springSecurityService

    //@Secured([Role.ROLE_USER,Role.ROLE_ADMIN,Role.ROLE_ANONYMOUS])
    def show(Pizza pizza) {
        respond pizza
    }

    def rejectFeedback (Feedback feedback) {
        feedback.pending = false
        feedback.approved = false;
        feedback.save(flush:true, failOnError:true)
        render feedback as JSON
    }

    def approveFeedback (Feedback feedback) {
        feedback.pending = false
        feedback.approved = true;
        feedback.save(flush:true, failOnError:true)
        render feedback as JSON
    }

    def publishFeedack() {

        def user = User.get(springSecurityService.principal.id)
        Pizza pizza = Pizza.get(params.id)
        def feedback = new PizzaFeedback(rating: params.rating, text:params.text, dateCreated:new Date(), user:user, approved:false, pending:true, pizza: pizza)

        feedback.save(flush:true, failOnError:true)

        pizza.feedbacks << feedback
        pizza.save(flush:true, failOnError:true)
        redirect(uri: request.getHeader('referer') )
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'pizza.label', default: 'Pizza'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
