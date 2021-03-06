package Procedure.loop._3_bubble_sort_inverted_____;

import java.util.Arrays;
import java.util.Random;

public class Test_10 {
    public static void main(String[] args) {
        // fill random elements
        Random rnd = new Random(0);
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = rnd.nextInt(1000);
        }
        // library sort
        int[] expected = array.clone();
        Arrays.sort(expected);
        // lab sort
        int[] actual = array.clone();
        BubbleSorter.sort(actual);
        // compare results: library vs lab
        if (!Arrays.equals(actual, expected)) {
            throw new AssertionError("expected = " + Arrays.toString(expected) + " but actual  = " + Arrays.toString(actual));
        }

        System.out.print("OK");
    }
}
