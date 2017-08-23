package edu.test;

import javax.persistence.*;

/**
 * Created by Jasper on 23/08/2017.
 */
@Entity
@Table(name = "todo", schema = "todo", catalog = "")
public class TodoEntity {
    private int id;
    private String beschrijving;
    private Byte status;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "beschrijving")
    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    @Basic
    @Column(name = "status")
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TodoEntity that = (TodoEntity) o;

        if (id != that.id) return false;
        if (beschrijving != null ? !beschrijving.equals(that.beschrijving) : that.beschrijving != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (beschrijving != null ? beschrijving.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
