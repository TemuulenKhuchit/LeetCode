package LeetCode.ArraysAndHashing;

public class Easy706 {
    private static Integer[] keys = new Integer[(int) (1e6 + 1)];

    public static void main(String[] args) {
        put(1, 1); // The map is now [[1,1]]
        put(2, 2); // The map is now [[1,1], [2,2]]
        get(1);    // return 1, The map is now [[1,1], [2,2]]
        get(3);    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        get(2);    // return 1, The map is now [[1,1], [2,1]]
        remove(2); // remove the mapping for 2, The map is now [[1,1]]
        get(2);
    }

    // Easy 706. Design HashMap
    public static void put(int key, int value) {
        keys[key] = value;
    }

    public static int get(int key) {
        return (keys[key] != null) ? keys[key] : -1;
    }

    public static void remove(int key) {
        keys[key] = null;
    }

}
