package design_patterns.strategy;

/**
 * @Auther: qiucy
 * @Date: 2019-06-16 03:15
 * @Description:
 */
public class Sorter {
    public static void sort(TestComparable[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length; j++) {
                minPos = arr[j].comparTo(arr[i]) == -1?j:minPos;
            }
            swap(arr,i,minPos);
        }
    }

    private static void swap(TestComparable[] arr, int i, int minPos) {
        TestComparable temp = arr[i];
        arr[i] = arr[minPos];
        arr[minPos] = temp;
    }
}
