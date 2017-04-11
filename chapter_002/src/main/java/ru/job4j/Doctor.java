package ru.job4j;

/**
 * class for healing people.
 */
public class Doctor extends Profession {
    /**
     * constructor.
     * @param name set human's name.
     * @param age set human's age.
     */
    public Doctor(String name, int age) {
        super(name, age);
    }
    /**
     * method heal people.
     * @param pacient pacient
     * @return docotr and pacient names
     */
    public String heal(Pacient pacient) {
        return "Доктор " + getName() + " лечит пациента " + pacient.getName();
    }
}
