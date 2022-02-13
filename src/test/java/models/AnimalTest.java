package models;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest{
    @Test
    public void NewAnimalObjectGetsCorrectlyCreated_true() throws Exception {
        Animal animal = new AddAnimal("name");
        assertEquals(true, animal instanceof Animal);
    }
}