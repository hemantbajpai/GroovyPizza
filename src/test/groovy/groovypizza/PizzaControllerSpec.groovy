package groovypizza

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.*
import order.User
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder
import spock.lang.*

@TestFor(PizzaController)
@Mock([Pizza, Feedback, PizzaFeedback])
class PizzaControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        controller.springSecurityService = new SpringSecurityService()
        User user = new User(username: 'user', password: 'secret', firstName: "admin", lastName: "admin", addressLine1: "10 pl st", addressLine2: "apt#10", city: "arlington", state: "MA", zipcode: "02476", creditCard: "4488741235762723", expiryDate: new Date(2017, 12, 12), orders: [], enabled: true)
        controller.springSecurityService.metaClass.getCurrentUser = { -> return user }
        params << [name:"pizza", description: "description", type: "veg", price: 5,nutrition: new Nutrition(), menu: new Menu(), feedbacks: []]
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def pizza = new Pizza(params)
            controller.show(pizza)

        then:"A model is populated containing the domain instance"
            model.pizza == pizza
    }

    void "Test for publishFeedack action" () {
        when:
            populateValidParams(params)
            def pizza = new Pizza(params)
            pizza.save(flush:true)
            params << [id:1, rating: 5, text:"text"]
            controller.publishFeedack()
        then:
            pizza.feedbacks.size() == 1
    }
}
