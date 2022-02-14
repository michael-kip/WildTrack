package dao;

import models.AddAnimal;
import models.Animal;
import models.EndangeredAnimals;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AnimalDaoTest {
    AnimalDao animalDao = new AnimalDao();
    @Test
    public void add(){
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
}