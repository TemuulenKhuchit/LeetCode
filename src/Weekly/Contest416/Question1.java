package Weekly.Contest416;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class Question1 {
    public static void main(String[] args) {
        String[] message1 = {"hello", "world", "leetcode"}, bannedWords1 = {"world", "hello"};
        String[] message2 = {"hello", "programming", "fun"}, bannedWords2 = {"world", "programming", "leetcode"};
        String[] message3 = {"s", "a", "aj", "ps", "h", "ou", "e", "i", "x"}, bannedWords3 = {"j", "a", "b", "fa", "z", "a", "no", "ih", "nq"};

        System.out.println(reportSpam(message1, bannedWords1));
        System.out.println(reportSpam(message2, bannedWords2));
        System.out.println(reportSpam(message3, bannedWords3));
    }

//    public static boolean reportSpam(String[] message, String[] bannedWords) {
//        int count = 0;
//        for (String word : message) {
//            for (String ban : bannedWords) {
//                if (word.equals(ban)) {
//                    count++;
//                    if (count == 2)
//                        return true;
//                    break;
//                }
//            }
//        }
//        return false;
//    }

//    public static boolean reportSpam(String[] message, String[] bannedWords) {
//        int count = 0;
//        List<String> newBannedWords = Arrays.asList(bannedWords);
//        for (String word : message) {
//            if (newBannedWords.contains(word)) {
//                count++;
//                if (count == 2)
//                    return true;
//            }
//        }
//        return false;
//    }

//    public static boolean reportSpam(String[] message, String[] bannedWords) {
//        int count = 0;
//        List<String> newMessage = Arrays.asList(message);
//        for (String ban : bannedWords) {
//            if (newMessage.contains(ban)) {
//                count++;
//                if (count == 2)
//                    return true;
//
//            }
//        }
//        return false;
//    }

    public static boolean reportSpam(String[] message, String[] bannedWords) {
        int count = 0;
        Set<String> newBannedWords = new HashSet<>(Arrays.asList(bannedWords));
        for (String word : message) {
            if (newBannedWords.contains(word)) {
                count++;
                if (count == 2)
                    return true;
            }
        }
        return false;
    }
}
