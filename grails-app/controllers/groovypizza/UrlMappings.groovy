package groovypizza

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/myorder/deleteItem"(controller: "MyOrder", action:"deleteItem")
        "/myorder/changeSize"(controller: "MyOrder", action:"changeSize")
        "/myorder/changeQuantity"(controller: "MyOrder", action:"changeQuantity")
        "/myorder/show/$id"(controller: "MyOrder", action:"show")
        "/orderhistory"(controller: "MyOrder", action: "orderhistory")
        "/search"(controller: "Menu", action: "search")
        "/signup"(controller: "MyOrder", action: "signup")
        "/menu"(controller: "Menu", action: "menu")
        "/mycurrentorder"(controller: "MyOrder", action: "myCurrentOrder")
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
