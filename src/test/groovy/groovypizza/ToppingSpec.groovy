package groovypizza

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Topping)
class ToppingSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Topping name can not be blank and should be unique"() {
        when:
            Topping topping = new Topping(name: "", menu: new Menu())
            topping.save(flush:true)
        then:
            !topping.validate()
        when:
            topping.name = "name"
            topping.save(flush:true)
        then:
            topping.validate()
        when:
            Topping topping1 = new Topping(name: "name", menu: new Menu())
            topping1.save(flush:true)
        then:
            !topping1.validate()
        when:
            topping1.name = "name1"
            topping1.save(flush:true)
        then:
            topping1.validate()
    }

    void "Topping should have a Menu" () {
        when:
            Topping topping = new Topping(name: "name")
            topping.save(flush:true)
        then:
            !topping.validate()
        when:
            topping.menu = new Menu()
            topping.save(flush:true)
        then:
            topping.validate()
    }
}
