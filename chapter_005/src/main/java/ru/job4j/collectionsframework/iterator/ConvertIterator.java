package ru.job4j.collectionsframework.iterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Andrey on 13.05.2017.
 */
/*public class ConvertIterator {
    public Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        List<Integer> list = new ArrayList<>();
        while (it.hasNext()) {
            Iterator<Integer> iter= it.next();
            myiter myit = new myiter(list);
            while (iter.hasNext()) {
                list.add(iter.next());
            }
            //while (myit.hasNext()) {
            //   list.add(myit.next());
            //}

        }
        return list.iterator();
    }
}*/


/**
 * Created by Andrey on 13.05.2017.
 */
public class ConvertIterator {
    public Iterator<Integer> convert(myiterofiters it) {
        List<Integer> list = new ArrayList<>();
        while (it.hasNext()) {
            myiter<Integer> iter = new myiter<>(it.next());
            //Iterator<Integer> iter= it.next();
            while (iter.hasNext()) {
                list.add(iter.next());
            }
        }
        return list.iterator();
    }
}


