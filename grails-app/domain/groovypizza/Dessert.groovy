package groovypizza

class Dessert {

    String name
    String description
    Nutrition nutrition
    int price

    static belongsTo = [menu: Menu]
    static hasMany = [feedbacks: DessertFeedback]

    static constraints = {
        price min: 0
        name blank:false, unique:true
        description blank:false, unique:true
    }

}
