package Weekly.Contest419;

import java.util.*;

public class Question1 {

    public static void main(String[] args) {
        findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2);
    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        List<Integer> resultArr = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            int[] freq = new int[51];

            for (int j = i; j < i + k; j++) {
                freq[nums[j]]++;
            }

            List<Element> elementList = new ArrayList<>();
            for (int val = 1; val <= 50; val++) {
                if (freq[val] > 0) {
                    elementList.add(new Element(val, freq[val]));
                }
            }

            elementList.sort((e1, e2) -> {
                if (e1.freq != e2.freq) {
                    return e2.freq - e1.freq;
                } else {
                    return e2.value - e1.value;
                }
            });

            int sum = 0;
            int needed = Math.min(x, elementList.size());
            for (int idx = 0; idx < needed; idx++) {
                Element elem = elementList.get(idx);
                sum += elem.value * elem.freq;
            }

            resultArr.add(sum);
        }

        int[] answer = new int[resultArr.size()];
        for (int idx = 0; idx < resultArr.size(); idx++) {
            answer[idx] = resultArr.get(idx);
        }

        return answer;
    }

    static class Element {
        int value;
        int freq;

        Element(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }
    }

}
