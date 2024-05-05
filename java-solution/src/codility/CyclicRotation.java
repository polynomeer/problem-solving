package codility;

import java.util.Arrays;

//class CyclicRotationSolution {
//    public int[] solution(int[] A, int K) {
//        if (A.length == 0) return null;
//
//        int[] answer = new int[A.length];
//        String s = "";
//        StringBuilder sb = new StringBuilder();
//        for (int a : A) {
//            sb.append(a);
//        }
//        s = sb.toString();
//
//        K = K % A.length;
//        String ans = rightRotate(s, K);
//
//        int i = 0;
//        for (char c : ans.toCharArray()) {
//            answer[i++] = Character.getNumericValue(c);
//        }
//        return answer;
//    }
//
//    String leftRotate(String str, int d) {
//        return str.substring(d) + str.substring(0, d);
//    }
//
//    String rightRotate(String str, int d) {
//        return leftRotate(str, str.length() - d);
//    }
//}

class CyclicRotationSolution {
    public int[] solution(int[] A, int K) {
        int N = A.length;
        if (N == 0) return A;

        K = K % N;
        for (int i = 0; i < K; i++) {
            A = rotateRight(A);
        }
        return A;
    }

    private int[] rotateRight(int[] a) {
        int[] temp = new int[a.length];
        System.arraycopy(a, 0, temp, 0, a.length);
        temp[0] = a[a.length - 1];
        System.arraycopy(a, 0, temp, 1, a.length - 1);
        return temp;
    }
}

public class CyclicRotation {
    public static void main(String[] args) {
        CyclicRotationSolution sol = new CyclicRotationSolution();
        System.out.println(Arrays.toString(sol.solution(new int[]{3, 8, 9, 7, 6}, 3)));
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 3, 4}, 4)));
        System.out.println(Arrays.toString(sol.solution(new int[]{0, 0, 0}, 1)));
        System.out.println(Arrays.toString(sol.solution(new int[]{}, 1)));
        System.out.println(Arrays.toString(sol.solution(new int[]{1}, 5)));
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 4, 7, 9}, 6)));
    }
}
