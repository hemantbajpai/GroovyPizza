package groovypizza

import grails.test.mixin.*
import spock.lang.*

@TestFor(DessertController)
@Mock(Dessert)
class DessertControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        params << [name:"pizza", description: "description", price: 5, nutrition: new Nutrition(), menu: new Menu()]
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def dessert = new Dessert(params)
            controller.show(dessert)

        then:"A model is populated containing the domain instance"
            model.dessert == dessert
    }
}
