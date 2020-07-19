public class ArraysSort {
    //冒泡排序
    public static void bubbleSort(int[] arr) {
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

    //快速排序
    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] array, int begin, int end) {
        // pivot: 标杆位置，counter:将要存放小于pivot的元素位置
        int pivot = end, counter = begin;
        for (int i = begin; i < end; i++) {
            if (array[i] < array[pivot]) {
                int temp = array[counter]; array[counter] = array[i]; array[i] = temp;
                counter++;
            }
        }
        int temp = array[pivot]; array[pivot] = array[counter]; array[counter] = temp;
        return counter;
    }

    //归并排序
    public static void mergeSort(int[] array, int left, int right) {
        if (right <= left) return;
        int mid = (left + right) >> 1;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];  //中间数组
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= mid) temp[k++] = arr[i++];
        while (j <= right) temp[k++] = arr[j++];

        for (int l = 0; l < temp.length; l++) {
            arr[left + l] = temp[l];
        }

    }

    public static void main(String[] args) {
        int[] ints = {8, 34, 3, 6, 65, 34, 65, 66, 54};
        ArraysSort.mergeSort(ints, 0, ints.length - 1);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
