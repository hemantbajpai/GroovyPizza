package groovypizza

class Dessert {

    String name
    String description
    Nutrition nutrition
    int price

    static belongsTo = [menu: Menu]
    static hasMany = [feedbacks: Feedback]

    static constraints = {
        name blank:false, unique:true
        description blank:false, unique:true
    }

}
