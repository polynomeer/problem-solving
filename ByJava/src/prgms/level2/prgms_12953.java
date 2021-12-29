package prgms.level2;

import java.util.Arrays;

class Solution_12953 {
    public int solution(int[] arr) {
        Arrays.sort(arr);
        int i = 1;
        for (; i < Math.pow(100, 15); i++) {
            if (isDivided(arr, i)) break;
        }
        return i;
    }

    private boolean isDivided(int[] arr, int i) {
        for (int k : arr) {
            if (i % k != 0) return false;
        }
        return true;
    }
}

public class prgms_12953 {
    public static void main(String[] args) {
        Solution_12953 sol = new Solution_12953();
        System.out.println(sol.solution(new int[]{2, 6, 8, 14}) == 168);
        System.out.println(sol.solution(new int[]{1, 2, 3}) == 6);
    }
}
