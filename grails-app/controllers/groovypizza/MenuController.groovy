package groovypizza

import grails.plugin.springsecurity.annotation.Secured
import order.Role

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
@Secured('permitAll')
class MenuController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def menu() {
        render view: 'menu', model: [pizzas: Menu.first().pizzas, sides: Menu.first().sides, desserts: Menu.first().desserts, drinks: Menu.first().drinks]
    }

    def search() {
        render view: 'search'
    }

    def searchItems() {
        def maps = MenuService.getSearchResults(params, Menu.first())
        render view: 'menu', model:[pizzas: maps["searchedPizzas"], sides: maps["searchedSides"], desserts: maps["searchedDesserts"], drinks: maps["searchedDrinks"]]
    }
}
