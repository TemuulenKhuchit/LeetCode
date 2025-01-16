package LeetCode.ArraysAndHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Easy242 {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    // Easy 242. Valid Anagram
    public static boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (char c : s.toCharArray())
            arr[c - 'a']++;
        for (char c : t.toCharArray())
            arr[c - 'a']--;
        for (int num : arr)
            if (num != 0)
                return false;
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        for (char c : s.toCharArray())
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        for (char c : t.toCharArray()) {
            if (!sMap.containsKey(c))
                return false;
            if (sMap.get(c) == 1)
                sMap.remove(c);
            else
                sMap.put(c, sMap.get(c) - 1);
        }
        return sMap.isEmpty();
    }

    public static boolean isAnagram3(String s, String t) {
        Map<Character, Integer> sMap = s.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toMap(ch -> ch, ch -> 1, Integer::sum));

        Map<Character, Integer> tMap = t.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toMap(ch -> ch, ch -> 1, Integer::sum));

        for (Map.Entry<Character, Integer> sEntry : sMap.entrySet()) {
            if (!tMap.containsKey(sEntry.getKey()) || !Objects.equals(sEntry.getValue(), tMap.getOrDefault(sEntry.getKey(), 0))) {
                return false;
            }
        }

        for (Map.Entry<Character, Integer> tEntry : tMap.entrySet()) {
            if (!sMap.containsKey(tEntry.getKey()) || !Objects.equals(tEntry.getValue(), sMap.getOrDefault(tEntry.getKey(), 0))) {
                return false;
            }
        }

        return true;
    }

}
