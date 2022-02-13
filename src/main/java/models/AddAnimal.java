package models;

public class AddAnimal extends Animal{
    public AddAnimal(String name){
        this.name=name;
        this.id=id;
    }

    public static void getAll() {
    }

    public String getName(){

        return name;
    }

    public  void setId(int id){

        this.id=id;
    }

    @Override
    public String getType() {

        return super.getType();
    }
}
