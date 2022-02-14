package dao;

import models.Animal;
import models.EndangeredAnimals;

import java.util.List;

public interface AnimalDao {
    void add(Animal animal);
    List<EndangeredAnimals> findAll();
    Animal findById(int id);
    void deleteAll();
    void deleteById(int id);
}
