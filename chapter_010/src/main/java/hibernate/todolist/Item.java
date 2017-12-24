package hibernate.todolist;

import java.sql.Timestamp;

/**
 * Created by Андрей on 07.12.2017.
 */
public class Item {

    private Integer id;

    private String descr;

    private String created;

    private Boolean done;

    public Item() {}

    public Item(Integer id, String descr, String created, Boolean done) {
        this.id = id;
        this.descr = descr;
        this.created = created;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public String getDescr() {
        return descr;
    }

    public String getCreated() {
        return created;
    }

    public Boolean getDone() {
        return done;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
