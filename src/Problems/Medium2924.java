package Problems;

public class Medium2924 {

    public static void main(String[] args) {
        Medium2924 obj = new Medium2924();
        int[][] edges = {{0, 1}, {1, 2}};
        obj.findChampion(3, edges);
    }

    // Medium 2924. Find Champion II
    public int findChampion(int n, int[][] edges) {
        int result = -1;
        int counter = 0;
        boolean needBreak = false;

        for (int i = 0; i < n; i++) {
            for (int[] edge : edges) {
                if (edge[1] == i) {
                    needBreak = true;
                    break;
                }
            }
            counter++;
            if (needBreak)
                break;
        }

        return result;
    }
}
