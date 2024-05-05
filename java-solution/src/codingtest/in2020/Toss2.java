package codingtest.in2020;

class SolutionToss2 {
    public boolean solution(String s) {
        String[] tokens = s.split(" ");
        boolean[] visit = new boolean[46];
        int[] array = new int[tokens.length];

        if (tokens.length != 6) return false;
        int i = 0;
        for (String token : tokens) {
            int num = Integer.parseInt(token);
            if (num < 1 || num > 45) return false;
            if (visit[num]) return false;
            visit[num] = true;
            array[i++] = num;
        }

        for (i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) return false;
        }
        return true;
    }
}

public class Toss2 {
    public static void main(String[] args) {
        SolutionToss2 sol = new SolutionToss2();
        System.out.println(sol.solution("1 2 3 4 5 6"));
        System.out.println(sol.solution("1 3 5 7 7 9"));
        System.out.println(sol.solution("1 2 4 5 6"));
        System.out.println(sol.solution("2 1 3 5 7 9"));
        System.out.println(sol.solution("46 1 3 5 7 9"));
    }
}
