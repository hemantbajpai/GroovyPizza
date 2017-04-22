package groovypizza

class DrinkFeedback extends Feedback{

    static belongsTo = [drink:Drink]

    static constraints = {
    }
}
