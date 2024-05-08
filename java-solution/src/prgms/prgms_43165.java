package prgms;

class Solution_43165 {
    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int sum, int count) {
        if (count == numbers.length) {
            return (sum == target) ? 1 : 0;
        }
        return dfs(numbers, target, sum + numbers[count], count + 1)
                + dfs(numbers, target, sum - numbers[count], count + 1);
    }
}

public class prgms_43165 {
    public static void main(String[] args) {
        Solution_43165 sol = new Solution_43165();
        System.out.println(sol.solution(new int[]{1, 1, 1, 1, 1}, 3) == 5);
    }
}
