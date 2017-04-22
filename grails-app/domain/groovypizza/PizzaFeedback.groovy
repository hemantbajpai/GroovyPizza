package groovypizza

class PizzaFeedback extends Feedback {

    static belongsTo = [pizza: Pizza]

    static constraints = {
    }
}
