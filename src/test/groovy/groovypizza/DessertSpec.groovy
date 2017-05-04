package groovypizza

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Dessert)
class DessertSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Dessert name can not be blank and should be unique"() {
        when:
            Dessert dessert = new Dessert(name: "", description: "description", price: 5, nutrition: new Nutrition(), menu: new Menu())
            dessert.save(flush:true)
        then:
            !dessert.validate()
        when:
            dessert.name = "name"
            dessert.save(flush:true)
        then:
            dessert.validate()
        when:
            Dessert dessert1 = new Dessert(name: "name", description: "description1",price: 5,  nutrition: new Nutrition(), menu: new Menu())
            dessert1.save(flush:true)
        then:
            !dessert1.validate()
        when:
            dessert1.name = "name1"
            dessert1.save(flush:true)
        then:
            dessert1.validate()
    }

    void "Dessert descrition can not be blank and should be unique"() {
        when:
            Dessert dessert = new Dessert(name: "name", description: "", price: 5, nutrition: new Nutrition(), menu: new Menu())
            dessert.save(flush:true)
        then:
            !dessert.validate()
        when:
            dessert.description = "description"
            dessert.save(flush:true)
        then:
            dessert.validate()
        when:
            Dessert dessert1 = new Dessert(name: "name1", description: "description", price: 5, nutrition: new Nutrition(), menu: new Menu())
            dessert1.save(flush:true)
        then:
            !dessert1.validate()
        when:
            dessert1.description = "decription1"
            dessert1.save(flush:true)
        then:
            dessert1.validate()
    }

    void "Dessert should have a menu" () {
        when:
            Dessert dessert = new Dessert(name: "name", description: "description", price: 5, nutrition: new Nutrition())
            dessert.save(flush:true)
        then:
            !dessert.validate()
        when:
            dessert.menu = new Menu()
            dessert.save(flush:true)
        then:
            dessert.validate()
    }

    void "Dessert should have a nutrition" () {
        when:
            Dessert dessert = new Dessert(name: "name", description: "description", price: 5, menu : new Menu())
            dessert.save(flush:true)
        then:
            !dessert.validate()
        when:
            dessert.nutrition = new Nutrition()
            dessert.save(flush:true)
        then:
            dessert.validate()
    }

    void "Dessert price should be positive" () {
        when:
            Dessert dessert = new Dessert(name: "name", description: "description", price: -1, menu : new Menu(), nutrition: new Nutrition())
            dessert.save(flush:true)
        then:
            !dessert.validate()
        when:
            dessert.price = 5
            dessert.save(flush:true)
        then:
            dessert.validate()
    }

    void "calling getFeedback method" () {
        when:
            Dessert dessert = new Dessert(name: "name", description: "description", price: -1, menu : new Menu(), nutrition: new Nutrition(), feedbacks: [])
            dessert.save(flush: true)
        then:
            dessert.getFeedbackRating() == 5
    }
}
