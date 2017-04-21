package groovypizza

class Drink {

    String name
    int price
    static belongsTo = [menu: Menu]
    static hasMany = [feedbacks: Feedback]

    static constraints = {
        name blank:false, unique:true
    }
}
