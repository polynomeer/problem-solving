package boj;

import java.util.Scanner;

public class BaekJoon2742 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = N; i >= 1; i--) {
            System.out.println(i);
        }

        sc.close();
    }
}
