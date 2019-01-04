import java.util.Arrays;

public class JavaAlgorithms {
    public static int [] array = {10,5,7,3,15};
    public static void main(String[] args) {
        System.out.println(divide(17,4));
        int [] array = {10,5,7,3,15};
        bubbleSort(array);
        quickSort();
        System.out.println(Arrays.toString(array));

    }
    public static int divide (int a, int b){
        if (b == 0) return a;
        int c = a%b;
        return divide (b,c);
    }
    public static void bubbleSort (int[] arr){
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr [j] > arr[j+1]){
                    int t = arr [j];
                    arr[j] = arr [j+1];
                    arr [j+1] = t;
                }

            }

        }
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort () {
        int start = 0;
        int end = array.length - 1;
    }
    private static void doSort (int start, int end){
        if (start >= end) return;
        int i = start, j = end;
        int cur = i - (i-j)/2;
        while (i<j){
            while(i<cur&&(array[i]<=array[cur])){
                i++;
            }
            while(j>cur&&(array[cur]<=array[j])){
                j--;
            }
            if (i<j){
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if(i == cur)
                    cur = j;
                else if (j==cur) cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur+1, end);
    }
}
