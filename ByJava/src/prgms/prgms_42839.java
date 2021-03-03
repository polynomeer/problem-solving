package prgms;

import java.util.Set;
import java.util.TreeSet;

class Permutation {
    public Set<Integer> permutations = new TreeSet<>();

    public void permute(String str, int l, int r) {
        if (l == r && !permutations.contains(Integer.parseInt(str))) {
            permutations.add(Integer.parseInt(str));
        } else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public String swap(String s, int i, int j) {
        char temp;
        char[] charArray = s.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}

class Solution_42839 {
    public int solution(String numbers) {
        Permutation permutation = new Permutation();
        int answer = 0;
        for (int i = 0; i < numbers.length(); i++) {
            for (int j = i; j <= numbers.length(); j++) {
                String s = numbers.substring(i, j);
                permutation.permute(s, 0, s.length() - 1);
            }
        }

        for (int num : permutation.permutations) {
//            System.out.println(num);
            if (isPrime(num)) answer++;
        }
        System.out.println("answer = " + answer);
        return answer;
    }

    boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) return false;
        }
        System.out.println(num);
        return true;
    }
}

public class prgms_42839 {
    public static void main(String[] args) {
        Solution_42839 sol = new Solution_42839();
        System.out.println(sol.solution("17") == 3);
        sol = new Solution_42839();
        System.out.println(sol.solution("011") == 2);
        sol = new Solution_42839();
        System.out.println(sol.solution("1231") == 18);
        sol = new Solution_42839();
        System.out.println(sol.solution("1234") == 14);
        sol = new Solution_42839();
        System.out.println(sol.solution("7843") == 12);
    }
}
