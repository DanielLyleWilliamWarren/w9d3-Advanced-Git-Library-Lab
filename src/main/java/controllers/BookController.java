package controllers;

import db.DBHelper;
import models.Book;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class BookController {
    public BookController() {
        this.setupEndpoints();
    }

    private void setupEndpoints() {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        get("/books", (req, res) -> {
            Map<String, Object> model = new HashMap();
            model.put("template", "templates/books/index.vtl");
            List<Book> books = DBHelper.getAll(Book.class);
            model.put("books", books);
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        get("/books/new", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("template", "templates/books/create.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/books/:id/delete", (request, response) -> {
            DBHelper.delete(DBHelper.find(Integer.parseInt(request.params("id")), Book.class));
            response.redirect("/books");
            return null;
        }, velocityTemplateEngine);

        post("/books", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            String title = request.queryParams("title");
            String author = request.queryParams("author");
            Book newBook = new Book(title, author);
            DBHelper.save(newBook);
            response.redirect("/books");
            return null;
        }, velocityTemplateEngine);

        get("/books/:id/edit", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            model.put("book", DBHelper.find(Integer.parseInt(request.params("id")), Book.class));
            model.put("template", "templates/books/update.vtl");
            return new ModelAndView(model, "templates/layout.vtl");
        }, velocityTemplateEngine);

        post("/books/:id", (request, response) -> {
            HashMap<String, Object> model = new HashMap<>();
            String title = request.queryParams("title");
            String author = request.queryParams("author");
            Book newBook = new Book(title, author);
            newBook.setId(Integer.parseInt(request.params("id")));
            DBHelper.update(newBook);
            response.redirect("/books");
            return null;
        }, velocityTemplateEngine);
    }
}
