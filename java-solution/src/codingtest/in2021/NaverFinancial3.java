package codingtest.in2021;

import java.util.HashSet;
import java.util.Set;

class Permutation {
    private final Set<String> set = new HashSet<>();

    void permute(String str, int l, int r) {
        if (l == r) {
            if (isValid(str)) set.add(str);
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public int sizeofSet() {
        return set.size();
    }

    private boolean isValid(String str) {
        String hourStr = str.substring(0, 2);
        String minuteStr = str.substring(2);
        int hour = Integer.parseInt(hourStr);
        int minute = Integer.parseInt(minuteStr);
        return (hour >= 0 && hour < 24) && (minute >= 0 && minute < 60);
    }

    private String swap(String a, int i, int j) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

class SolutionNaverFinancial3 {
    public int solution(int A, int B, int C, int D) {
        Permutation permutation = new Permutation();
        StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(A));
        sb.append(Integer.toString(B));
        sb.append(Integer.toString(C));
        sb.append(Integer.toString(D));

        permutation.permute(sb.toString(), 0, sb.length() - 1);
        return permutation.sizeofSet();
    }
}

public class NaverFinancial3 {
    public static void main(String[] args) {
        SolutionNaverFinancial3 sol = new SolutionNaverFinancial3();
        System.out.println(sol.solution(1, 8, 3, 2));
        System.out.println(sol.solution(2, 3, 3, 2));
        System.out.println(sol.solution(6, 2, 4, 7));
    }
}
