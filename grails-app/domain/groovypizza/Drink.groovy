package groovypizza

class Drink {

    String name
    int price
    String description
    static belongsTo = [menu: Menu]
    static hasMany = [feedbacks: DrinkFeedback]

    static constraints = {
        price min: 0
        name blank:false, unique:true
        description blank:false, unique:true
    }
}
