package groovypizza

import grails.test.mixin.*
import spock.lang.*

@TestFor(MenuController)
@Mock(Menu)
class MenuControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        params << [pizzas: [], sides: [], desserts: [], drinks: []]
    }

    void "Test the menu return correct model" () {
        when:"The menu is executed"
            populateValidParams(params)
            def menu = new Menu(params)
            menu.save(flush: true)
            controller.menu()
        then: "The model is correct"
            model['pizzas'].size() == 0
            model['sides'].size() == 0
            model['desserts'].size() == 0
            model['drinks'].size() == 0

    }

    void "Test the search return correct view" () {
        when:"The search is executed"
            populateValidParams(params)
            def menu = new Menu(params)
            menu.save(flush: true)
            controller.search()
        then: "The view is correct"
            view == "/menu/search"
    }

    void "Test the searchItems return correct model" () {
        when:"The searchItems is executed"
            populateValidParams(params)
            def menu = new Menu(params)
            menu.save(flush: true)
            controller.searchItems()
        then: "The model is correct"
            view == "/menu/menu"
            model['pizzas'].size() == 0
            model['sides'].size() == 0
            model['desserts'].size() == 0
            model['drinks'].size() == 0
    }
}
