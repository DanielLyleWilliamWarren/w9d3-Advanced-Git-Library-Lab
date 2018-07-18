package controllers;

import db.DBHelper;
import models.Borrower;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class BorrowerController {
    public BorrowerController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        get("/borrowers", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/borrowers/index.vtl");
            List<Borrower> borrowers = DBHelper.getAll(Borrower.class);
            model.put("borrowers", borrowers);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("/borrowers/new", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/borrowers/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/borrowers/:id/delete", (request, response) -> {
            DBHelper.delete(DBHelper.find(Integer.parseInt(request.params("id")), Borrower.class));
            response.redirect("/borrowers");
            return null;
        }, velocityTemplateEngine);

        post("/borrowers", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            Borrower newBorrower = new Borrower(name);
            DBHelper.save(newBorrower);
            response.redirect("/borrowers");
            return null;
        }, velocityTemplateEngine);

        get("/borrowers/:id/edit", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("borrower", DBHelper.find(Integer.parseInt(request.params("id")), Borrower.class));
            model.put("template", "templates/borrowers/update.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/borrowers/:id", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            Borrower newBorrower = new Borrower(name);
            newBorrower.setId(Integer.parseInt(request.params("id")));
            DBHelper.update(newBorrower);
            response.redirect("/borrowers");
            return null;
        }, velocityTemplateEngine);
    }
}
