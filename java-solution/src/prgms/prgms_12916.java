package prgms;

class Solution_12916 {
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            if (c == 'p') pCount++;
            if (c == 'y') yCount++;
        }
        return pCount == yCount;
    }
}

public class prgms_12916 {
    public static void main(String[] args) {
        Solution_12916 sol = new Solution_12916();
        System.out.println(sol.solution("pPoooyY"));
        System.out.println(sol.solution("Pyy"));
    }
}
