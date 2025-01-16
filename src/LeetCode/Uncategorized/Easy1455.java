package LeetCode.Uncategorized;

public class Easy1455 {

    public static void main(String[] args) {
        isPrefixOfWord("i love eating burger", "burg");
    }

    // Easy 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++)
            if (words[i].startsWith(searchWord))
                return i + 1;
        return -1;
    }

}
