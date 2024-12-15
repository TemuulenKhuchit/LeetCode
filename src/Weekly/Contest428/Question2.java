package Weekly.Contest428;

import java.util.*;

public class Question2 {
    public static void main(String[] args) {
//        List<List<String>> pairs1 = new ArrayList<>();
//        pairs1.add(new ArrayList<>(List.of(new String[]{"EUR", "USD"})));
//        pairs1.add(new ArrayList<>(List.of(new String[]{"USD", "JPY"})));
//        double[] rates1 = new double[]{2.0, 3.0};
//        List<List<String>> pairs2 = new ArrayList<>();
//        pairs2.add(new ArrayList<>(List.of(new String[]{"JPY", "USD"})));
//        pairs2.add(new ArrayList<>(List.of(new String[]{"USD", "CHF"})));
//        pairs2.add(new ArrayList<>(List.of(new String[]{"CHF", "EUR"})));
//        double[] rates2 = new double[]{4.0, 5.0, 6.0};
//        System.out.println(maxAmount("EUR", pairs1, rates1, pairs2, rates2));

        List<List<String>> pairs1 = new ArrayList<>();
        pairs1.add(new ArrayList<>(List.of(new String[]{"EUR", "USD"})));
        pairs1.add(new ArrayList<>(List.of(new String[]{"USD", "JPY"})));
        double[] rates1 = new double[]{2.0, 3.0};
        List<List<String>> pairs2 = new ArrayList<>();
        pairs2.add(new ArrayList<>(List.of(new String[]{"JPY", "USD"})));
        pairs2.add(new ArrayList<>(List.of(new String[]{"USD", "CHF"})));
        pairs2.add(new ArrayList<>(List.of(new String[]{"CHF", "EUR"})));
        double[] rates2 = new double[]{4.0, 5.0, 6.0};
        System.out.println(maxAmount("EUR", pairs1, rates1, pairs2, rates2));
    }

    public static double maxAmount2(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        double result = 0;
        double currProfit = 1;
        String currCurrency = initialCurrency;

        for (int i = 0; i < pairs1.size(); i++) {
            List<String> pair = pairs1.get(i);
            if (pair.get(0).equals(currCurrency)) {
                currProfit *= rates1[i];
                currCurrency = pair.get(1);
            }
            else if (pair.get(1).equals(currCurrency)) {
                currProfit /= rates1[i];
            }
            if (pair.get(0).equals(initialCurrency) || pair.get(1).equals(initialCurrency)) {
                result = currProfit;
            }
            System.out.print(pair + " " + currProfit + " " + currCurrency);
            System.out.println();
        }

        for (int i = 0; i < pairs2.size(); i++) {
            List<String> pair = pairs2.get(i);
            if (pair.get(0).equals(currCurrency)) {
                currProfit *= rates2[i];
                currCurrency = pair.get(1);
            }
            else if (pair.get(1).equals(currCurrency)) {
                currProfit /= rates2[i];
            }
            if (pair.get(0).equals(initialCurrency) || pair.get(1).equals(initialCurrency)) {
                result = currProfit;
            }
            System.out.print(pair + " " + currProfit + " " + currCurrency);
            System.out.println();
        }

        return result > 1 ? result : 1;
    }

    public static double maxAmount(String initialCurrency, List<List<String>> pairs1, double[] rates1, List<List<String>> pairs2, double[] rates2) {
        // Step 1: Build graph for Day 1 and Day 2
        Map<String, Map<String, Double>> graphDay1 = buildGraph(pairs1, rates1);
        Map<String, Map<String, Double>> graphDay2 = buildGraph(pairs2, rates2);

        // Step 2: Perform BFS or DFS to find the maximum conversion on Day 1
        Map<String, Double> day1MaxValues = getMaxConversions(initialCurrency, graphDay1);
        System.out.println(day1MaxValues.values());

        // Step 3: Use Day 1 results as input for Day 2 and find the maximum conversion
        double maxAmount = 0.0;
        for (String currency : day1MaxValues.keySet()) {
            double amountAfterDay1 = day1MaxValues.get(currency);
            Map<String, Double> day2MaxValues = getMaxConversions(currency, graphDay2);

            // Find the maximum conversion after Day 2
            for (double amountAfterDay2 : day2MaxValues.values()) {
                maxAmount = Math.max(maxAmount, amountAfterDay1 * amountAfterDay2);
            }
        }

        return maxAmount;
    }

    private static Map<String, Map<String, Double>> buildGraph(List<List<String>> pairs, double[] rates) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            String from = pairs.get(i).get(0);
            String to = pairs.get(i).get(1);
            double rate = rates[i];

            graph.putIfAbsent(from, new HashMap<>());
            graph.putIfAbsent(to, new HashMap<>());
            graph.get(from).put(to, rate);
            graph.get(to).put(from, 1 / rate);
        }
        return graph;
    }

    private static Map<String, Double> getMaxConversions(String startCurrency, Map<String, Map<String, Double>> graph) {
        Map<String, Double> maxValues = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        maxValues.put(startCurrency, 1.0);
        queue.add(startCurrency);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            double currentAmount = maxValues.get(current);

            for (Map.Entry<String, Double> neighbor : graph.getOrDefault(current, new HashMap<>()).entrySet()) {
                String nextCurrency = neighbor.getKey();
                double conversionRate = neighbor.getValue();
                double newAmount = currentAmount * conversionRate;

                if (newAmount > maxValues.getOrDefault(nextCurrency, 0.0)) {
                    maxValues.put(nextCurrency, newAmount);
                    queue.add(nextCurrency);
                }
            }
        }

        return maxValues;
    }

}
