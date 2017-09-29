package ru.job4j;

import java.sql.Timestamp;

/**
 * class DBItem.
 */
public class DBItem {
    /**
     * name of request.
     */
    private String name;
    /**
     * description of request.
     */
    private String description;
    /**
     * date of request creation.
     */
    private Timestamp create;
    /**
     * id of request.
     */
    private Integer id;
    //public DBItem() {}

    /**
     * Constructor.
     * @param name - name of request
     * @param description - description of request
     * @param create - date of request creation
     * @param id - id
     */
    public DBItem(Integer id, String name, String description, Timestamp create) {
        this.name = name;
        this.description = description;
        this.create = create;
        this.id = id;
    }
    /**
     * Constructor.
     * @param name - name of request
     * @param description - description of request
     * @param create - date of request creation
     */
    public DBItem(String name, String description, Timestamp create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    /**
     * Method returns name of request.
     * @return name of request
     */
    public String getName() {
        return this.name;
    }
    /**
     * Method returns description of request.
     * @return description of request
     */
    public String getDescription() {
        return this.description;
    }
    /**
     * Method returns date of request creation.
     * @return date of request creation
     */
    public Timestamp getCreate() {
        return this.create;
    }
    /**
     * Method returns id of request.
     * @return id of request
     */
    public Integer getId() {
        return this.id;
    }

}


