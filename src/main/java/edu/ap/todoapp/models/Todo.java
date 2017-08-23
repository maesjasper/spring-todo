package edu.ap.todoapp.models;

import javax.persistence.*;

/**
 * Created by Jasper on 23/08/2017.
 */
@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Basic
    @Column(name = "beschrijving")
    private String beschrijving;

    @Basic
    @Column(name = "status")
    private boolean status;

    //indien je zelf een constructor aanmaakt ook steeds een lege constructor voorzien.
    public Todo(String beschrijving, boolean status) {
        this.beschrijving = beschrijving;
        this.status = status;
    }


    public Todo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
