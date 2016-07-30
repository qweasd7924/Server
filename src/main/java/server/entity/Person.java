package server.entity;

import javax.persistence.*;

/**
 * Created by Павел on 30.07.2016.
 */
@Entity(name = "person")
@Table
@NamedQuery(name = "Person.getAll", query = "select p from person p")
public class Person {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String surname;

    public Person() {
    }

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    //getters and setters
}
