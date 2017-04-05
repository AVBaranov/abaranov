package ru.job4j.models;

/**
 * class Item.
 */
public class Item {
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
    private long create;
    /**
     * id of request.
     */
    private String id;
    //public Item() {}
    /**
     * Constructor.
     * @param name - name of request
     * @param description - description of request
     * @param create - date of request creation
     */
    public Item(String name, String description, long create) {
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
    public long getCreate() {
        return this.create;
    }
    /**
     * Method returns id of request.
     * @return id of request
     */
    public String getId() {
        return this.id;
    }
    /**
     * Method sets id of request.
     * @param id - id of request
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Method sets name of request.
     * @param name - name of request
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Method sets description of request.
     * @param description - description of request
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * Method sets date of request creation.
     * @param create - date of request creation
     */
    public void setCreate(long create) {
        this.create = create;
    }

}


