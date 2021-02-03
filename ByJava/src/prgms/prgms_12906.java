package prgms;

import java.util.*;

class Solution_12906 {
    public Integer[] solution(int []arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : arr){
            set.add(num);
        }
        Integer[] answer = new Integer[set.size()];
        set.toArray(answer);
        return answer;
    }
}

public class prgms_12906 {
    public static void main(String[] args) {
        Solution_12906 sol = new Solution_12906();
        System.out.println();
    }
}
