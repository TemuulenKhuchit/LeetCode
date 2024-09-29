package Problems;

import java.util.ArrayList;
import java.util.List;

public class MediumProblem241NotSolved {
    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
//        List<String> strList = new ArrayList<>();
//        strList = Arrays.asList(expression.split("-"))
//        System.out.println(strList);


        return list;
    }

    public static void main(String[] args) {
//        String expression1 = "2-1-1";
        String expression2 = "2*3-4*5";

        List<Integer> nums = List.of(2, 3, 4, 5);
        List<Character> signs = List.of('*', '-', '*');

        StringBuilder result = new StringBuilder();

//        System.out.println(diffWaysToCompute(expression1));
//        System.out.println(diffWaysToCompute(expression2));

        int count = 0;
        for (int i = 0; i < nums.size(); i++) {
            count = nums.size() - i - 1;
            for (int j = 0; j < nums.size() - 1; j++) {
                while (count > 0) {
                    result.append('(');
                    count--;
                }
                result.append(nums.get(j));
                result.append(signs.get(j));
            }
            result.append(nums.get(nums.size() - 1));
            System.out.println(result);
            result.setLength(0);
        }
//        System.out.println(result);
    }
}
