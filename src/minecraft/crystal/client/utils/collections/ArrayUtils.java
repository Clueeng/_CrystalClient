package crystal.client.utils.collections;

import java.lang.reflect.Array;

public class ArrayUtils {

    public static <T> T[] reverse(T[] array) {
        int left = 0;
        int right = array.length - 1;

        T[] newArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);

        while (left < right) {
            T temp = array[left];
            newArray[left] = array[right];
            newArray[right] = temp;

            left++;
            right--;
        }

        return newArray;
    }
}
