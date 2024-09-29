package Weekly.Contest417;

public class Question1 {
    public static char kthCharacter(int k) {
        int totalLength = 1;
        while (totalLength < k) {
            totalLength *= 2;
        }

        return getSpell(totalLength, k);
    }

    public static char getSpell(int len, int k) {
        if (len == 1)
            return 'a';
        int mid = len / 2;
        if (k <= mid)
            return getSpell(mid, k);
        char c = getSpell(mid, k - mid);
        if (c == 'z')
            return 'a';
        return (char) (c + 1);
    }

    public static void main(String[] args) {
        System.out.println(kthCharacter(5)); //b
        System.out.println(kthCharacter(10)); //c
    }
}
