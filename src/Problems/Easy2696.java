package Problems;

public class Easy2696 {

    public static void main(String[] args) {
        minLength("ABFCACDB");
        minLength("ACBBD");
    }

    public static int minLength(String s) {
//        return substrStr(s).length();

        while (s.contains("AB") || s.contains("CD")) {
            s = s.replaceFirst("AB", "");
            s = s.replaceFirst("CD", "");
        }

        System.out.println(s);

        return s.length();
    }

//    public static String substrStr(String s) {
//        if (s.contains("AB")) {
//            s = s.replaceFirst("AB", "");
//            return substrStr(s);
//        } else if (s.contains("CD")) {
//            s = s.replaceFirst("CD", "");
//            return substrStr(s);
//        }
//        return s;
//    }

}
