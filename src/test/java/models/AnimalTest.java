package models;

import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AnimalTest{
    @Test
    public void NewAnimalObjectGetsCorrectlyCreated_true() throws Exception {
        Animal animal = new AddAnimal("name");
        assertEquals(true, animal instanceof Animal);
    }
    @Test
    public void AnimalInstantiatesWithContent_true() throws Exception {
        Animal animal = new AddAnimal("Lion");
        assertEquals("Lion", animal.getName());

    }
    @After
    public void tearDown() {
        Animal.deleteAll(); //clear out all the posts before each test.
    }
    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Animal animal = new AddAnimal("Lion");
        Animal otherAnimal = new AddAnimal ("Zebra");
        assertEquals(4, animal.getName().length());

    }

}