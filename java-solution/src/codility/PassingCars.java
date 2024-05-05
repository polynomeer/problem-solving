package codility;
// 0 1 0 1 1
//->
//  <-
//    ->
//      <-
//        <-
class PassingCarsSolution {
    public int solution(int[] A) {
        int answer = 0;
        int[] west = new int[A.length];
        int n = A.length;

        if (A[n - 1] == 1) {
            west[n - 1] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            west[i] = west[i + 1];
            if (A[i] == 1) {
                west[i]++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (A[i] == 0) {
                answer += west[i];
            }
        }
        if (answer > 1_000_000_000 || answer < -1_000_000_000) {
            answer = -1;
        }

//        for (int w : west) {
//            System.out.print(w + " ");
//        }
//        System.out.println();
        return answer;
    }
}


public class PassingCars {
    public static void main(String[] args) {
        PassingCarsSolution sol = new PassingCarsSolution();
        System.out.println(sol.solution(new int[]{0, 1, 0, 1, 1}));
    }
}
