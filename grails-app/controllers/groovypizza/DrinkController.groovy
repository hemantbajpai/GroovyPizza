package groovypizza

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DrinkController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Drink.list(params), model:[drinkCount: Drink.count()]
    }

    def show(Drink drink) {
        respond drink
    }

    def create() {
        respond new Drink(params)
    }

    @Transactional
    def save(Drink drink) {
        if (drink == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (drink.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond drink.errors, view:'create'
            return
        }

        drink.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'drink.label', default: 'Drink'), drink.id])
                redirect drink
            }
            '*' { respond drink, [status: CREATED] }
        }
    }

    def edit(Drink drink) {
        respond drink
    }

    @Transactional
    def update(Drink drink) {
        if (drink == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (drink.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond drink.errors, view:'edit'
            return
        }

        drink.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'drink.label', default: 'Drink'), drink.id])
                redirect drink
            }
            '*'{ respond drink, [status: OK] }
        }
    }

    @Transactional
    def delete(Drink drink) {

        if (drink == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        drink.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'drink.label', default: 'Drink'), drink.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
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
