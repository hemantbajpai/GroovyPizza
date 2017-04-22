package groovypizza

import grails.test.mixin.TestFor
import order.User
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(DessertFeedback)
class DessertFeedbackSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "should have dessert"() {
        when:
            DessertFeedback feedback = new DessertFeedback(user: new User(), rating: 2, text:"text", dateCreated: new Date())
            feedback.save(flush:true)
        then:
            !feedback.validate()
        when:
            feedback.dessert = new Dessert()
            feedback.save(flush: true)
        then:
            feedback.validate()
    }
}
