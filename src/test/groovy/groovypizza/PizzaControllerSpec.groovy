package groovypizza

import grails.test.mixin.*
import spock.lang.*

@TestFor(PizzaController)
@Mock(Pizza)
class PizzaControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        params << [name:"pizza", description: "description", type: "veg", price: 5,nutrition: new Nutrition(), menu: new Menu()]
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.pizzaList
            model.pizzaCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.pizza!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def pizza = new Pizza()
            pizza.validate()
            controller.save(pizza)

        then:"The create view is rendered again with the correct model"
            model.pizza!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            pizza = new Pizza(params)

            controller.save(pizza)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/pizza/show/1'
            controller.flash.message != null
            Pizza.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def pizza = new Pizza(params)
            controller.show(pizza)

        then:"A model is populated containing the domain instance"
            model.pizza == pizza
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def pizza = new Pizza(params)
            controller.edit(pizza)

        then:"A model is populated containing the domain instance"
            model.pizza == pizza
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/pizza/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def pizza = new Pizza()
            pizza.validate()
            controller.update(pizza)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.pizza == pizza

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            pizza = new Pizza(params).save(flush: true)
            controller.update(pizza)

        then:"A redirect is issued to the show action"
            pizza != null
            response.redirectedUrl == "/pizza/show/$pizza.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/pizza/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def pizza = new Pizza(params).save(flush: true)

        then:"It exists"
            Pizza.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(pizza)

        then:"The instance is deleted"
            Pizza.count() == 0
            response.redirectedUrl == '/pizza/index'
            flash.message != null
    }
}
