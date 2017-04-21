package groovypizza

import grails.test.mixin.*
import spock.lang.*

@TestFor(DrinkController)
@Mock(Drink)
class DrinkControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        params << [name:"pizza", menu: new Menu()]
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.drinkList
            model.drinkCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.drink!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def drink = new Drink()
            drink.validate()
            controller.save(drink)

        then:"The create view is rendered again with the correct model"
            model.drink!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            drink = new Drink(params)

            controller.save(drink)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/drink/show/1'
            controller.flash.message != null
            Drink.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def drink = new Drink(params)
            controller.show(drink)

        then:"A model is populated containing the domain instance"
            model.drink == drink
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def drink = new Drink(params)
            controller.edit(drink)

        then:"A model is populated containing the domain instance"
            model.drink == drink
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/drink/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def drink = new Drink()
            drink.validate()
            controller.update(drink)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.drink == drink

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            drink = new Drink(params).save(flush: true)
            controller.update(drink)

        then:"A redirect is issued to the show action"
            drink != null
            response.redirectedUrl == "/drink/show/$drink.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/drink/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def drink = new Drink(params).save(flush: true)

        then:"It exists"
            Drink.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(drink)

        then:"The instance is deleted"
            Drink.count() == 0
            response.redirectedUrl == '/drink/index'
            flash.message != null
    }
}
