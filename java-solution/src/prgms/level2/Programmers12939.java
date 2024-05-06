package prgms.level2;

class Solution12939 {
    public String solution(String s) {
        String[] tokens = s.split(" ");
        int max = -987654321;
        int min = 987654321;

        for (String token : tokens) {
            int num = Integer.parseInt(token);
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        return min + " " + max;
    }
}

public class Programmers12939 {
    public static void main(String[] args) {
        Solution12939 sol = new Solution12939();
        System.out.println(sol.solution("1 2 3 4"));
    }
}
