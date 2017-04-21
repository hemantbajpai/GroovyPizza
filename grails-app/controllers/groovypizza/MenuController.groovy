package groovypizza

import grails.plugin.springsecurity.annotation.Secured
import order.Role

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured([Role.ROLE_ADMIN])
class MenuController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured([Role.ROLE_USER,Role.ROLE_ADMIN,Role.ROLE_ANONYMOUS])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Menu.list(params), model:[menuCount: Menu.count()]
    }

    @Secured([Role.ROLE_USER,Role.ROLE_ADMIN,Role.ROLE_ANONYMOUS])
    def show(Menu menu) {
        respond menu
    }

    @Secured([Role.ROLE_USER,Role.ROLE_ADMIN,Role.ROLE_ANONYMOUS])
    def menu() {
        render view: 'menu', model: [pizzas: Menu.first().pizzas, sides: Menu.first().sides, desserts: Menu.first().desserts, drinks: Menu.first().drinks]
    }

    def create() {
        respond new Menu(params)
    }

    @Transactional
    def save(Menu menu) {
        if (menu == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (menu.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond menu.errors, view:'create'
            return
        }

        menu.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'menu.label', default: 'Menu'), menu.id])
                redirect menu
            }
            '*' { respond menu, [status: CREATED] }
        }
    }

    def edit(Menu menu) {
        respond menu
    }

    @Transactional
    def update(Menu menu) {
        if (menu == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        if (menu.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond menu.errors, view:'edit'
            return
        }

        menu.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'menu.label', default: 'Menu'), menu.id])
                redirect menu
            }
            '*'{ respond menu, [status: OK] }
        }
    }

    @Transactional
    def delete(Menu menu) {

        if (menu == null) {
            transactionStatus.setRollbackOnly()
            notFound()
            return
        }

        menu.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'menu.label', default: 'Menu'), menu.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'menu.label', default: 'Menu'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
