package prgms;

import java.util.HashSet;
import java.util.Set;

class Permutation {
    public Set<String> permutations = new HashSet<>();

    public void permute(String str, int l, int r) {
        if (l == r && !permutations.contains(str)) {
            permutations.add(str);
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
        permutation.permute(numbers, 0, numbers.length() - 1);

        Set<Character> set = new HashSet<>();
        for (char c : numbers.toCharArray()) {
            set.add(c);
        }
        for (char c : set) {
            if (isPrime(Integer.parseInt(String.valueOf(c)))) answer++;
        }
        for (String s : permutation.permutations) {
            if (isPrime(Integer.parseInt(s))) answer++;
        }
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
        System.out.println(sol.solution("011") == 2);
        System.out.println(sol.solution("1231") == 18);
        System.out.println(sol.solution("1234") == 14);
        System.out.println(sol.solution("7843")==12);
    }
}
