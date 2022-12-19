package sem3;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.text.html.FormView;

public class test1 {
    
    public static void main(String[] args) {
        Random rnd = new Random();
    // ArrayList<Integer> intArray = new ArrayList<>(Arrays.asList(4,6,3,6,7,2,1,5,7,72));
        ArrayList<Integer> intArray = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            intArray.add(rnd.nextInt(100));
        
        }
        printArray(intArray);
        Collections.sort(intArray);
        printArray(intArray);
    // }
    }

    public static void printArray(ArrayList<Integer> array) {
        StringBuilder printSB = new StringBuilder();
        for (Integer number : array) {
            printSB.append(number + ", ");
        }
        String output = printSB.substring(0, printSB.length() - 2);
        System.out.println(output);

    }
}

