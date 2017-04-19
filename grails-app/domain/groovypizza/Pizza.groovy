package groovypizza

class Pizza {

    String name
    String description
    String type
    List<Topping> toppingList
    Nutrition nutrition

    static belongsTo = [menu: Menu]
    static hasMany = [feedbacks: Feedback]

    static constraints = {
        name blank:false, unique:true
        description blank:false, unique:true
        type inList:["veg", "nonveg"]
    }
}
