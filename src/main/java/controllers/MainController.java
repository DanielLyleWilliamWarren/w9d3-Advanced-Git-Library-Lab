package controllers;

import db.DBHelper;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class MainController {
    public static void main(String[] args) {

        BookController bookController = new BookController();
        BorrowerController borrowerController = new BorrowerController();


        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/home.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);
    }
}

