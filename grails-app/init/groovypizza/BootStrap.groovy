package groovypizza

import order.Role
import order.User
import order.UserRole

class BootStrap {

    def init = { servletContext ->
        User admin = new User(username: 'admin', password: 'secret', firstName: "admin", lastName: "admin", addressLine1: "10 pl st", addressLine2: "apt#10", city: "arlington", state: "MA", zipcode: "02476", creditCard: "1234567890123456", expiryDate: new Date(2017, 12, 12), enabled: true)
        admin.save(flush:true,failOnError:true)

        Role adminRole = new Role(authority: Role.ROLE_ADMIN)
        adminRole.save(flush:true,failOnError:true)

        UserRole.create(admin, adminRole).save(flush:true, failOnError:true)

        Menu menu = new Menu(pizzas: [], sides: [], desserts: [], drinks: [])

        Pizza beef = new Pizza(name: "Beef", description: "description", type: "nonveg", nutrition: new Nutrition(), menu: menu)
        menu.pizzas << beef

        Pizza cheese = new Pizza(name: "Cheese", description: "description1", type: "veg", nutrition: new Nutrition(), menu: menu)
        menu.pizzas << cheese

        Pizza chicken = new Pizza(name: "Chicken", description: "description2", type: "nonveg", nutrition: new Nutrition(), menu: menu)
        menu.pizzas << chicken

        Pizza hamcheddar = new Pizza(name: "Hamcheddar", description: "description3", type: "nonveg", nutrition: new Nutrition(), menu: menu)
        menu.pizzas << hamcheddar

        Pizza meateater = new Pizza(name: "Meateater", description: "description4", type: "nonveg", nutrition: new Nutrition(), menu: menu)
        menu.pizzas << meateater

        Pizza pepperoni = new Pizza(name: "Pepperoni", description: "description5", type: "nonveg", nutrition: new Nutrition(), menu: menu)
        menu.pizzas << pepperoni

        Pizza pepperonisausage = new Pizza(name: "Pepperonisausage", description: "description6", type: "nonveg", nutrition: new Nutrition(), menu: menu)
        menu.pizzas << pepperonisausage

        Pizza pork = new Pizza(name: "Pork", description: "description7", type: "nonveg", nutrition: new Nutrition(), menu: menu)
        menu.pizzas << pork

        Pizza sausage = new Pizza(name: "Sausage", description: "description8", type: "nonveg", nutrition: new Nutrition(), menu: menu)
        menu.pizzas << sausage

        Pizza spinachalfredo = new Pizza(name: "Spinachalfredo", description: "description9", type: "veg", nutrition: new Nutrition(), menu: menu)
        menu.pizzas << spinachalfredo

        Pizza veggie = new Pizza(name: "Veggie", description: "description10", type: "veg", nutrition: new Nutrition(), menu: menu)
        menu.pizzas << veggie

        Pizza veggielover = new Pizza(name: "Veggielover", description: "description11", type: "veg", nutrition: new Nutrition(), menu: menu)
        menu.pizzas << veggielover

        Side fries = new Side(name: "Fries", description: "description", type: "veg", nutrition: new Nutrition(), menu: menu)
        menu.sides << fries

        Side onionRings = new Side(name: "Onion Rings", description: "description1", type: "veg", nutrition: new Nutrition(), menu: menu)
        menu.sides << onionRings

        Side gralicBread = new Side(name: "Garlic Bread", description: "description2", type: "veg", nutrition: new Nutrition(), menu: menu)
        menu.sides << gralicBread

        Side stuffedGarlicBreadstick = new Side(name: "Stuffed Garlic Breadstick", description: "description3", type: "veg", nutrition: new Nutrition(), menu: menu)
        menu.sides << stuffedGarlicBreadstick

        Dessert blueberryPie = new Dessert(name:"Blueberry Pie", description: "description", nutrition: new Nutrition(), menu: menu)
        menu.desserts << blueberryPie

        Dessert brownies = new Dessert(name: "Brownies", description: "description1", nutrition: new Nutrition(), menu: menu)
        menu.desserts << brownies

        Dessert cheesecake = new Dessert(name: "Cheesecake", description: "description2", nutrition: new Nutrition(), menu: menu)
        menu.desserts << cheesecake

        Dessert strawberryPie = new Dessert(name:"Strawberry Pie", description: "description3", nutrition: new Nutrition(), menu: menu)
        menu.desserts << strawberryPie

        Drink bellaBellini = new Drink(name: "Bella Bellini", menu: menu)
        menu.drinks << bellaBellini

        Drink blueShoe = new Drink(name:"Blue Shoe", menu: menu)
        menu.drinks << blueShoe

        Drink cuddlesOnTheBeach = new Drink(name: "Cuddles On The Beach", menu: menu)
        menu.drinks << cuddlesOnTheBeach

        Drink hurricaneMocktail = new Drink(name: "Hurricane Mocktail", menu: menu)
        menu.drinks << hurricaneMocktail

        menu.save(flush:true,failOnError:true)
    }
    def destroy = {
    }
}
