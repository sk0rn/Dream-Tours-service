package utils;

public class ArrayFill {

    private ArrayFill() {}

    public static String[] fillSameString(int size, String data) {
        String[] array = new String[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = data;
        }
        return array;
    }
}
