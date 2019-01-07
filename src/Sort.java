import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int [] unsortedArray = {1,2,3,4,8,7,6,5};
        choiceSort(unsortedArray);
        bubbleSort(unsortedArray);
        insertSort(unsortedArray);
    }
    private static void choiceSort(int[] array){
        int [] arrayToSort = Arrays.copyOf(array, array.length);
        System.out.println("Сортировка выбором");
        long start = System.nanoTime();
        int indexMin;
        for (int index = 0; index < arrayToSort.length-1; index++) {
            indexMin = index;
            for (int indexToScan = index; indexToScan < arrayToSort.length; indexToScan++) {
                if (arrayToSort[indexMin] > arrayToSort[indexToScan]){
                    indexMin = indexToScan;
                }
            }
            int temp = arrayToSort [index];
            arrayToSort[index] = arrayToSort [indexMin];
            arrayToSort[indexMin] = temp;
        }
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(arrayToSort));
    }
    private static void bubbleSort(int[]array){
        int [] arrayToSort = Arrays.copyOf(array, array.length);
        System.out.println("Сортировка пузырьком");
        long start = System.nanoTime();
        int changeCounter;
        do{
            changeCounter = 0;
            for (int index = 0; index < arrayToSort.length-1; index++) {
                if (arrayToSort[index] > arrayToSort[index + 1]){
                    int temp = arrayToSort [index];
                    arrayToSort[index] = arrayToSort [index+1];
                    arrayToSort[index+1] = temp;
                    changeCounter++;
                }
            }
        } while (changeCounter > 0);
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(arrayToSort));
    }
    private static void insertSort(int[]array){
        int [] arrayToSort = Arrays.copyOf(array, array.length);
        System.out.println("Сортировка вставками");
        long start = System.nanoTime();
        int element, indexToInsert;
        for (int index = 0; index < arrayToSort.length; index++) {
            element = arrayToSort [index];
            indexToInsert = index;
            while (indexToInsert > 0 && arrayToSort[indexToInsert - 1] > element){
                arrayToSort [indexToInsert] = arrayToSort [indexToInsert -1];
                indexToInsert--;
                arrayToSort[indexToInsert] = element;
            }
        }
        long stop = System.nanoTime();
        System.out.println(stop - start);
        System.out.println(Arrays.toString(arrayToSort));
    }
}
