package boj;

import java.util.Scanner;

public class BaekJoon18406 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int temp = n;
        int len = 0;
        while (temp != 0) {
            temp /= 10;
            len++;
        }
        int count = len / 2;
        int divider = 10;
        while (count != 0) {
            count--;
            divider *= 10;
        }
        divider /= 10;

        int left = n / divider;
        int leftSum = 0;
        while (left != 0) {
            leftSum += left % 10;
            left /= 10;
        }

        int right = n % divider;
        int rightSum = 0;
        while (right != 0) {
            rightSum += right % 10;
            right /= 10;
        }

        if (leftSum == rightSum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}
