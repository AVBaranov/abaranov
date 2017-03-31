package ru.job4j;

/**
 * class for healing people.
 */
public class Doctor extends Profession {
    /**
     * method heal people.
     * @param pacient pacient
     * @return docotr and pacient names
     */
    public String heal(String pacient) {
        return "Доктор " + getName() + " лечит пациента " + pacient;
    }
}
