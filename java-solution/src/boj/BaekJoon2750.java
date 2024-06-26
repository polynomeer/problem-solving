package boj;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BaekJoon2750 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }

        set.forEach(System.out::println);
    }
}
