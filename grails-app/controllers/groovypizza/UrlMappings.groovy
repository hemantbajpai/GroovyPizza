package groovypizza

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
        "/search"(controller: "Menu", action: "search")
        "/signup"(controller: "MyOrder", action: "signup")
        "/menu"(controller: "Menu", action: "menu")
        "/mycurrentorder"(controller: "MyOrder", action: "myCurrentOrder")
        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
