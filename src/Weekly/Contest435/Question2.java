package Weekly.Contest435;

public class Question2 {

    public static void main(String[] args) {
        System.out.println(maxDistance("NNE", 1));
        System.out.println(maxDistance("NEWS", 1));
        System.out.println(maxDistance("NSWWEW", 3));
    }

    public static int maxDistance(String s, int k) {
        int n = s.length();
        int countN = 0, countS = 0, countE = 0, countW = 0;
        int maxDist = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'N') countN++;
            else if (c == 'S') countS++;
            else if (c == 'E') countE++;
            else if (c == 'W') countW++;
            
            int x = countE - countW;
            int y = countN - countS;
            int baseDist = Math.abs(x) + Math.abs(y);

            int possibleX = (x >= 0) ? countW : countE;
            int possibleY = (y >= 0) ? countS : countN;
            int totalPossible = possibleX + possibleY;
            int changeUsed = Math.min(k, totalPossible);
            int changedDist = baseDist + 2 * changeUsed;

            maxDist = Math.max(maxDist, changedDist);
        }

        return maxDist;
    }
}
