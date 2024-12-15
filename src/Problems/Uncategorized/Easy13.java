package Problems.Uncategorized;

public class Easy13 {
    public int romanToInt(String s) {
        int answer = 0, value;

        for (int i = 0; i < s.length(); i++) {
            char currLetter = s.charAt(i);
            int currNumber = letterToNumber(currLetter);

            if (i + 1 < s.length()) {
                char nextLetter = s.charAt(i + 1);
                int nextNumber = letterToNumber(nextLetter);

                if (nextNumber > currNumber) {
                    value = currNumber * -1;
                } else {
                    value = currNumber;
                }
            } else {
                value = currNumber;
            }
            answer += value;
        }

        return answer;
    }

    public int letterToNumber(char letter) {
        return switch (letter) {
            case 'M' -> 1000;
            case 'D' -> 500;
            case 'C' -> 100;
            case 'L' -> 50;
            case 'X' -> 10;
            case 'V' -> 5;
            case 'I' -> 1;
            default -> 0;
        };
    }
}
