package IO._1_charset.utf8;

import java.util.Arrays;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Test_UtoC_mix {

    public static void main(String[] args) {
        // PREPARE
        int[] expectedCodePoints = {0, 1, 10, 100, 1_000, 10_000, 100_000, 1_000_000};
        String str = new String(expectedCodePoints, 0, expectedCodePoints.length);
        byte[] utf8 = str.getBytes(UTF_8);

        // CALL
        int[] actualCodepoint = UTF8Converter.convertUTF8toCodepoint(utf8);

        // CHECK
        if (!Arrays.equals(actualCodepoint, expectedCodePoints)) {
            throw new AssertionError("actualCodepoint=" + Arrays.toString(actualCodepoint) + " is not equal expectedCodepoint=" + Arrays.toString(expectedCodePoints));
        }

        System.out.print("OK");
    }
}