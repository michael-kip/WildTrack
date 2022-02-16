package dao;

import models.AddAnimal;
import models.Animal;
import models.EndangeredAnimals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.sql2o.Sql2o;

import java.sql.Connection;
import java.util.List;

import static org.junit.Assert.*;

public class AnimalDaoTest {
    private Sql2oAnimalDao animalDao;
    private Connection conn;

    @Before
    public void setUp() throws Exception {
        String connectionString = "jdbc:h2:~/wildtracker.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString, "", "");
         animalDao= new Sql2oAnimalDao(sql2o);
        conn = (Connection) sql2o.open(); //keep connection open through entire test so it does not get erased
    }

    @After
    public void tearDown() throws Exception {
        conn.close();
    }

    @Test
    public void addingAnimalSetsId() throws Exception{
        Animal animal = new AddAnimal("Lion");
        int myid = animal.getId();
        animalDao.add(animal);

        assertNotEquals(myid, animal.getId());
    }
    @Test
    public void findAll() {
        Animal animal = new AddAnimal("lion");
        animalDao.add(animal);
        Animal foundEndangered = animalDao.findById(animal.getId());
        assertNotEquals(animal,foundEndangered);
    }
    @Test
    public void existingAnimalsCanBeFoundById() {
        Animal not = new AddAnimal ("lion");
        animalDao.add(not);
        Animal found = animalDao.findById(not.getId());
        assertEquals(not, found);
    }
}