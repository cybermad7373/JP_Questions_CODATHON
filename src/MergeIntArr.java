import java.util.ArrayList;

public class MergeIntArr {
    public static void main(String[] args) {
        int[][] multi_arr = { { 2, 6, 12, 34 }, { 1, 9, 20, 1000 }, { 23, 34, 90, 2000 } };

        int[] onD = new int[multi_arr.length* multi_arr[0].length];
        int pos= 0;
        for(int[] i :multi_arr)
        {
            for(int j : i)
            {
                onD[pos] = j;
                pos++;
            }
        }
        System.out.println("After Sorting : "+bubbleSort(onD));
    }
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }
}
