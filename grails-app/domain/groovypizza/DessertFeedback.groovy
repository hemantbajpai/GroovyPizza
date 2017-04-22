package groovypizza

class DessertFeedback extends Feedback{

    static belongsTo = [dessert: Dessert]

    static constraints = {
    }
}
