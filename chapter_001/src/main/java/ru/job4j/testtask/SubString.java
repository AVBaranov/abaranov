package ru.job4j.testtask;
/**
* @author Andrey Baranov
* @version $Id$
* @since 0.1
*/
public class SubString {

/**
* method returns true if string origin contains string sub.
*@param origin - origin string
*@param sub - sub string
*@return true if string origin contains string sub
*/

public boolean contains(String origin, String sub) {
        char[] ar1 = origin.toCharArray();
        char[] ar2 = sub.toCharArray();
        boolean f = false;
        for (int i = 0; i < ar1.length; i++) {

            if (ar1[i] == ar2[0]) {
                f = true;
                for (int j = 1; j < ar2.length && f; j++) {
                    f = ar1[i + j] == ar2[j];
                }
                if (f) {
			break;
		}
            }
        }
        return f;
    }
}