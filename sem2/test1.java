import java.lang.annotation.Retention;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        String w = "ewgfqqw";
        print(polindrom(w));
    }

    public static String polindrom(String word) {
        String str = word;
        String[] array = str.split("");
        for (int i = 0; i < array.length/ 2 ; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length-i - 1] = temp;

            
        }
        str = String.join("", array);
        return str;
    }
    public static void print(String str){
        System.out.println(str);
    }
    
    
}
