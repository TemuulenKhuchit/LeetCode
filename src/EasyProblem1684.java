public class EasyProblem1684 {
    public static void main(String[] args) {
        String allowed = "abc";
        String[] words = {"a","b","c","ab","ac","bc","abc"};

        boolean isConsistent;
        int result = 0;
        for (String word : words) {
            isConsistent = true;
            for (int i = 0; i < word.length(); i++) {
                if (!allowed.contains(String.valueOf(word.charAt(i)))) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent){
                result++;
            }
        }
        System.out.println(result);
    }
}
