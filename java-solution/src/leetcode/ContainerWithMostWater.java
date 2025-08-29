package leetcode;

public class ContainerWithMostWater {
    static class Solution {
        public int maxArea(int[] height) {
            int max = -987654321;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
                }
            }
            return max;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        }
    }
}
