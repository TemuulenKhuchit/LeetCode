package Problems.Algorithms;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {10, 7, 1, 8, 2, 6, 4, 3, 9, 8};
        quickSort(array, 0, array.length - 1);

        // Print sorted array
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find pivot index
            int pivotIndex = partition(arr, low, high);
            // Recursively sort elements before and after partition
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        // Median of three pivot selection
        int mid = low + (high - low) / 2;
        int pivot = medianOfThree(arr, low, mid, high);

        // Swap pivot with the last element
        swap(arr, mid, high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        // Place pivot in its correct position
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static int medianOfThree(int[] arr, int low, int mid, int high) {
        if ((arr[low] > arr[mid]) != (arr[low] > arr[high])) {
            return arr[low];
        } else if ((arr[mid] > arr[low]) != (arr[mid] > arr[high])) {
            return arr[mid];
        } else {
            return arr[high];
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
