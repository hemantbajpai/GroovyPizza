package groovypizza

class SideFeedback extends Feedback{

    static belongsTo = [side:Side]

    static constraints = {
    }
}
