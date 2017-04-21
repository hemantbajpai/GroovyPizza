package groovypizza

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class DessertController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Dessert.list(params), model:[dessertCount: Dessert.count()]
    }

    def show(Dessert dessert) {
        respond dessert
    }

    def create() {
        respond new Dessert(params)
    }

    @Transactional
    def save(Dessert dessert) {
        if (dessert == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (dessert.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond dessert.errors, view:'create'
            return
        }

        dessert.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'dessert.label', default: 'Dessert'), dessert.id])
                redirect dessert
            }
            '*' { respond dessert, [status: CREATED] }
        }
    }

    def edit(Dessert dessert) {
        respond dessert
    }

    @Transactional
    def update(Dessert dessert) {
        if (dessert == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (dessert.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond dessert.errors, view:'edit'
            return
        }

        dessert.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'dessert.label', default: 'Dessert'), dessert.id])
                redirect dessert
            }
            '*'{ respond dessert, [status: OK] }
        }
    }

    @Transactional
    def delete(Dessert dessert) {

        if (dessert == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        dessert.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'dessert.label', default: 'Dessert'), dessert.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'dessert.label', default: 'Dessert'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
