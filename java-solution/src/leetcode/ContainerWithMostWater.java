package leetcode;

public class ContainerWithMostWater {
    static class Solution {
        public int maxAreaV1(int[] height) {
            int max = -987654321;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
                }
            }
            return max;
        }

        public int maxArea(int[] height) {
            int max = 0;
            int left = 0, right = height.length - 1;

            while (left < right) {
                int currentArea = Math.min(height[left], height[right]) * (right - left);
                max = Math.max(max, currentArea);

                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
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