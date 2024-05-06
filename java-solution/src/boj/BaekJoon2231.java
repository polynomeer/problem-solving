package boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon2231 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int answer = 0;
        List<Integer> decompositions = new ArrayList<>();

        for (int i = n; i >= 0; i--) {
            if (getDecomposition(i) == n) {
                decompositions.add(i);
            }
        }

        if (!decompositions.isEmpty()) {
            answer = decompositions.get(decompositions.size() - 1);
        }

        System.out.println(answer);
    }

    private static int getDecomposition(int m) {
        int sum = m;
        while (m > 0) {
            sum += m % 10;
            m /= 10;
        }
        return sum;
    }
}
