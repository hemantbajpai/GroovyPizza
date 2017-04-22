package groovypizza

import grails.test.mixin.TestFor
import order.User
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(SideFeedback)
class SideFeedbackSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "should have side"() {
        when:
            SideFeedback feedback = new SideFeedback(user: new User(), rating: 2, text:"text", dateCreated: new Date())
            feedback.save(flush:true)
        then:
            !feedback.validate()
        when:
            feedback.side = new Side()
            feedback.save(flush: true)
        then:
            feedback.validate()
    }
}
