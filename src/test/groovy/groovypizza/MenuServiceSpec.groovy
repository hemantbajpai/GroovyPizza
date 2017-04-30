package groovypizza

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(MenuService)
class MenuServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Test the getSearchResults return correct output" () {
        when:"The menu is created"
            def menu = new Menu(pizzas: [], sides: [], desserts: [], drinks: [])
        then: "Call the servie"
            service.getSearchResults({}, menu).searchedDesserts.size() == 0
            service.getSearchResults({}, menu).searchedSides.size() == 0
            service.getSearchResults({}, menu).searchedPizzas.size() == 0
            service.getSearchResults({}, menu).searchedDrinks.size() == 0
    }
}
