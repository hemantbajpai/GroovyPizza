package groovypizza

class Side {

    int price
    String name
    String type
    String description
    Nutrition nutrition

    static belongsTo = [menu: Menu]
    static hasMany = [feedbacks: SideFeedback]

    static constraints = {
        price min: 0
        name blank:false, unique:true
        description blank:false, unique:true
        type inList:["veg", "nonveg"]
    }
}
