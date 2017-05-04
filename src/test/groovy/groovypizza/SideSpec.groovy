package groovypizza

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Side)
class SideSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Side name can not be blank and should be unique"() {
        when:
            Side side = new Side(name: "", description: "description", type: "veg", price:5,nutrition: new Nutrition(), menu: new Menu())
            side.save(flush:true)
        then:
            !side.validate()
        when:
            side.name = "name"
            side.save(flush:true)
        then:
            side.validate()
        when:
            Side side1 = new Side(name: "name", description: "description1", type: "veg", price:5,nutrition: new Nutrition(), menu: new Menu())
            side1.save(flush:true)
        then:
            !side1.validate()
        when:
            side1.name = "name1"
            side1.save(flush:true)
        then:
           side1.validate()
    }

    void "Side description can not be blank and should be unique"() {
        when:
            Side side = new Side(name: "name", description: "", type: "veg", price:5,nutrition: new Nutrition(), menu: new Menu())
            side.save(flush:true)
        then:
            !side.validate()
        when:
            side.description = "description"
            side.save(flush:true)
        then:
            side.validate()
        when:
            Side side1 = new Side(name: "name1", description: "description", price:5,type: "veg", nutrition: new Nutrition(), menu: new Menu())
            side1.save(flush:true)
        then:
            !side1.validate()
        when:
            side1.description = "decription1"
            side1.save(flush:true)
        then:
            side1.validate()
    }

    void "Side type could be veg or nonveg" () {
        when:
            Side side = new Side(name: "name", description: "description", price:5,type: "random", nutrition: new Nutrition(), menu: new Menu())
            side.save(flush:true)
        then:
            !side.validate()
        when:
            side.type = "veg"
            side.save(flush:true)
        then:
            side.validate()
        when:
            side.type = "nonveg"
            side.save(flush:true)
        then:
            side.validate()
    }

    void "Side should have a menu" () {
        when:
            Side side = new Side(name: "name", description: "description", price:5,type: "veg", nutrition: new Nutrition())
            side.save(flush:true)
        then:
            !side.validate()
        when:
            side.menu = new Menu()
            side.save(flush:true)
        then:
            side.validate()
    }

    void "Side should have a nutrition" () {
        when:
            Side side = new Side(name: "name", description: "description", price:5,type: "veg", menu : new Menu())
            side.save(flush:true)
        then:
            !side.validate()
        when:
            side.nutrition = new Nutrition()
            side.save(flush:true)
        then:
            side.validate()
    }

    void "price can not be negative" () {
        when:
            Side side = new Side(name: "name", description: "description", price:-1,type: "veg", menu : new Menu(), nutrition: new Nutrition())
            side.save(flush:true)
        then:
            !side.validate()
        when:
            side.price = 5
            side.save(flush:true)
        then:
            side.validate()
    }

    void "calling getFeedback method" () {
        when:
            Side side = new Side(name: "name", description: "description", price:-1,type: "veg", menu : new Menu(), nutrition: new Nutrition(), feedbacks: [])
            side.save(flush: true)
        then:
            side.getFeedbackRating() == 5
    }
}
