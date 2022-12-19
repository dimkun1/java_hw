package sem3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.sound.midi.Soundbank;

public class test2 {
    public static void main(String[] args) {
        String [] planets = {"qwe", "qwe", "asd", "qwe", "zxc"};
        Random rnd = new Random();
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            result.add(planets[rnd.nextInt(0,planets.length)]);

            
        }
        System.out.println(result);


        Set<String> mySet = new HashSet<String>(result);
        for (String s : mySet) {
            System.out.println(s + ' ' + Collections.frequency(result, s));

            
        }
    }
}
