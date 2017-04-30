package groovypizza

class Pizza {

    String name
    String description
    String type
    Nutrition nutrition
    int price

    static belongsTo = [menu: Menu]
    static hasMany = [feedbacks: PizzaFeedback]

    def getFeedbackRating() {
        if (feedbacks.size() == 0)
            5
        else {
            int totalRating = 0
            feedbacks.each {
                totalRating += it.rating
            }
            totalRating / feedbacks.size()
        }
    }

    static constraints = {
        price min: 0
        name blank:false, unique:true
        description blank:false, unique:true
        type inList:["veg", "nonveg"]
    }
}
