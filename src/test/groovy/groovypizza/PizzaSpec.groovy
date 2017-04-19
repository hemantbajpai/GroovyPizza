package groovypizza

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Pizza)
class PizzaSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Pizza name can not be blank and should be unique"() {
        when:
            Pizza pizza = new Pizza(name: "", description: "description", type: "veg", nutrition: new Nutrition(), menu: new Menu())
            pizza.save(flush:true)
        then:
            !pizza.validate()
        when:
            pizza.name = "name"
            pizza.save(flush:true)
        then:
            pizza.validate()
        when:
            Pizza pizza1 = new Pizza(name: "name", description: "description1", type: "veg", nutrition: new Nutrition(), menu: new Menu())
            pizza1.save(flush:true)
        then:
            !pizza1.validate()
        when:
            pizza1.name = "name1"
            pizza1.save(flush:true)
        then:
            pizza1.validate()
    }

    void "Pizza descrition can not be blank and should be unique"() {
        when:
            Pizza pizza = new Pizza(name: "name", description: "", type: "veg", nutrition: new Nutrition(), menu: new Menu())
            pizza.save(flush:true)
        then:
            !pizza.validate()
        when:
            pizza.description = "description"
            pizza.save(flush:true)
        then:
            pizza.validate()
        when:
            Pizza pizza1 = new Pizza(name: "name1", description: "description", type: "veg", nutrition: new Nutrition(), menu: new Menu())
            pizza1.save(flush:true)
        then:
            !pizza1.validate()
        when:
            pizza1.description = "decription1"
            pizza1.save(flush:true)
        then:
            pizza1.validate()
    }

    void "Pizza type could be veg or nonveg" () {
        when:
            Pizza pizza = new Pizza(name: "name", description: "description", type: "random", nutrition: new Nutrition(), menu: new Menu())
            pizza.save(flush:true)
        then:
            !pizza.validate()
        when:
            pizza.type = "veg"
            pizza.save(flush:true)
        then:
            pizza.validate()
        when:
            pizza.type = "nonveg"
            pizza.save(flush:true)
        then:
            pizza.validate()
    }

    void "Pizza should have a menu" () {
        when:
            Pizza pizza = new Pizza(name: "name", description: "description", type: "veg", nutrition: new Nutrition())
            pizza.save(flush:true)
        then:
            !pizza.validate()
        when:
            pizza.menu = new Menu()
            pizza.save(flush:true)
        then:
            pizza.validate()
    }

    void "Pizza should have a nutrition" () {
        when:
            Pizza pizza = new Pizza(name: "name", description: "description", type: "veg", menu : new Menu())
            pizza.save(flush:true)
        then:
            !pizza.validate()
        when:
            pizza.nutrition = new Nutrition()
            pizza.save(flush:true)
        then:
            pizza.validate()
    }
}
