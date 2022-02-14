package dao;

import models.EndangeredAnimals;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EndangeredDaoTest {
    EndangeredDao endangeredDao = new EndangeredDao() {
        @Test
        public void addAnimal()throws Exception {
            EndangeredAnimals endangeredAnimals= new EndangeredAnimals("aro","heatlth","young","secB");
            int myid = endangeredAnimals.getId();
            endangeredAnimals.add(endangeredAnimals);
            assertNotEquals(myid,endangeredAnimals.getId());
        }

        @Test
        public void createdAnimalCanBeFoundByfindById() throws Exception {
            EndangeredAnimals endangeredAnimals= new EndangeredAnimals("aro","heatlth","young","secB");
            endangeredAnimals.add(endangeredAnimals);
            EndangeredAnimals foundEndangered = endangeredDao.findById(endangeredAnimals.getId());
            assertEquals(endangeredAnimals,foundEndangered);
        }
        @Override
        public EndangeredAnimals findById(int id) {
            return null;
        }

        @Override
        public void deleteAll() {

        }

        @Override
        public void deleteById(int id) {

        }
    }
}