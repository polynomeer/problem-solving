package prgms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution_42746 {
    List<String> list = new ArrayList<>();

    class Permutation {
        public void permute(String[] str, int l, int r) {
            if (l == r) {
                list.add(combine(str));
            } else {
                for (int i = l; i <= r; i++) {
                    str = swap(str, l, i);
                    permute(str, l + 1, r);
                    str = swap(str, l, i);
                }
            }
        }

        private String combine(String[] str){
            StringBuilder sb = new StringBuilder();
            for (String s : str) {
                sb.append(s);
            }
            return sb.toString();
        }

        public String[] swap(String[] s, int i, int j) {
            String temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            return s;
        }
    }

    public String solution(int[] numbers) {
        Permutation permutation = new Permutation();
        String[] numberStrings = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numberStrings[i] = Integer.toString(numbers[i]);
        }

        permutation.permute(numberStrings, 0, numbers.length - 1);
        Collections.sort(list);

        return list.get(list.size()-1).toString();
    }
}

public class prgms_42746 {
    public static void main(String[] args) {
        Solution_42746 sol = new Solution_42746();
        System.out.println(sol.solution(new int[]{6, 10, 2}));
        System.out.println(sol.solution(new int[]{3, 30, 34, 5, 9}));
    }
}
