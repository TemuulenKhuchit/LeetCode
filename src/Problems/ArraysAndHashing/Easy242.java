package Problems.ArraysAndHashing;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Easy242 {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }

    // Easy 242. Valid Anagram
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = s.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toMap(c -> c, c -> 1, Integer::sum));

        Map<Character, Integer> tMap = t.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toMap(ch -> ch, ch -> 1, Integer::sum));

        for (Map.Entry<Character, Integer> sEntry : sMap.entrySet()) {
            if (!tMap.containsKey(sEntry.getKey()) || !Objects.equals(sEntry.getValue(), tMap.getOrDefault(sEntry.getKey(), 0))) {
                return false;
            }
        }

        for (Map.Entry<Character, Integer> sEntry : sMap.entrySet()) {
            if (!tMap.containsKey(sEntry.getKey()) || !Objects.equals(sEntry.getValue(), tMap.getOrDefault(sEntry.getKey(), 0))) {
                return false;
            }
        }

        return true;
    }

}
