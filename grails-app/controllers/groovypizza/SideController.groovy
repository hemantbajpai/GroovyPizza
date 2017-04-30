package groovypizza

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured
import order.Role
import order.User

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('permitAll')
class SideController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    def springSecurityService
    def show(Side side) {
        respond side
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
        Side side = Side.get(params.id)
        def feedback = new SideFeedback(rating: params.rating, text:params.text, dateCreated:new Date(), user:user, approved:false, pending:true, side: side)

        feedback.save(flush:true, failOnError:true)

        side.feedbacks << feedback
        side.save(flush:true, failOnError:true)
        redirect(uri: request.getHeader('referer') )
    }
}
