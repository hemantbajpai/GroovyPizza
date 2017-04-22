package groovypizza

import grails.test.mixin.*
import spock.lang.*

@TestFor(DessertController)
@Mock(Dessert)
class DessertControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null

        params << [name:"pizza", description: "description", price: 5, nutrition: new Nutrition(), menu: new Menu()]
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.dessertList
            model.dessertCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.dessert!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def dessert = new Dessert()
            dessert.validate()
            controller.save(dessert)

        then:"The create view is rendered again with the correct model"
            model.dessert!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            dessert = new Dessert(params)

            controller.save(dessert)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/dessert/show/1'
            controller.flash.message != null
            Dessert.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def dessert = new Dessert(params)
            controller.show(dessert)

        then:"A model is populated containing the domain instance"
            model.dessert == dessert
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def dessert = new Dessert(params)
            controller.edit(dessert)

        then:"A model is populated containing the domain instance"
            model.dessert == dessert
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/dessert/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def dessert = new Dessert()
            dessert.validate()
            controller.update(dessert)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.dessert == dessert

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            dessert = new Dessert(params).save(flush: true)
            controller.update(dessert)

        then:"A redirect is issued to the show action"
            dessert != null
            response.redirectedUrl == "/dessert/show/$dessert.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/dessert/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def dessert = new Dessert(params).save(flush: true)

        then:"It exists"
            Dessert.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(dessert)

        then:"The instance is deleted"
            Dessert.count() == 0
            response.redirectedUrl == '/dessert/index'
            flash.message != null
    }
}
