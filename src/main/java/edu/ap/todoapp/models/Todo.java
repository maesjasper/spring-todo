package edu.ap.todoapp.models;

import javax.persistence.*;

/**
 * Created by Jasper on 23/08/2017.
 */
@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "beschrijving")
    private String beschrijving;

    @Basic
    @Column(name = "status")
    private boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
