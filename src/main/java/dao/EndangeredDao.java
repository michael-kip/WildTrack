package dao;

import models.EndangeredAnimals;

import java.util.List;

public interface EndangeredDao {
    void add(EndangeredAnimals endangeredAnimals);
    List<EndangeredAnimals> findAll();
    EndangeredAnimals findById(int id);
    void deleteAll();
    void deleteById(int id);
}
