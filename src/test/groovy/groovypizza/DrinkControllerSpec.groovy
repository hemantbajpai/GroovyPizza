package groovypizza

import grails.test.mixin.*
import spock.lang.*

@TestFor(DrinkController)
@Mock(Drink)
class DrinkControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

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
}
