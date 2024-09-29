package Problems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MediumProblem179 {
    public String largestNumber(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().toList();

        List<String> strList = list.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());

        strList.sort((a, b) -> (b + a).compareTo(a + b));

        if (strList.get(0).equals("0")) {
            return "0";
        }

        return String.join("", strList);
    }

    public static void main(String[] args) {
        var a = new MediumProblem179();
        int[] nums = {0, 0};
        System.out.println(a.largestNumber(nums));
    }
}
