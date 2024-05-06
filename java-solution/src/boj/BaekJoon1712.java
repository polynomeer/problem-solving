package boj;

import java.util.Scanner;

public class BaekJoon1712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextInt();
        long b = sc.nextInt();
        long c = sc.nextInt();

        long revenue = 0;
        long cost = 0;
        long i = 1;

        if (b > c) { // '가변비용 > 판매가격' 인 경우 절대로 손익분기점이 존재할 수 없음
            System.out.println(-1);
            return;
        }

        while (true) {
            cost = a + b * i;
            revenue = c * i;
            if (revenue > cost) break;
            i++;
        }
        System.out.println(i);
    }
}
