public class Easy3184 {
    public static int countCompleteDayPairs(int[] hours) {
        byte[] counts = new byte[24];
        byte totalPairs = 0;
        for (int time : hours) {
            totalPairs += counts[(byte)(24 - (byte)(time % 24)) % 24];
            counts[(byte)(time % 24)]++;
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