package codingtest.in2021;

import java.util.*;

// 방법1 : 리스트에 더한 후 퀵 소트
// 방법2 : 병합정렬
// 방법3 : 맵에 각 수를 카운트하고, 다시 채워넣기
/*class codingtest.in2021.FloSolution {
    public Integer[] solution(int[] nums1, int len1, int[] nums2, int len2) {
        List<Integer> list = new LinkedList<>();
        for (int n1 : nums1) {
            if (n1 != 0) list.add(n1);
        }
        for (int n2 : nums2) {
            list.add(n2);
        }

        Collections.sort(list);

        return list.toArray(new Integer[0]);
    }
}*/

/*class FloSolution {
    public Integer[] solution(int[] nums1, int len1, int[] nums2, int len2) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int n1 : nums1) {
            if (n1 != 0) map.put(n1, map.getOrDefault(n1, 0) + 1);
        }
        for (int n2 : nums2) {
            map.put(n2, map.getOrDefault(n2, 0) + 1);
        }

        Integer[] answer = new Integer[len1 + len2];
        int idx = 0;
        for (Integer integer : map.keySet()) {
            int count = map.get(integer);
            for (int i = 0; i < count; i++) {
                answer[idx++] = integer;
            }
        }
        return answer;
    }
}*/

class FloSolution {
    public int[] solution(int[] nums1, int len1, int[] nums2, int len2) {
        int j = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] == 0) {
                nums1[i] = nums2[j++];
            }
        }
        Arrays.sort(nums1);
        return nums1;
    }
}

public class FloTest {
    public static void main(String[] args) {
        FloSolution sol = new FloSolution();
        System.out.println(Arrays.toString(sol.solution(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3)));
    }
}
