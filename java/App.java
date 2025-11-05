
import controller.CollectibleController;
import controller.WebSocketPriceChannel;
import store.exception.GlobalExceptionHandler;

//import spark.template.mustache.MustacheTemplateEngine;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {

        port(4567);

        staticFiles.location("/public");

        webSocket("/price-updates", WebSocketPriceChannel.class);
        init();

//        get("/", (req, res) -> new ModelAndView(null, "index.mustache"),
//                new MustacheTemplateEngine()
//        );
        GlobalExceptionHandler.register();
        new CollectibleController().routes();

    }
}


