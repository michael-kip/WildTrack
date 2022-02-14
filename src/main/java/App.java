import dao.Sql2oAnimalDao;
import dao.Sql2oEndangeredDao;
import models.AddAnimal;
import models.Animal;
import models.EndangeredAnimals;
import org.sql2o.Sql2o;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
//        Sql2o sql2o= new Sql2o("jdbc:postgresql://localhost:4567/wildtracker","moringa","");
        String connectmetodatabase = "jdbc:h2:~/wildtracker.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectmetodatabase, "moringa", "");
        Sql2oAnimalDao sql2oAnimalDao = new Sql2oAnimalDao(sql2o);
        Sql2oEndangeredDao sql2oEndangeredDao = new Sql2oEndangeredDao(sql2o);
        get("/",(request,response)->{
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "/index.hbs");
        },new HandlebarsTemplateEngine());

        get("/endangered",(request, response) -> {
            Map<String,Object> model = new HashMap<String, Object>();
            model.put("animals", EndangeredAnimals.TYPE);
            return new ModelAndView(model,"sighting_form.hbs");
        }, new HandlebarsTemplateEngine());

        post("/endangered_view/new",(request, response) -> {
            Map<String, ArrayList<EndangeredAnimals>> model = new HashMap<String, ArrayList<EndangeredAnimals>>();
            String name = request.queryParams("name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            String location = request.queryParams("location");
            String ranger = request.queryParams("ranger");

            EndangeredAnimals endangeredAnimals =new EndangeredAnimals(name,health, age, location, ranger);
            sql2oEndangeredDao.add(endangeredAnimals);
            return  new ModelAndView(model,"endangered_view.hbs");
        },new HandlebarsTemplateEngine());



        get("/endangered_view/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<EndangeredAnimals>endangeredAll1=sql2oEndangeredDao.findAll();
            model.put("endangeredAll1",endangeredAll1);
            return  new ModelAndView(model,"sighting_view.hbs");
        }, new HandlebarsTemplateEngine());
        get("/animal",(request, response) ->{
            Map<String,Object>model = new HashMap<String, Object>();
            return new ModelAndView(model,"animal_form.hbs");
        },new HandlebarsTemplateEngine() );

        post("/animal_view", (request, response) -> {
            Map<String,ArrayList<Animal>> model = new HashMap<String, ArrayList<Animal>>();
            String name = request.queryParams("name");
            AddAnimal addAnimal = new AddAnimal(name);
            sql2oAnimalDao.add(addAnimal);
            return new ModelAndView(model,"animal_view.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered/all", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<EndangeredAnimals> endangeredAnimals=sql2oAnimalDao.findAll();
            model.put("endangeredAnimals",endangeredAnimals);
            return  new ModelAndView(model,"animal_view.hbs");
        }, new HandlebarsTemplateEngine());

        get("/endangered/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            sql2oEndangeredDao.deleteAll();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        get("/non_endangered/delete", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            sql2oAnimalDao.deleteAll();
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());


    }

}

