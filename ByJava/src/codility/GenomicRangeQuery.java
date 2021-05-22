package codility;

import java.util.Arrays;

class GenomicRangeQuerySolution {
    public int[] solution(String S, int[] P, int[] Q) {
        int M = P.length;
        int answer[] = new int[M];
        char[] totalNucleotides = S.toCharArray();

        for (int i = 0; i < M; i++) {
            String partialNucleotides = S.substring(P[i], Q[i]);

            char[] nucleotides = partialNucleotides.toCharArray();
            Arrays.sort(nucleotides);

            if (nucleotides.length > 0) {
                answer[i] = toFactor(nucleotides[0]);
            } else {
                answer[i] = toFactor(S.toCharArray()[P[i]]);
            }
        }
        return answer;
    }

    private int toFactor(char c) {
        switch (c) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
        }
        return 0;
    }
}

public class GenomicRangeQuery {
    public static void main(String[] args) {
        GenomicRangeQuerySolution sol = new GenomicRangeQuerySolution();
        System.out.println(Arrays.toString(sol.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6})));
    }
}
