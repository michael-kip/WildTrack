package models;

import java.util.Map;

public abstract class Animal {
    private static final String TYPE ="animal" ;
    public int id;
    public String name;
    public String type;

    public static void deleteAll() {
    }

    public int getId() {
        return id;
    }

    public static String getTYPE() {
        return TYPE;
    }

    public String getName()
    {
        return name = name;
    }

    public String getType()
    {
        return type;
    }


    public void setId(int id){
        this.id = id;}

    public void setName(String name)
    {
        this.name = name;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
