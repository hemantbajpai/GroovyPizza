package groovypizza

import grails.transaction.Transactional

@Transactional
class MenuService {

    def static getSearchResults(params, menu) {

        def  searchedPizzas = []
         menu.pizzas.each { pizza ->

             boolean addItem = false;
             if((params.lowPrice && pizza.price <= 10) || (params.mediumPrice && pizza.price > 10 && pizza.price < 12) || (params.highPrice && pizza.price >= 12)) {
                addItem = true
             }
             else if(params.lowPrice || params.mediumPrice || params.highPrice) {
                 return
             }

             if((params.veg && pizza.type == "veg")  || (params.nonveg && pizza.type == "nonveg")){
                 addItem = true
             }
             else if(params.veg || params.nonveg) {
                 return
             }

             int rating = pizza.getFeedbackRating()
             if((params.lowRating && rating < 3) || (params.mediumRating && rating == 3) || (params.highRating && rating > 3)) {
                 addItem = true
             }
             else if(params.lowRating || params.mediumRating || params.highRating) {
                 return
             }

             String nutrition = params.nutrition
             double value = pizza.nutrition[nutrition]
             if((params.lowNutrition && ((nutrition == "calories" && value < 200) || (nutrition == "protein" && value < 11) ||
                     (nutrition == "fat" && value < 9) || (nutrition == "carbohydrate" && value < 29) || (nutrition == "fiber" && value < 2.6) ||
                     (nutrition == "sugar" && value < 3.6) || (nutrition == "calcium" && value < 22) || (nutrition == "iron" && value < 13) ||
                     (nutrition == "magnesium" && value < 7) || (nutrition == "potassium" && value < 182) || (nutrition == "sodium" && value < 650) ||
                     (nutrition == "vitaminC" && value < 2) || (nutrition == "vitaminB6" && value < 6) || (nutrition == "vitaminB12" && value < 7) ||
                     (nutrition == "vitaminA" && value < 8) || (nutrition == "vitaminD") || (nutrition == "fatSaturated" && value < 4.1) ||
                     (nutrition == "fatPoly" && value < 1.8) || (nutrition == "fatMono" && value < 2.8) || (nutrition == "cholesterol" && value < 18))) ||
                     (params.mediumNutrition && ((nutrition == "calories" && value >= 200 && value <= 250) || (nutrition == "protein" && value >= 11 && value <= 12)
                     || (nutrition == "fat" && value >= 9 && value <= 10) || (nutrition == "carbohydrate" && value >= 29 && value <= 32) ||
                             (nutrition == "fiber" && value >= 2.6 && value <= 2.7) || (nutrition == "sugar" && value >= 3.6 && value <= 3.7) ||
                             (nutrition == "calcium" && value >= 22 && value <= 23) || (nutrition == "iron" && value >= 13 && value <= 14) ||
                             (nutrition == "magnesium" && value >= 7 && value <= 7)  || (nutrition == "potassium" && value >= 182 && value <= 183) ||
                             (nutrition == "sodium" && value >= 650 && value <= 660) || (nutrition == "vitaminC" && value >= 2 && value <= 2) ||
                             (nutrition == "vitaminB6" && value >= 6 && value <= 6) || (nutrition == "vitaminB12" && value >= 6 && value <= 7) ||
                             (nutrition == "vitaminA" && value >= 8 && value <= 8) || (nutrition == "fatSaturated" && value >= 4.1 && value <= 4.1) ||
                             (nutrition == "fatPoly" && value >= 1.8 && value <= 1.8) || (nutrition == "fatMono" && value >= 2.8 && value <= 2.8) ||
                             (nutrition == "cholesterol" && value >= 18 && value <= 20))) || (params.highNutrition && ((nutrition == "calories" && value > 250)
             || (nutrition == "protein" && value > 12) || (nutrition == "fat" && value > 10) || (nutrition == "carbohydrate" && value > 32) ||
                     (nutrition == "fiber" && value > 2.7) || (nutrition == "sugar" && value > 3.7) || (nutrition == "calcium" && value > 23) ||
                     (nutrition == "iron" && value > 14) || (nutrition == "magnesium" && value > 7) || (nutrition == "potassium" && value > 183) ||
                     (nutrition == "vitaminC" && value > 2) || (nutrition == "vitaminB6" && value > 6) || (nutrition == "vitaminB12" && value > 6) ||
                     (nutrition == "vitaminA" && value > 8) || (nutrition == "fatSaturated" && value > 4.1) || (nutrition == "fatPoly" && value > 1.8) ||
                     (nutrition == "fatMono" && value > 2.8) || (nutrition == "cholesterol" && value > 20) || (nutrition == "sodium" && value > 660)))) {
                 addItem = true
             }
             else if(params.lowNutrition || params.mediumNutrition || params.highNutrition) {
                 return
             }

             if(addItem) {
                 searchedPizzas.add(pizza)
             }
         }

        def searchedSides = []
        menu.sides.each { side ->
            boolean addItem = false;
            if((params.lowPrice && side.price == 5) || (params.mediumPrice && side.price == 6) || (params.highPrice && side.price == 8)) {
                addItem = true
            }
            else if(params.lowPrice || params.mediumPrice || params.highPrice) {
                return
            }

            if((params.veg && side.type == "veg")  || (params.nonveg && side.type == "nonveg")){
                addItem = true
            }
            else if(params.veg || params.nonveg) {
                return
            }

            int rating = side.getFeedbackRating()
            if((params.lowRating && rating < 3) || (params.mediumRating && rating == 3) || (params.highRating && rating > 3)) {
                addItem = true
            }
            else if(params.lowRating || params.mediumRating || params.highRating) {
                return
            }

            String nutrition = params.nutrition
            double value = side.nutrition[nutrition]
            if((params.lowNutrition && ((nutrition == "calories" && value < 100) || (nutrition == "protein" && value < 10) || (nutrition == "fat" && value < 5)
            || (nutrition == "carbohydrate" && value < 10) || (nutrition == "fiber" && value < 1) || (nutrition == "sugar" && value < 1) ||
                    (nutrition == "calcium" && value < 2) || (nutrition == "iron" && value < 2) || (nutrition == "magnesium" && value < 3) ||
                    (nutrition == "potassium" && value < 100) || (nutrition == "sodium" && value < 500) || (nutrition == "vitaminC" && value < 2) ||
                    (nutrition == "vitaminB6" && value < 4) || (nutrition == "vitaminB12" && value < 6) || (nutrition == "vitaminA" && value < 8) ||
                    (nutrition == "vitaminD") || (nutrition == "fatSaturated" && value < 1) || (nutrition == "fatPoly" && value < 1) ||
                    (nutrition == "fatMono" && value < 1) || (nutrition == "cholesterol" && value < 10))) || (params.mediumNutrition &&
                    ((nutrition == "calories" && value >= 100 && value <= 200) || (nutrition == "protein" && value >= 10 && value <= 15) ||
                            (nutrition == "fat" && value >= 5 && value <= 10) || (nutrition == "carbohydrate" && value >= 10 && value <= 40) ||
                            (nutrition == "fiber" && value >= 1 && value <= 2) || (nutrition == "sugar" && value >= 1 && value <= 3) ||
                            (nutrition == "calcium" && value >= 2 && value <= 5) || (nutrition == "iron" && value >= 2 && value <= 10) ||
                            (nutrition == "magnesium" && value >= 3 && value <= 10) || (nutrition == "potassium" && value >= 100 && value <= 200) ||
                            (nutrition == "sodium" && value >= 500 && value <= 1000) || (nutrition == "vitaminC" && value >= 2 && value <= 2) ||
                            (nutrition == "vitaminB6" && value >= 4 && value <= 4) || (nutrition == "vitaminB12" && value >= 6 && value <= 6) ||
                            (nutrition == "vitaminA" && value >= 8 && value <= 8) || (nutrition == "fatSaturated" && value >= 1 && value <= 4) ||
                            (nutrition == "fatPoly" && value >= 1 && value <= 2) || (nutrition == "fatMono" && value >= 1 && value <= 2) ||
                            (nutrition == "cholesterol" && value >= 10 && value <= 50))) || (params.highNutrition && ((nutrition == "calories" && value > 200)
            || (nutrition == "protein" && value > 15) || (nutrition == "fat" && value > 10) || (nutrition == "carbohydrate" && value > 40) ||
                    (nutrition == "fiber" && value > 2) || (nutrition == "sugar" && value > 3) || (nutrition == "calcium" && value > 5) ||
                    (nutrition == "iron" && value > 10) || (nutrition == "magnesium" && value > 10) || (nutrition == "potassium" && value > 200) ||
                    (nutrition == "sodium" && value > 1000) || (nutrition == "vitaminC" && value > 2) || (nutrition == "vitaminB6" && value > 4) ||
                    (nutrition == "vitaminB12" && value > 6) || (nutrition == "vitaminA" && value > 8) || (nutrition == "fatSaturated" && value > 4) ||
                    (nutrition == "fatPoly" && value > 2) || (nutrition == "fatMono" && value > 2) || (nutrition == "cholesterol" && value > 20)))) {
                addItem = true;
            }
            else if(params.lowNutrition || params.mediumNutrition || params.highNutrition) {
                return
            }

            if(addItem) {
                searchedSides.add(side)
            }
        }

        def searchedDesserts = []
        menu.desserts.each { dessert ->
            boolean addItem = false;
            if((params.lowPrice && dessert.price == 4) || (params.mediumPrice && dessert.price == 5) || (params.highPrice && dessert.price == 6)) {
                addItem = true
            }
            else if(params.lowPrice || params.mediumPrice || params.highPrice) {
                return
            }

            if(params.veg){
                addItem = true
            }
            else if(params.nonveg) {
                return
            }

            int rating = dessert.getFeedbackRating()
            if((params.lowRating && rating < 3) || (params.mediumRating && rating == 3) || (params.highRating && rating > 3)) {
                addItem = true
            }
            else if(params.lowRating || params.mediumRating || params.highRating) {
                return
            }

            String nutrition = params.nutrition
            double value = dessert.nutrition[nutrition]
            if((params.lowNutrition && ((nutrition == "calories" && value < 110) || (nutrition == "protein") || (nutrition == "fat" && value < 4) ||
                    (nutrition == "carbohydrate" && value < 21) || (nutrition == "fiber" && value <= 1) || (nutrition == "potassium" ) ||
                    (nutrition == "sodium" && value < 110) || (nutrition == "vitaminC" ) || (nutrition == "vitaminB6" ) || (nutrition == "vitaminB12" ) ||
                    (nutrition == "vitaminA" ) || (nutrition == "vitaminD") || (nutrition == "cholesterol"))) || (params.mediumNutrition &&
                    ((nutrition == "calories" && value >= 110 && value <= 120) || (nutrition == "fat" && value >= 4 && value <= 4) ||
                            (nutrition == "carbohydrate" && value >= 21 && value <= 25) || (nutrition == "calcium") || (nutrition == "iron" ) ||
                            (nutrition == "magnesium") || (nutrition == "sodium" && value >= 110 && value <= 120))) || (params.highNutrition &&
                    ((nutrition == "calories" && value > 120) || (nutrition == "fat" && value > 4) || (nutrition == "carbohydrate" && value > 25) ||
                            (nutrition == "sugar") || (nutrition == "sodium" && value > 120) || (nutrition == "fatSaturated" ) || (nutrition == "fatPoly" )
                    || (nutrition == "fatMono" )))) {
                addItem = true
            }
            else if(params.lowNutrition || params.mediumNutrition || params.highNutrition) {
                return
            }

            if(addItem) {
                searchedDesserts.add(dessert)
            }
        }

        def searchedDrinks = []
        menu.drinks.each { drink ->
            boolean addItem = false;
            if((params.lowPrice && drink.price == 4) || (params.mediumPrice && drink.price == 5) || (params.highPrice && drink.price == 6)) {
                addItem = true
            }
            else if(params.lowPrice || params.mediumPrice || params.highPrice) {
                return
            }

            if(params.veg){
                addItem = true
            }
            else if(params.nonveg) {
                return
            }

            int rating = drink.getFeedbackRating()
            if((params.lowRating && rating < 3) || (params.mediumRating && rating == 3) || (params.highRating && rating > 3)) {
                addItem = true
            }
            else if(params.lowRating || params.mediumRating || params.highRating) {
                return
            }

            if(addItem) {
                searchedDrinks.add(drink)
            }
        }

        [searchedPizzas: searchedPizzas, searchedSides: searchedSides, searchedDesserts:searchedDesserts, searchedDrinks:searchedDrinks ]
    }

}
