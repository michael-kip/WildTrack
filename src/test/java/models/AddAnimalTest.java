package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddAnimalTest {
    @Test
    public void AllAddAnimalAreCorrectlyReturned_true() {
        AddAnimal addAnimal = new AddAnimal("Lion");
        AddAnimal otherAnimal = new AddAnimal ("Zebra");
        assertEquals(4, addAnimal.getName().length());

    }

}