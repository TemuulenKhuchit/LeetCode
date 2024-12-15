package Problems.Uncategorized;

public class Easy3184 {
    public static int countCompleteDayPairs(int[] hours) {
        int[] counts = new int[24];
        int totalPairs = 0;
        for (int time : hours) {
            totalPairs += counts[(24 - (time % 24)) % 24];
            counts[time % 24]++;
        }
        return totalPairs;
    }

    public static void main(String[] args) {
        int[] hours1 = {12, 12, 30, 24, 24};
        System.out.println(countCompleteDayPairs(hours1));

        int[] hours2 = {72, 48, 24, 3};
        System.out.println(countCompleteDayPairs(hours2));
    }
}