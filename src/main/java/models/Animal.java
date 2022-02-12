package models;

public abstract class Animal {
    private static final String TYPE ="animal" ;
    public int id;
    public String name;
    public String type;


    public int getId() {
        return id;
    }

    public static String getTYPE() {
        return TYPE;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


    public void setId(int id){this.id = id;}

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }
}
