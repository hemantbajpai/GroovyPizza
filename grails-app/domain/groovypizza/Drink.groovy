package groovypizza

class Drink {

    String name

    static belongsTo = [menu: Menu]
    static hasMany = [feedbacks: Feedback]

    static constraints = {
        name blank:false, unique:true
    }
}
