package LeetCode.BinarySearch;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Medium981 {

    // Medium 981. Time Based Key-Value Store
    private Map<String, TreeMap<Integer, String>> keyTimeMap;

    public Medium981() {
        keyTimeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!keyTimeMap.containsKey(key))
            keyTimeMap.put(key, new TreeMap<>());
        keyTimeMap.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!keyTimeMap.containsKey(key))
            return "";

        Integer floorKey = keyTimeMap.get(key).floorKey(timestamp);
        if (floorKey != null)
            return keyTimeMap.get(key).get(floorKey);

        return "";
    }
}
