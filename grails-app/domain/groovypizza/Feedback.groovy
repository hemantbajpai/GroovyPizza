package groovypizza

import order.User

class Feedback {

    User user
    int rating
    String text
    Date dateCreated

    boolean approved

    static constraints = {
        rating max: 5, min: 1
    }
}
