package groovypizza

import grails.test.mixin.TestFor
import order.User
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(PizzaFeedback)
class PizzaFeedbackSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "should have pizza"() {
        when:
            PizzaFeedback feedback = new PizzaFeedback(user: new User(), rating: 2, text:"text", dateCreated: new Date())
            feedback.save(flush:true)
        then:
            !feedback.validate()
        when:
            feedback.pizza = new Pizza()
            feedback.save(flush: true)
        then:
            feedback.validate()
    }
}
