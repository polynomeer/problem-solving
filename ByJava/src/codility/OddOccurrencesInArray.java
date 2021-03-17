package codility;

class OddOccurrencesInArraySolution {
    public int solution(int[] A) {
        int result = 0;
        for (int a : A) {
            result ^= a;
        }
        return result;
    }
}

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        OddOccurrencesInArraySolution sol = new OddOccurrencesInArraySolution();
        System.out.println(sol.solution(new int[]{9,3,9,3,9,7,9}));
    }
}
