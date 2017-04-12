package ru.job4j.start;

/**
 * class for valid data.
 */
public class ValidateInput extends ConsoleInput {
    /**
     * Method input data.
     * @param str str
     * @param range - array of valid actions
     * @return input data
     */
    public int ask(String str, int[] range) {
        boolean b = true;
        int value = -1;
        do {
            try {
                value = super.ask(str, range);
                b = false;
            } catch (NumberFormatException nfe) {
                System.out.println("you entered incorrect value! try again");
            } catch (MenuOutOfBoundsAxception noe) {
                System.out.println("you are out of bounds! try again");
            }
        } while (b);
        return value;
    }
}
