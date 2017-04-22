package groovypizza

import grails.test.mixin.TestFor
import order.User
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DrinkFeedback)
class DrinkFeedbackSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "should have drink"() {
        when:
            DrinkFeedback feedback = new DrinkFeedback(user: new User(), rating: 2, text:"text", dateCreated: new Date())
            feedback.save(flush:true)
        then:
            !feedback.validate()
        when:
            feedback.drink = new Drink()
            feedback.save(flush: true)
        then:
            feedback.validate()
    }
}
