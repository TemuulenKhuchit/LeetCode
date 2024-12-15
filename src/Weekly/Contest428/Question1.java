package Weekly.Contest428;

public class Question1 {
    public static void main(String[] args) {
        int[][] events = new int[][]{{1, 2}, {2, 5}, {3, 9}, {1, 15}};
        System.out.println(buttonWithLongestTime(events));
    }

    public static int buttonWithLongestTime(int[][] events) {
        int index = events[0][0];
        int max = events[0][1];
        for (int i = 1; i < events.length; i++) {
            if (events[i][1] - events[i - 1][1] > max) {
                max = events[i][1] - events[i - 1][1];
                index = events[i][0];
            }
            else if (events[i][1] - events[i - 1][1] == max && events[i][0] < index) {
                max = events[i][1] - events[i - 1][1];
                index = events[i][0];
            }
        }
        return index;
    }
}
