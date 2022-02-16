package dao;

import models.Animal;
import models.EndangeredAnimals;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;


import java.util.List;

public class  Sql2oAnimalDao implements AnimalDao {
    private final Sql2o sql2o;
    public Sql2oAnimalDao(Sql2o sql2o) {

        this.sql2o = sql2o; //makes sql2o available everywhere for methods to be called on it
    }
    @Override
    public void add(Animal animal) {
        String sql = "INSERT INTO endangered (name,health,age,location,ranger) VALUES(:name,:health,:age,:location,:ranger)";
        try(org.sql2o.Connection con= sql2o.open()){//open a connection
            int id = (int) con.createQuery(sql,true)//make new variable
                    .bind(animal)//map argument onto query
                    .executeUpdate()//run it all
                    .getKey();//int id is row no of db
            animal.setId(id);//update object to set id from db
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }
    @Override
    public List<EndangeredAnimals> findAll() {
        try( Connection con = sql2o.open()) {
            return con.createQuery("SELECT * FROM endangered ")
                    .executeAndFetch(EndangeredAnimals.class);//fetch list
        }
    }


    @Override
    public Animal findById(int id) {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM animals WHERE id=:id")
                    .addParameter("id",id)//key/value pair,
                    .executeAndFetchFirst(Animal.class);//fetch an individual
        }
    }


    @Override
    public void deleteAll() {String sql = "DELETE FROM endangered";
        try(org.sql2o.Connection con = sql2o.open()){
            con.createQuery(sql)
                    .executeUpdate();
        }catch(Sql2oException ex){
            System.out.println(ex);
        }

    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM endangered WHERE id=:id";
        try(org.sql2o.Connection con = sql2o.open()){
            con.createQuery(sql)
                    .addParameter("id",id)
                    .executeUpdate();
        }catch(Sql2oException ex){
            System.out.println(ex);
        }
    }
}