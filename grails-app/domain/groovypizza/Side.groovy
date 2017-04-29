package groovypizza

class Side {

    int price
    String name
    String type
    String description
    Nutrition nutrition

    static belongsTo = [menu: Menu]
    static hasMany = [feedbacks: SideFeedback]

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
