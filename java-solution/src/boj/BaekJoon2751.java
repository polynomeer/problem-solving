package boj;

import java.util.*;

public class BaekJoon2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        list.forEach(x -> sb.append(x).append('\n'));
        System.out.println(sb);
    }
}
