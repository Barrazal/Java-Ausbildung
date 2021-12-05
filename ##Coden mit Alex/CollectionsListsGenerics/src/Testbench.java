import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Testbench {
    public static void main(String[] args) {
        List<String> myList = new DoubleLinkedList<>();

        myList.add("First");
        myList.add("Second");
        myList.add("Third");
        myList.add("Fourth");

        myList.remove(1);

        System.out.println("Output myList: " + myList);
        System.out.println("Size myList: " + myList.size());

        Iterator myIterator = myList.iterator();

        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }


        List<String> myList2 = new ArrayList<>();

        myList2.add("First");
        myList2.add("Second");
        myList2.add("Third");
        myList2.add("Fourth");

        myList2.remove(1);

        System.out.println("Output myList2: " + myList2);
        System.out.println("Size myList2: " + myList2.size());

        myIterator = myList2.iterator();

        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
    }
}
