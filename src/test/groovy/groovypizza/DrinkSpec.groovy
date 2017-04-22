package groovypizza

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Drink)
class DrinkSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Drink name can not be blank and should be unique"() {
        when:
            Drink drink = new Drink(name: "", description: "description", price: 5, menu: new Menu())
            drink.save(flush:true)
        then:
            !drink.validate()
        when:
            drink.name = "name"
            drink.save(flush:true)
        then:
            drink.validate()
        when:
            Drink drink1 = new Drink(name: "name", description: "description1", price: 5, menu: new Menu())
            drink1.save(flush:true)
        then:
            !drink1.validate()
        when:
            drink1.name = "name1"
            drink1.save(flush:true)
        then:
            drink1.validate()
    }

    void "Drink description can not be blank and should be unique"() {
        when:
            Drink drink = new Drink(name: "name", description: "", price: 5, menu: new Menu())
            drink.save(flush:true)
        then:
            !drink.validate()
        when:
            drink.description = "description"
            drink.save(flush:true)
        then:
            drink.validate()
        when:
            Drink drink1 = new Drink(name: "name1", description: "description", price: 5, menu: new Menu())
            drink1.save(flush:true)
        then:
            !drink1.validate()
        when:
            drink1.description = "description1"
            drink1.save(flush:true)
        then:
            drink1.validate()
    }

    void "Drink should have a menu" () {
        when:
            Drink drink = new Drink(name: "name",description: "description", price: 5 )
            drink.save(flush:true)
        then:
            !drink.validate()
        when:
            drink.menu = new Menu()
            drink.save(flush:true)
        then:
            drink.validate()
    }

    void "Drink price cannot be negative" () {
        when:
            Drink drink = new Drink(name: "name",description: "description", price: -1, menu: new Menu() )
            drink.save(flush:true)
        then:
            !drink.validate()
        when:
            drink.price = 5
            drink.save(flush:true)
        then:
            drink.validate()
    }
}
