package dao;

import models.Animal;
import models.EndangeredAnimals;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;


import java.util.List;

public class Sql2oAnimalDao implements AnimalDao {
    private Sql2o sql2o;
    public Sql2oAnimalDao(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    @Override
    public void add(Animal animal) {
        String sql = "INSERT INTO endangered (name,health,age,location,ranger) VALUES(:name,:health,:age,:location,:ranger)";
        try(org.sql2o.Connection con= sql2o.open()){
            int id = (int) con.createQuery(sql,true)
                    .bind(animal)
                    .executeUpdate()
                    .getKey();
            animal.setId(id);
        }catch (Sql2oException e){
            System.out.println(e);
        }
    }

    @Override
    public List<EndangeredAnimals> findAll() {
        try( org.sql2o.Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM endangered ")
                    .executeAndFetch(EndangeredAnimals.class);
        }
    }


    @Override
    public Animal findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE id=:id")
                    .addParameter("id",id)
                    .executeAndFetchFirst(Animal.class);
        }
    }


    @Override
    public void deleteAll() {String sql = "DELETE FROM endangered";
        try(org.sql2o.Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println(e);
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM endangered WHERE id=:id";
        try(org.sql2o.Connection con = sql2o.open()){
            con.createQuery(sql).addParameter("id",id)
                    .executeUpdate();
        }catch(Sql2oException e){
            System.out.println("runnn");
        }
    }
}