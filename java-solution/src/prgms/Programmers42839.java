package prgms;

import java.util.*;

class Permutation {
    public Set<Integer> set = new TreeSet<>();

    public void permute(String str, int l, int r) {
        if (str.equals("")) return;
        if (l == r && !set.contains(Integer.parseInt(str))) {
            set.add(Integer.parseInt(str));
            System.out.println(str);
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

class Solution42839 {
    public int solution(String numbers) {
        Permutation permutation = new Permutation();
        for (int i = 0; i < numbers.length(); i++) {
            for (int j = i; j < numbers.length(); j++) {
                String prefix = numbers.substring(i, j);
                String postfix = numbers.substring(j);
                permutation.permute(prefix, 0, prefix.length() - 1);
                permutation.permute(postfix, 0, postfix.length() - 1);
            }

        }

        int count = 0;
        for (int num : permutation.set) {
            if (isPrime(num)) {
//                System.out.println(num);
                count++;
            }
        }
        System.out.println("count : " + count);
        return count;
    }

    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

public class Programmers42839 {
    public static void main(String[] args) {
        Solution42839 sol = new Solution42839();
        System.out.println(sol.solution("17") == 3);
        sol = new Solution42839();
        System.out.println(sol.solution("011") == 2);
        sol = new Solution42839();
        System.out.println(sol.solution("1231") == 18);
        sol = new Solution42839();
        System.out.println(sol.solution("1234") == 14);
        sol = new Solution42839();
        System.out.println(sol.solution("7843") == 12);
    }
}
