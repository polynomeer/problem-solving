package codingtest.in2025;

class KakaoMobility3Solution {
    public int solution(int[] A) {
        int n = A.length;
        int maxLen = 1;
        int start = 0;
        int even = A[0];
        int odd = (n > 1) ? A[1] : 0;

        for (int i = 2; i < n; i++) {
            if ((i % 2 == 0 && A[i] != even) || (i % 2 == 1 && A[i] != odd)) {
                maxLen = Math.max(maxLen, i - start);
                start = i - 1;
                even = (start % 2 == 0) ? A[start] : A[i];
                odd = (start % 2 == 1) ? A[start] : A[i];
            }
        }
        maxLen = Math.max(maxLen, n - start);
        return maxLen;
    }
}

public class KakaoMobility3 {
    public static void main(String[] args) {
        KakaoMobility3Solution sol = new KakaoMobility3Solution();
        System.out.println(sol.solution(new int[]{3, 2, 3, 2, 3}) == 5);
        System.out.println(sol.solution(new int[]{7, 4, -2, 4, -2, -9}) == 4);
        System.out.println(sol.solution(new int[]{7, -5, -5, -5, 7, -1, 7}) == 3);
        System.out.println(sol.solution(new int[]{4}) == 1);
    }
}
