package groovypizza

class Pizza {

    String name
    String description
    String type
    List<Topping> toppingList
    Nutrition nutrition
    int price

    static belongsTo = [menu: Menu]
    static hasMany = [feedbacks: PizzaFeedback]

    static constraints = {
        price min: 0
        name blank:false, unique:true
        description blank:false, unique:true
        type inList:["veg", "nonveg"]
    }
}
