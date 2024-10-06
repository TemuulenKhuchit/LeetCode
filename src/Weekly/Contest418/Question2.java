package Weekly.Contest418;

import java.util.*;
import java.util.stream.Collectors;

public class Question2 {

    public static void main(String[] args) {
//        remainingMethods(4, 1, new int[][]{{1, 2}, {0, 1}, {3, 2}});
//        remainingMethods(5, 0, new int[][]{{1, 2}, {0, 2}, {0, 1}, {3, 4}});
        remainingMethods(3, 2, new int[][]{{1, 0}, {2, 0}});
//        remainingMethods(2, 0, null);
//        remainingMethods(3, 0, new int[][]{{0, 1}});
    }

    public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        List<Integer> susIndexes = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> tempList = new HashSet<>();
        Set<Integer> returnList = new HashSet<>();

        tempList = Arrays.stream(invocations)
                .flatMap(innerArray -> Arrays.stream(innerArray).boxed())
                .collect(Collectors.toSet());

        if (tempList.size() < n) {
            for (int i = 0; i < n; i++) {
                if (i != k)
                    tempList.add(i);
            }
        }

        findSusFns(k, invocations, susIndexes, visited);

        for (int[] pair : invocations) {
            if (susIndexes.contains(pair[1]) && !susIndexes.contains(pair[0]))
                susIndexes.remove(susIndexes.indexOf(pair[1]));
        }

        System.out.println(susIndexes);
        System.out.println(returnList);
        System.out.println(tempList);

        returnList = tempList.stream()
                .filter(x -> !susIndexes.contains(x))
                .collect(Collectors.toSet());

        System.out.println(returnList);

        return new ArrayList<>(returnList);
    }

    public static void findSusFns(int k, int[][] invocations, List<Integer> susIndexes, Set<Integer> visited) {
        if (visited.contains(k))
            return;
        visited.add(k);
        susIndexes.add(k);

        for (int[] pair : invocations) {
            if (pair[0] == k)
                findSusFns(pair[1], invocations, susIndexes, visited);
        }
    }

}
