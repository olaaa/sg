package Procedure.loop._3_bubble_sort_inverted_____;

import java.util.Arrays;

public class Test_4 {
    public static void main(String[] args) {
        // fill elements
        int[] array = new int[] {3, 1, 2, 4};
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
