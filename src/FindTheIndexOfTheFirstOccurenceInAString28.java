public class FindTheIndexOfTheFirstOccurenceInAString28 {
    public static int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) {
            return -1;
        }
        return haystack.indexOf(needle);
    }
}
