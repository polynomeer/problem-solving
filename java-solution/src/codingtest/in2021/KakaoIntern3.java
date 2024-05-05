package codingtest.in2021;

import java.util.*;

/*class KakaoIntern3Solution {
    public String solution(int n, int k, String[] cmds) {
        String answer;
        StringBuilder sb = new StringBuilder();
        sb.append("O".repeat(n));
        answer = sb.toString();

        int pos = k;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        Stack<Integer> removed = new Stack<>();
        Stack<Integer> removedIdx = new Stack<>();
        for (String cmd : cmds) {
            if (cmd.charAt(0) == 'U') {
                int num = Character.getNumericValue(cmd.charAt(2));
                pos = pos - num;
            } else if (cmd.charAt(0) == 'D') {
                int num = Character.getNumericValue(cmd.charAt(2));
                pos = pos + num;
            } else if (cmd.charAt(0) == 'C') {
                int temp = pos;
                pos = pos == list.size() - 1 ? pos - 1 : pos;
                pos = pos < 0 ? pos + 1 : pos;
                removed.push(list.remove(temp));
                removedIdx.push(temp);
            } else if (cmd.charAt(0) == 'Z') {
                int idx = removedIdx.pop();
                int element = removed.pop();
                pos = idx < pos ? pos + 1 : pos;
                list.add(idx, element);
            }
//            System.out.println(cmd + ", pos : " + pos);
//            System.out.println(Collections.unmodifiableList(list));
        }

        char[] chars = answer.toCharArray();
        while (!removed.isEmpty()) {
            int idx = removed.pop();
            chars[idx] = 'X';
        }
        answer = String.valueOf(chars);
        return answer;
    }
}*/

class KakaoIntern3Solution {
    public String solution(int n, int k, String[] cmds) {
        String answer;
        StringBuilder sb = new StringBuilder();

        int pos = k;
        Stack<Integer> removed = new Stack<>();
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i,i);
        }

        for (String cmd : cmds) {
            if (cmd.charAt(0) == 'U') {
                int num = Character.getNumericValue(cmd.charAt(2));
                pos = pos - num;
            } else if (cmd.charAt(0) == 'D') {
                int num = Character.getNumericValue(cmd.charAt(2));
                pos = pos + num;
            } else if (cmd.charAt(0) == 'C') {
                removed.push(map.get(pos));
                pos = pos == n - 1 ? pos - 1 : pos + 1;

            } else if (cmd.charAt(0) == 'Z') {
                removed.pop();
            }
//            System.out.println(cmd + ", pos : " + pos);
        }

        if (removed.size() == n){
            sb.append("X".repeat(n));
            return sb.toString();
        }

        sb.append("O".repeat(n));
        answer = sb.toString();
        char[] chars = answer.toCharArray();

        while (!removed.isEmpty()) {
            int idx = removed.pop();
            chars[idx] = 'X';
        }

        answer = String.valueOf(chars);
        return answer;
    }
}

public class KakaoIntern3 {
    public static void main(String[] args) {
        KakaoIntern3Solution sol = new KakaoIntern3Solution();
        System.out.println(sol.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        System.out.println(sol.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
        System.out.println(sol.solution(8, 2, new String[]{"C", "C", "C", "C", "C", "C", "C", "C"}));
        System.out.println(sol.solution(8, 2, new String[]{"C", "C", "C", "C", "C", "C", "C", "C", "Z", "Z", "Z", "Z", "Z", "Z", "Z", "Z"}));
        System.out.println(sol.solution(8, 2, new String[]{"D 2", "U 3", "D 4", "C", "U 2", "Z"}));
        System.out.println(sol.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
        System.out.println(sol.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"}));
    }
}
