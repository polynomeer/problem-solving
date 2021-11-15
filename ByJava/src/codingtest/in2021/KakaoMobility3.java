package codingtest.in2021;

class KakaoMobility3Solution {
    public int solution(int[] A) {
        int answer = 1;
        if (A.length == 1) return 1;
        if (A.length == 2) return 2;

        int even = A[0];
        int odd = A[1];
        int count = 2;

        for (int i = 2; i < A.length; i++) {
            if (i % 2 == 0) {
                if (A[i] == even) count++;
                else count = 2;
                even = A[i];
            } else {
                if (A[i] == odd) count++;
                else count = 2;
                odd = A[i];
            }
            answer = Math.max(answer, count);
        }
        return answer;
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
