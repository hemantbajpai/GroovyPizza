package groovypizza

class Menu {

    static hasMany = [pizzas:Pizza, sides: Side, desserts: Dessert, drinks: Drink]

    static constraints = {
    }
}
