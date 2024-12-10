package cses.introductoryProblems;

import java.util.Scanner;

public class WeirdAlgorithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = Integer.parseInt(sc.nextLine());
        while (num > 1) {
            System.out.print(num + " ");
            if (num % 2 == 1)
                num = num * 3 + 1;
            else num /= 2;
        }
        System.out.print(num);
    }
}
