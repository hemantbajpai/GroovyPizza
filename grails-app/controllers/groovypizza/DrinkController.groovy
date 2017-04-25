package groovypizza

import grails.plugin.springsecurity.annotation.Secured
import order.Role

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
//@Secured([Role.ROLE_ADMIN])
@Secured('permitAll')
class DrinkController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    //@Secured([Role.ROLE_USER,Role.ROLE_ADMIN,Role.ROLE_ANONYMOUS])
    def show(Drink drink) {
        respond drink
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'drink.label', default: 'Drink'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
