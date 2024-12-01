package Problems;

public class Easy1346 {
    public static void main(String[] args) {

    }

    // Easy 1346. Check If N and Its Double Exist
    public static boolean checkIfExist(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && arr[i] == 2 * arr[j])
                    return true;
            }
        }
        return false;
    }
}
