package groovypizza


import grails.test.mixin.integration.Integration
import grails.transaction.*
import order.Role
import order.User
import order.UserRole
import spock.lang.*

@Integration
@Rollback
class MenuIntegrationSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test complete model"() {
        when:"create model"

            Menu menu = new Menu(pizzas: [], sides: [], desserts: [], drinks: [])

            String description = "This is perfect pizza for beef lovers. It is perfect meat ingredient cooked pizza. It is cooked with tomato sauce and real cheese surrounded by a garlic butter crispy crust."
            Nutrition nutrition = new Nutrition(weight: 107, calories: 285, protein: 12,fat: 10.0, carbohydrate: 36, fiber: 2.5, sugar: 3.8, calcium: 20, iron: 15, magnesium: 6, potassium: 184, sodium: 640, vitaminC: 2, vitaminB6: 5, vitaminB12: 6, vitaminA: 7, vitaminD: 0, fatSaturated: 4.0, fatPoly: 1.8, fatMono: 2.8, cholesterol: 16)
            Pizza beef = new Pizza(name: "Beef", price: 11, description: description, type: "nonveg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.pizzas << beef

            description = "This is delicious pizza. It is made of tomato sauce, real cheese and traditional garlic buttery crust."
            nutrition = new Nutrition(weight: 100, calories: 185, protein: 10,fat: 8.0, carbohydrate: 25, fiber: 2.4, sugar: 3.6, calcium: 22, iron: 14, magnesium: 8, potassium: 180, sodium: 650, vitaminC: 3, vitaminB6: 6, vitaminB12: 6, vitaminA: 8, vitaminD: 0, fatSaturated: 4.1, fatPoly: 1.9, fatMono: 2.9, cholesterol: 15)
            Pizza cheese = new Pizza(name: "Cheese", price: 8, description: description, type: "veg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.pizzas << cheese

            description = "Chicken piiza has garlic crust topped with buffalo sauce, real cheese and premium chicken, drizzled with buffalo sauce"
            nutrition = new Nutrition(weight: 102, calories: 225, protein: 11,fat: 9.0, carbohydrate: 28, fiber: 2.5, sugar: 3.7, calcium: 21, iron: 13, magnesium: 7, potassium: 181, sodium: 640, vitaminC: 1, vitaminB6: 7, vitaminB12: 7, vitaminA: 9, vitaminD: 0, fatSaturated: 4.1, fatPoly: 1.7, fatMono: 2.7, cholesterol: 18)
            Pizza chicken = new Pizza(name: "Chicken", price: 9, description: description, type: "nonveg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.pizzas << chicken

            description = "Ham & Cheddar pizza has garlic butter crust topped with paresan ranch sauce, real cheese, real cheddar and slice ham"
            nutrition = new Nutrition(weight: 105, calories: 255, protein: 12,fat: 10.0, carbohydrate: 30, fiber: 2.8, sugar: 3.5, calcium: 22, iron: 15, magnesium: 6, potassium: 182, sodium: 655, vitaminC: 2, vitaminB6: 5, vitaminB12: 6, vitaminA: 7, vitaminD: 0, fatSaturated: 4.1, fatPoly: 1.8, fatMono: 2.8, cholesterol: 20)
            Pizza hamcheddar = new Pizza(name: "Ham Cheddar", price: 12, description: description, type: "nonveg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.pizzas << hamcheddar

            description = "This is perfect pizza for meat lovers. It has real cheese, pepperoni, ham, beef and sausage surrounded by a garlic butter crispy crust"
            nutrition = new Nutrition(weight: 106, calories: 305, protein: 13,fat: 11.0, carbohydrate: 32, fiber: 2.9, sugar: 3.6, calcium: 24, iron: 12, magnesium: 8, potassium: 180, sodium: 670, vitaminC: 2, vitaminB6: 6, vitaminB12: 7, vitaminA: 8, vitaminD: 0, fatSaturated: 4.2, fatPoly: 1.9, fatMono: 2.7, cholesterol: 22)
            Pizza meateater = new Pizza(name: "Meat Eater", price: 15, description: description, type: "nonveg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.pizzas << meateater

            description = "Pepperoni pizza is made up of tomato sauce with real cheese surrounded by a traditional garlic buttery crust"
            nutrition = new Nutrition(weight: 105, calories: 295, protein: 12,fat: 10.0, carbohydrate: 36, fiber: 2.5, sugar: 3.8, calcium: 20, iron: 15, magnesium: 6, potassium: 184, sodium: 640, vitaminC: 2, vitaminB6: 5, vitaminB12: 6, vitaminA: 7, vitaminD: 0, fatSaturated: 4.0, fatPoly: 1.8, fatMono: 2.8, cholesterol: 16)
            Pizza pepperoni = new Pizza(name: "Pepperoni", price: 12, description: description, type: "nonveg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.pizzas << pepperoni

            description = "This is good pizza for meat lovers. It has pepperoni and sausage. This is made up of real cheese surrounded by garlic buttery crust"
            nutrition = new Nutrition(weight: 110, calories: 220, protein: 12,fat: 9.0, carbohydrate: 25, fiber: 2.4, sugar: 3.6, calcium: 22, iron: 14, magnesium: 8, potassium: 180, sodium: 650, vitaminC: 3, vitaminB6: 6, vitaminB12: 6, vitaminA: 8, vitaminD: 0, fatSaturated: 4.1, fatPoly: 1.9, fatMono: 2.9, cholesterol: 15)
            Pizza pepperonisausage = new Pizza(name: "Pepperoni Sausage", price: 14, description: description, type: "nonveg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.pizzas << pepperonisausage

            description = "Pork pizza has some sweet and tangy honey BBQ sauce, deliciously seasoned pork and plenty of real mozzarella cheese all surrounded by golden buttery crust"
            nutrition = new Nutrition(weight: 105, calories: 202, protein: 11,fat: 9.0, carbohydrate: 28, fiber: 2.5, sugar: 3.7, calcium: 21, iron: 13, magnesium: 7, potassium: 181, sodium: 640, vitaminC: 1, vitaminB6: 7, vitaminB12: 7, vitaminA: 9, vitaminD: 0, fatSaturated: 4.1, fatPoly: 1.7, fatMono: 2.7, cholesterol: 18)
            Pizza pork = new Pizza(name: "Pork", price: 12, description: description, type: "nonveg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.pizzas << pork

            description = "Sausage pizza has tomato sauce with italian style sausage with real cheese and traditional garlic crust"
            nutrition = new Nutrition(weight: 110, calories: 190, protein: 12,fat: 7.0, carbohydrate: 30, fiber: 2.8, sugar: 3.5, calcium: 22, iron: 15, magnesium: 6, potassium: 182, sodium: 655, vitaminC: 2, vitaminB6: 5, vitaminB12: 6, vitaminA: 7, vitaminD: 0, fatSaturated: 4.1, fatPoly: 1.8, fatMono: 2.8, cholesterol: 20)
            Pizza sausage = new Pizza(name: "Sausage", price: 12, description: description, type: "nonveg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.pizzas << sausage

            description = "This pizza has perfect amount spinach blended and cooked with real cheese and surrounded by traditional garlic butter on the crust"
            nutrition = new Nutrition(weight: 95, calories: 160, protein: 13,fat: 11.0, carbohydrate: 32, fiber: 2.9, sugar: 3.6, calcium: 24, iron: 12, magnesium: 8, potassium: 180, sodium: 670, vitaminC: 2, vitaminB6: 6, vitaminB12: 7, vitaminA: 8, vitaminD: 0, fatSaturated: 4.2, fatPoly: 1.9, fatMono: 2.7, cholesterol: 22)
            Pizza spinachalfredo = new Pizza(name: "Spinach Alfredo", price: 10, description: description, type: "veg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.pizzas << spinachalfredo

            description = "Veggie pizza has tomato sauce, real cheese, red onions, green peppers, mushrooms and black olives"
            nutrition = new Nutrition(weight: 92, calories: 150, protein: 12,fat: 10.0, carbohydrate: 36, fiber: 2.5, sugar: 3.8, calcium: 20, iron: 15, magnesium: 6, potassium: 184, sodium: 640, vitaminC: 2, vitaminB6: 5, vitaminB12: 6, vitaminA: 7, vitaminD: 0, fatSaturated: 4.0, fatPoly: 1.8, fatMono: 2.8, cholesterol: 16)
            Pizza veggie = new Pizza(name: "Veggie", price: 10, description: description, type: "veg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.pizzas << veggie

            description = "This is perfect pizza for veggie lovers. It has parmesan sauce, real cheddar cheese, mushroomsm red onion, green peppers, tomatoes and permesan seasoning"
            nutrition = new Nutrition(weight: 95, calories: 155, protein: 11,fat: 9.0, carbohydrate: 28, fiber: 2.5, sugar: 3.7, calcium: 21, iron: 13, magnesium: 7, potassium: 181, sodium: 640, vitaminC: 1, vitaminB6: 7, vitaminB12: 7, vitaminA: 9, vitaminD: 0, fatSaturated: 4.1, fatPoly: 1.7, fatMono: 2.7, cholesterol: 18)
            Pizza veggielover = new Pizza(name: "Veggie Lover", price: 11, description: description, type: "veg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.pizzas << veggielover

            description = "Crispy and salted fries which you will love to have"
            nutrition = new Nutrition(weight: 40, calories: 40, protein: 2,fat: 2.0, carbohydrate: 9, fiber: 0, sugar: 0, calcium: 2, iron: 1, magnesium: 1, potassium: 18, sodium: 100, vitaminC: 0, vitaminB6: 1, vitaminB12: 1, vitaminA: 1, vitaminD: 0, fatSaturated: 1.0, fatPoly: 0.5, fatMono: 0.5, cholesterol: 5)
            Side fries = new Side(name: "Fries", price: 5, description: description, type: "veg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.sides << fries

            description = "Crispy and salted onion rings battered with a subtle blend of spices"
            nutrition = new Nutrition(weight: 50, calories: 45, protein: 2,fat: 2.1, carbohydrate: 10, fiber: 0, sugar: 0, calcium: 2, iron: 2, magnesium: 2, potassium: 20, sodium: 110, vitaminC: 0, vitaminB6: 1, vitaminB12: 1, vitaminA: 1, vitaminD: 0, fatSaturated: 1.0, fatPoly: 0.5, fatMono: 0.5, cholesterol: 8)
            Side onionRings = new Side(name: "Onion Rings", price: 5, description: description, type: "veg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.sides << onionRings

            description = "Crispy, yet tender garlic floavored bread sticks made with our deep dish dough"
            nutrition = new Nutrition(weight: 55, calories: 50, protein: 3,fat: 2.5, carbohydrate: 12, fiber: 0, sugar: 0, calcium: 2, iron: 2, magnesium: 3, potassium: 22, sodium: 100, vitaminC: 0, vitaminB6: 1, vitaminB12: 2, vitaminA: 1, vitaminD: 0, fatSaturated: 1.0, fatPoly: 0.5, fatMono: 0.5, cholesterol: 10)
            Side gralicBread = new Side(name: "Garlic Bread", price: 6, description: description, type: "veg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.sides << gralicBread

            description = "Stuffed garlic breadstick has cheese, garlic and bread"
            nutrition = new Nutrition(weight: 60, calories: 60, protein: 3.5,fat: 3.5, carbohydrate: 15, fiber: 0, sugar: 0, calcium: 3, iron: 2, magnesium: 3, potassium: 25, sodium: 120, vitaminC: 0, vitaminB6: 2, vitaminB12: 2, vitaminA: 1, vitaminD: 0, fatSaturated: 1.0, fatPoly: 0.5, fatMono: 0.5, cholesterol: 15)
            Side stuffedGarlicBreadstick = new Side(name: "Stuffed Garlic Breadstick", price: 6, description: description, type: "veg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.sides << stuffedGarlicBreadstick

            description = "Delicious pasta with creamy Alfredo sauce"
            nutrition = new Nutrition(weight: 150, calories: 350, protein: 11,fat: 13, carbohydrate: 50, fiber: 2, sugar: 4, calcium: 10, iron: 12, magnesium: 13, potassium: 220, sodium: 1000, vitaminC: 4, vitaminB6: 8, vitaminB12: 12, vitaminA: 10, vitaminD: 0, fatSaturated: 5.0, fatPoly: 2.5, fatMono: 2.5, cholesterol: 10)
            Side alfredoPasta = new Side(name: "Pasta With Alfredo", price: 8, description: description, type:"nonveg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.sides << alfredoPasta

            description = "Delicious pasta with Marinara sauce"
            nutrition = new Nutrition(weight: 150, calories: 320, protein: 12,fat: 12, carbohydrate: 40, fiber: 3, sugar: 5, calcium: 12, iron: 12, magnesium: 13, potassium: 220, sodium: 900, vitaminC: 4, vitaminB6: 8, vitaminB12: 12, vitaminA: 10, vitaminD: 0, fatSaturated: 4.0, fatPoly: 2.0, fatMono: 2.0, cholesterol: 8)
            Side marinaraPasta = new Side(name:"Pasta With Marinara", price: 8, description: description, type: "nonveg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.sides << marinaraPasta

            description = "Soup made with chicken and pasta"
            nutrition = new Nutrition(weight: 100, calories: 100, protein: 6,fat: 2.0, carbohydrate: 12, fiber: 1, sugar: 2, calcium: 1, iron: 2, magnesium: 3, potassium: 22, sodium: 800, vitaminC: 2, vitaminB6: 4, vitaminB12: 6, vitaminA: 1, vitaminD: 0, fatSaturated: 0.5, fatPoly: 0.25, fatMono: 0.25, cholesterol: 12)
            Side soup = new Side(name:"Soup", price: 6, description: description, type: "nonveg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.sides << soup

            description = "Chicken wings tossed in hot, spicy buffalo sauce"
            nutrition = new Nutrition(weight: 100, calories: 200, protein: 20,fat: 15, carbohydrate: 5, fiber: 0, sugar: 1, calcium: 10, iron: 12, magnesium: 13, potassium: 220, sodium: 2000, vitaminC: 4, vitaminB6: 8, vitaminB12: 12, vitaminA: 10, vitaminD: 0, fatSaturated: 4.0, fatPoly: 2, fatMono: 2, cholesterol: 100)
            Side hotBuffalo = new Side(name:"Hot Buffalo", price: 6, description: description, type: "nonveg", nutrition: nutrition, menu: menu, feedbacks: [])
            menu.sides << hotBuffalo

            description = "Delicious pie baked with organic blueberries"
            nutrition = new Nutrition(weight: 105, calories: 110, protein: 2,fat: 3, carbohydrate: 25, fiber: 1, sugar: 10, calcium: 2, iron: 1, magnesium: 3, potassium: 22, sodium: 100, vitaminC: 1, vitaminB6: 2, vitaminB12: 2, vitaminA: 1, vitaminD: 0, fatSaturated: 3.0, fatPoly: 1.5, fatMono: 1.5, cholesterol: 0)
            Dessert blueberryPie = new Dessert(name:"Blueberry Pie", price: 6, description: description, nutrition: nutrition, menu: menu, feedbacks: [])
            menu.desserts << blueberryPie

            description = "Rich and fudgy chocolate brownies dusted with sugar"
            nutrition = new Nutrition(weight: 115, calories: 150, protein: 2,fat: 5, carbohydrate: 20, fiber: 1, sugar: 12, calcium: 2, iron: 1, magnesium: 3, potassium: 22, sodium: 150, vitaminC: 1, vitaminB6: 2, vitaminB12: 2, vitaminA: 1, vitaminD: 0, fatSaturated: 6.0, fatPoly: 3, fatMono: 3, cholesterol: 0)
            Dessert brownies = new Dessert(name: "Brownies", price: 4, description: description, nutrition: nutrition, menu: menu, feedbacks: [])
            menu.desserts << brownies

            description = "Delicious creamy smooth cheesecake"
            nutrition = new Nutrition(weight: 80, calories: 100, protein: 2,fat: 4, carbohydrate: 20, fiber: 1, sugar: 10, calcium: 2, iron: 1, magnesium: 3, potassium: 22, sodium: 120, vitaminC: 1, vitaminB6: 2, vitaminB12: 2, vitaminA: 1, vitaminD: 0, fatSaturated: 4.0, fatPoly: 2, fatMono: 2, cholesterol: 0)
            Dessert cheesecake = new Dessert(name: "Cheesecake", price: 5, description: description, nutrition: nutrition, menu: menu, feedbacks: [])
            menu.desserts << cheesecake

            description = "Delicious pie baked with organic strawberries"
            nutrition = new Nutrition(weight: 105, calories: 115, protein: 2,fat: 3, carbohydrate: 28, fiber: 1, sugar: 11, calcium: 2, iron: 1, magnesium: 3, potassium: 22, sodium: 110, vitaminC: 1, vitaminB6: 2, vitaminB12: 2, vitaminA: 1, vitaminD: 0, fatSaturated: 3.0, fatPoly: 1.5, fatMono: 1.5, cholesterol: 0)
            Dessert strawberryPie = new Dessert(name:"Strawberry Pie", price: 6, description: description, nutrition: nutrition, menu: menu, feedbacks: [])
            menu.desserts << strawberryPie

            description = "It is a non-alcoholic mocktail take on traditional Bellini. It has dry sparkling white grape juice, mineral water and lemon juice"
            Drink bellaBellini = new Drink(name: "Bella Bellini", price: 4, description: description, menu: menu, feedbacks: [])
            menu.drinks << bellaBellini

            description = "This is a non-alcoholic mocktail, main ingredient is blue variety of Hawaiian punch called Polar Blast"
            Drink blueShoe = new Drink(name:"Blue Shoe", price: 5, description: description, menu: menu, feedbacks: [])
            menu.drinks << blueShoe

            description = "This is a non-alcoholic mocktail, It has no vodka and it has peach nectar"
            Drink cuddlesOnTheBeach = new Drink(name: "Cuddles On The Beach", price: 5, description: description, menu: menu, feedbacks: [])
            menu.drinks << cuddlesOnTheBeach

            description = "This is frutiy drink featuring passion fruit syrup and lime, it replaces rum with passion fruit and other juices"
            Drink hurricaneMocktail = new Drink(name: "Hurricane Mocktail", price: 6, description: description, menu: menu, feedbacks: [])
            menu.drinks << hurricaneMocktail

            def params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:true, nonveg: true, lowRating:false, mediumRating: false, highRating: false, nutrition:"calories", lowNutrition:false, mediumNutrition:false, highNutrition:false]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 4

        when:
            params = [lowPrice:true, mediumPrice: true, highPrice: true, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"calories", lowNutrition:false, mediumNutrition:false, highNutrition:false]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 4

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:true, mediumRating: true, highRating: true, nutrition:"calories", lowNutrition:false, mediumNutrition:false, highNutrition:false]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 4

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"calories", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"protein", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"fat", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"carbohydrate", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"fiber", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"sugar", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"calcium", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"iron", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"magnesium", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"potassium", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"sodium", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"vitaminC", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"vitaminB6", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"vitaminB12", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"vitaminA", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"vitaminD", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"fatSaturated", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"fatMono", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"fatPoly", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0

        when:
            params = [lowPrice:false, mediumPrice: false, highPrice: false, veg:false, nonveg: false, lowRating:false, mediumRating: false, highRating: false, nutrition:"cholesterol", lowNutrition:true, mediumNutrition:true, highNutrition:true]
        then:"test model"
            MenuService.getSearchResults(params, menu).searchedPizzas.size() == 12
            MenuService.getSearchResults(params, menu).searchedSides.size() == 8
            MenuService.getSearchResults(params, menu).searchedDesserts.size() == 4
            MenuService.getSearchResults(params, menu).searchedDrinks.size() == 0
    }
}
