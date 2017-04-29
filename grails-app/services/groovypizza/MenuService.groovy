package groovypizza

import grails.transaction.Transactional

@Transactional
class MenuService {

    def static getSearchResults(params) {

        def  searchedPizzas = []
         Menu.first().pizzas.each { pizza ->
            if(params.lowPrice && pizza.price <= 10) {
                if(!searchedPizzas.contains(pizza))
                    searchedPizzas.add(pizza)
            }
             if(params.mediumPrice && pizza.price > 10 && pizza.price < 12) {
                 if(!searchedPizzas.contains(pizza))
                     searchedPizzas.add(pizza)
             }
             if(params.highPrice && pizza.price >= 12) {
                 if(!searchedPizzas.contains(pizza))
                     searchedPizzas.add(pizza)
             }
             if(params.veg && pizza.type == "veg") {
                 if(!searchedPizzas.contains(pizza))
                     searchedPizzas.add(pizza)
             }
             if(params.nonveg && pizza.type == "nonveg") {
                 if(!searchedPizzas.contains(pizza))
                     searchedPizzas.add(pizza)
             }
             int rating = pizza.getFeedbackRating()
             if(params.lowRating && rating < 3) {
                 if(!searchedPizzas.contains(pizza))
                     searchedPizzas.add(pizza)
             }
             if(params.mediumRating && rating == 3) {
                 if(!searchedPizzas.contains(pizza))
                     searchedPizzas.add(pizza)
             }
             if(params.highRating && rating > 3) {
                 if(!searchedPizzas.contains(pizza))
                     searchedPizzas.add(pizza)
             }
             String nutrition = params.nutrition
             double value = pizza.nutrition[nutrition]
             if(params.lowNutrition) {
                 if(nutrition == "calories" && value < 200) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "protein" && value < 11) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fat" && value < 9) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "carbohydrate" && value < 29) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fiber" && value < 2.6) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "sugar" && value < 3.6) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "calcium" && value < 22) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "iron" && value < 13) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "magnesium" && value < 7) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "potassium" && value < 182) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "sodium" && value < 650) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "vitaminC" && value < 2) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "vitaminB6" && value < 6) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "vitaminB12" && value < 7) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "vitaminA" && value < 8) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "vitaminD") {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fatSaturated" && value < 4.1) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fatPoly" && value < 1.8) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fatMono" && value < 2.8) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "cholesterol" && value < 18) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
             }
             if(params.mediumNutrition) {
                 if(nutrition == "calories" && value >= 200 && value <= 250) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "protein" && value >= 11 && value <= 12) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fat" && value >= 9 && value <= 10) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "carbohydrate" && value >= 29 && value <= 32) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fiber" && value >= 2.6 && value <= 2.7) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "sugar" && value >= 3.6 && value <= 3.7) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "calcium" && value >= 22 && value <= 23) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "iron" && value >= 13 && value <= 14) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "magnesium" && value >= 7 && value <= 7) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "potassium" && value >= 182 && value <= 183) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "sodium" && value >= 650 && value <= 660) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "vitaminC" && value >= 2 && value <= 2) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "vitaminB6" && value >= 6 && value <= 6) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "vitaminB12" && value >= 6 && value <= 7) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "vitaminA" && value >= 8 && value <= 8) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fatSaturated" && value >= 4.1 && value <= 4.1) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fatPoly" && value >= 1.8 && value <= 1.8) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fatMono" && value >= 2.8 && value <= 2.8) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "cholesterol" && value >= 18 && value <= 20) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
             }
             if(params.highNutrition) {
                 if(nutrition == "calories" && value > 250) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "protein" && value > 12) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fat" && value > 10) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "carbohydrate" && value > 32) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fiber" && value > 2.7) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "sugar" && value > 3.8) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "calcium" && value > 23) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "iron" && value > 14) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "magnesium" && value > 7) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "potassium" && value > 183) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "sodium" && value > 660) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "vitaminC" && value > 2) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "vitaminB6" && value > 6) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "vitaminB12" && value > 6) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "vitaminA" && value > 8) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fatSaturated" && value > 4.1) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fatPoly" && value > 1.8) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "fatMono" && value > 2.8) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
                 if(nutrition == "cholesterol" && value > 20) {
                     if (!searchedPizzas.contains(pizza))
                         searchedPizzas.add(pizza)
                 }
             }
         }

        def searchedSides = []
        Menu.first().sides.each { side ->
            if(params.lowPrice && side.price == 5) {
                if(!searchedSides.contains(side))
                    searchedSides.add(side)
            }
            if(params.mediumPrice && side.price == 6) {
                if(!searchedSides.contains(side))
                    searchedSides.add(side)
            }
            if(params.highPrice && side.price == 8) {
                if(!searchedSides.contains(side))
                    searchedSides.add(side)
            }
            if(params.veg && side.type == "veg") {
                if(!searchedSides.contains(side))
                    searchedSides.add(side)
            }
            if(params.nonveg && side.type == "nonveg") {
                if(!searchedSides.contains(side))
                    searchedSides.add(side)
            }
            int rating = side.getFeedbackRating()
            if(params.lowRating && rating < 3) {
                if(!searchedSides.contains(side))
                    searchedSides.add(side)
            }
            if(params.mediumRating && rating == 3) {
                if(!searchedSides.contains(side))
                    searchedSides.add(side)
            }
            if(params.highRating && rating > 3) {
                if(!searchedSides.contains(side))
                    searchedSides.add(side)
            }
            String nutrition = params.nutrition
            double value = side.nutrition[nutrition]
            if(params.lowNutrition) {
                if(nutrition == "calories" && value < 100) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "protein" && value < 10) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fat" && value < 5) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "carbohydrate" && value < 10) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fiber" && value < 1) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "sugar" && value < 1) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "calcium" && value < 2) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "iron" && value < 2) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "magnesium" && value < 3) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "potassium" && value < 100) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "sodium" && value < 500) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "vitaminC" && value < 2) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "vitaminB6" && value < 4) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "vitaminB12" && value < 6) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "vitaminA" && value < 8) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "vitaminD") {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fatSaturated" && value < 1) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fatPoly" && value < 1) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fatMono" && value < 1) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "cholesterol" && value < 10) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
            }
            if(params.mediumNutrition) {
                if(nutrition == "calories" && value >= 100 && value <= 200) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "protein" && value >= 10 && value <= 15) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fat" && value >= 5 && value <= 10) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "carbohydrate" && value >= 10 && value <= 40) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fiber" && value >= 1 && value <= 2) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "sugar" && value >= 1 && value <= 3) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "calcium" && value >= 2 && value <= 5) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "iron" && value >= 2 && value <= 10) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "magnesium" && value >= 3 && value <= 10) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "potassium" && value >= 100 && value <= 200) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "sodium" && value >= 500 && value <= 1000) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "vitaminC" && value >= 2 && value <= 2) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "vitaminB6" && value >= 4 && value <= 4) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "vitaminB12" && value >= 6 && value <= 6) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "vitaminA" && value >= 8 && value <= 8) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fatSaturated" && value >= 1 && value <= 4) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fatPoly" && value >= 1 && value <= 2) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fatMono" && value >= 1 && value <= 2) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "cholesterol" && value >= 10 && value <= 50) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
            }
            if(params.highNutrition) {
                if(nutrition == "calories" && value > 200) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "protein" && value > 15) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fat" && value > 10) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "carbohydrate" && value > 40) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fiber" && value > 2) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "sugar" && value > 3) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "calcium" && value > 5) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "iron" && value > 10) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "magnesium" && value > 10) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "potassium" && value > 200) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "sodium" && value > 1000) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "vitaminC" && value > 2) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "vitaminB6" && value > 4) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "vitaminB12" && value > 6) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "vitaminA" && value > 8) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fatSaturated" && value > 4) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fatPoly" && value > 2) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "fatMono" && value > 2) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
                if(nutrition == "cholesterol" && value > 20) {
                    if (!searchedSides.contains(side))
                        searchedSides.add(side)
                }
            }
        }

        def searchedDesserts = []
        Menu.first().desserts.each { dessert ->
            if(params.lowPrice && dessert.price == 4) {
                if(!searchedDesserts.contains(dessert))
                    searchedDesserts.add(dessert)
            }
            if(params.mediumPrice && dessert.price == 5) {
                if(!searchedDesserts.contains(dessert))
                    searchedDesserts.add(dessert)
            }
            if(params.highPrice && dessert.price == 6) {
                if(!searchedDesserts.contains(dessert))
                    searchedDesserts.add(dessert)
            }
            if(params.veg) {
                if(!searchedDesserts.contains(dessert))
                    searchedDesserts.add(dessert)
            }
            int rating = dessert.getFeedbackRating()
            if(params.lowRating && rating < 3) {
                if(!searchedDesserts.contains(dessert))
                    searchedDesserts.add(dessert)
            }
            if(params.mediumRating && rating == 3) {
                if(!searchedDesserts.contains(dessert))
                    searchedDesserts.add(dessert)
            }
            if(params.highRating && rating > 3) {
                if(!searchedDesserts.contains(dessert))
                    searchedDesserts.add(dessert)
            }
            String nutrition = params.nutrition
            double value = dessert.nutrition[nutrition]
            if(params.lowNutrition) {
                if(nutrition == "calories" && value < 110) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "protein") {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "fat" && value < 4) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "carbohydrate" && value < 21) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "fiber" && value < 1) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }

                if(nutrition == "potassium" ) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "sodium" && value < 110) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "vitaminC" ) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "vitaminB6" ) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "vitaminB12" ) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "vitaminA" ) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "vitaminD") {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "cholesterol") {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
            }
            if(params.mediumNutrition) {
                if(nutrition == "calories" && value >= 110 && value <= 120) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "fat" && value >= 4 && value <= 4) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "carbohydrate" && value >= 21 && value <= 25) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "calcium") {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "iron" ) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "magnesium") {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "sodium" && value >= 110 && value <= 120) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
            }
            if(params.highNutrition) {
                if(nutrition == "calories" && value > 120) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "fat" && value > 4) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "carbohydrate" && value > 25) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "sugar") {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "sodium" && value > 120) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "fatSaturated" ) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "fatPoly" ) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
                if(nutrition == "fatMono" ) {
                    if (!searchedDesserts.contains(dessert))
                        searchedDesserts.add(dessert)
                }
            }
        }

        def searchedDrinks = []
        Menu.first().drinks.each { drink ->
            if(params.lowPrice && drink.price == 4) {
                if(!searchedDrinks.contains(drink))
                    searchedDrinks.add(drink)
            }
            if(params.mediumPrice && drink.price == 5) {
                if(!searchedDrinks.contains(drink))
                    searchedDrinks.add(drink)
            }
            if(params.highPrice && drink.price == 6) {
                if(!searchedDrinks.contains(drink))
                    searchedDrinks.add(drink)
            }
            if(params.veg) {
                if(!searchedDrinks.contains(drink))
                    searchedDrinks.add(drink)
            }
            int rating = drink.getFeedbackRating()
            if(params.lowRating && rating < 3) {
                if(!searchedDrinks.contains(drink))
                    searchedDrinks.add(drink)
            }
            if(params.mediumRating && rating == 3) {
                if(!searchedDrinks.contains(drink))
                    searchedDrinks.add(drink)
            }
            if(params.highRating && rating > 3) {
                if(!searchedDrinks.contains(drink))
                    searchedDrinks.add(drink)
            }
        }

        [searchedPizzas: searchedPizzas, searchedSides: searchedSides, searchedDesserts:searchedDesserts, searchedDrinks:searchedDrinks ]
    }

}
