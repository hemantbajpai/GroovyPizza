package groovypizza

class Topping {

    String name

    static belongsTo = [menu:Menu]

    static constraints = {
        name blank:false, unique:true
    }
}
