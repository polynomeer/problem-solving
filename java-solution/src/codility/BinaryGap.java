package codility;

class BinaryGapSolution {
    public int solution(int N) {
        int gapMax = 0;
        String numStr = Integer.toBinaryString(N);

        char[] nums = numStr.toCharArray();
        System.out.println(numStr);

        for (int i = 0; i < nums.length; i++) {
            int gap = 0;
            boolean isOneMatched = false;
            if (nums[i] == '1') {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == '1') {
                        isOneMatched = true;
                        break;
                    }
                    gap++;
                }
            }
            if (isOneMatched) {
                gapMax = Math.max(gapMax, gap);
            }

        }
        return gapMax;
    }

//    To use this method, it needs to be reversed
//    private long decToBin(int n) {
//        long result = 0;
//        while (n != 0) {
//            System.out.println(result);
//            result *= 10;
//            result += n % 2;
//            n /= 2;
//        }
//        return result;
//    }
}


public class BinaryGap {
    public static void main(String[] args) {
        BinaryGapSolution sol = new BinaryGapSolution();
        System.out.println(sol.solution(9));
        System.out.println(sol.solution(1041));
        System.out.println(sol.solution(32));
    }
}
