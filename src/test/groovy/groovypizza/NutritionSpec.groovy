package groovypizza

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Nutrition)
class NutritionSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "Nutrition creation"() {
        when:
            Nutrition nutrition = new Nutrition()
            nutrition.save(flush:true)
        then:
            nutrition.validate()
    }
}
