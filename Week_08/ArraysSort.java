public class ArraysSort {
    public void bubbleSort(int[] arr) {
        int len = arr.length - 1;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        ArraysSort arraysSort = new ArraysSort();
        int[] ints = {8, 34, 3, 6, 65, 34, 65, 66, 54};
        arraysSort.bubbleSort(ints);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
