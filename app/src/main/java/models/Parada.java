package models;

/**
 * Created by gonzalobarbalopez on 23/06/14.
 */
public class Parada {

    //attributes
    private int id;
    private String name;

    //Contructor
    public Parada(){

    }

    public Parada(int id, String name){
        this.id = id;
        this.name = name;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
