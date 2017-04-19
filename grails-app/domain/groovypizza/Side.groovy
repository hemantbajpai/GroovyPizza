package groovypizza

class Side {

    String name
    String type
    String description
    Nutrition nutrition

    static belongsTo = [menu: Menu]
    static hasMany = [feedbacks: Feedback]

    static constraints = {
        name blank:false, unique:true
        description blank:false, unique:true
        type inList:["veg", "nonveg"]
    }
}
