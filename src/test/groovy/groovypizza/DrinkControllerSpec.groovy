package groovypizza

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.*
import order.User
import spock.lang.*

@TestFor(DrinkController)
@Mock([Drink, DrinkFeedback, Feedback])
class DrinkControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        controller.springSecurityService = new SpringSecurityService()
        User user = new User(username: 'user', password: 'secret', firstName: "admin", lastName: "admin", addressLine1: "10 pl st", addressLine2: "apt#10", city: "arlington", state: "MA", zipcode: "02476", creditCard: "4488741235762723", expiryDate: new Date(2017, 12, 12), orders: [], enabled: true)
        controller.springSecurityService.metaClass.getCurrentUser = { -> return user }
        params << [name:"pizza", description: "description", price: 5, menu: new Menu()]
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def drink = new Drink(params)
            controller.show(drink)

        then:"A model is populated containing the domain instance"
            model.drink == drink
    }

    void "Test for publishFeedack action" () {
        when:
            populateValidParams(params)
            def drink = new Drink(params)
            drink.save(flush:true)
            params << [id:1, rating: 5, text:"text"]
            controller.publishFeedack()
        then:
            drink.feedbacks.size() == 1
    }
}
