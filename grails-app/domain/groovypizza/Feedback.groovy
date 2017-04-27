package groovypizza

import order.User

class Feedback {

    User user
    int rating
    String text
    Date dateCreated

    boolean approved
    boolean pending
    static constraints = {
        rating max: 5, min: 1
        text blank:false
    }
}
