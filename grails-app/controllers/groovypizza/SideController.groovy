package groovypizza

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SideController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Side.list(params), model:[sideCount: Side.count()]
    }

    def show(Side side) {
        respond side
    }

    def create() {
        respond new Side(params)
    }

    @Transactional
    def save(Side side) {
        if (side == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (side.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond side.errors, view:'create'
            return
        }

        side.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'side.label', default: 'Side'), side.id])
                redirect side
            }
            '*' { respond side, [status: CREATED] }
        }
    }

    def edit(Side side) {
        respond side
    }

    @Transactional
    def update(Side side) {
        if (side == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (side.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond side.errors, view:'edit'
            return
        }

        side.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'side.label', default: 'Side'), side.id])
                redirect side
            }
            '*'{ respond side, [status: OK] }
        }
    }

    @Transactional
    def delete(Side side) {

        if (side == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        side.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'side.label', default: 'Side'), side.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'side.label', default: 'Side'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
