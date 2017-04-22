package groovypizza

import grails.test.mixin.TestFor
import order.User
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Feedback)
class FeedbackSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "feedback rating should be between 1 and 5"() {
        when:
            Feedback feedback = new Feedback(user: new User(), dateCreated: new Date(), text: "text", rating: 6)
            feedback.save(flush: true)
        then:
            !feedback.validate()
        when:
            feedback.rating = 2
            feedback.save(flush:true)
        then:
            feedback.validate()
    }

    void "text cannot be blank" () {
        when:
            Feedback feedback = new Feedback(user: new User(), dateCreated: new Date(), text: "", rating: 5)
            feedback.save(flush: true)
        then:
            !feedback.validate()
        when:
            feedback.text = "text"
            feedback.save(flush:true)
        then:
            feedback.validate()
    }

    void "text should have user" () {
        when:
            Feedback feedback = new Feedback( dateCreated: new Date(), text: "text", rating: 5)
            feedback.save(flush: true)
        then:
            !feedback.validate()
        when:
            feedback.user = new User()
            feedback.save(flush:true)
        then:
            feedback.validate()
    }
}
