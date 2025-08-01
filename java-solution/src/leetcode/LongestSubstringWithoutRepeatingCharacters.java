package leetcode;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 이 코드는 단순히 가장 긴 substring의 길이를 반환하지만,
     * 중복되지 않는 문자로 이루어진 substring만 고려하지 않는다.
     * 즉, "abcabcbb" 와 같은 문자열에서 "abcabc"(중복 포함된 부분)도 후보에 포함되므로 잘못된 답이 나올 수 있다.
     */
    static class Solution1 {
        public int lengthOfLongestSubstring(String s) {
            List<String> substrings = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    substrings.add(s.substring(i, j));
                }
            }

            substrings.sort((s1, s2) -> Integer.compare(s2.length(), s1.length()));
            return substrings.getFirst().length();
        }
    }

    /**
     * Brute-force (완전 탐색)
     * 모든 substring을 구하면서, 그 안에 중복 문자가 없는지 검사
     * 중복이 없는 경우에만 리스트에 넣거나 길이 비교
     * 단, 시간 복잡도 O(n²) 라서 느리다
     */
    static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            int maxLen = 0;

            for (int i = 0; i < s.length(); i++) {
                Set<Character> set = new HashSet<>();
                for (int j = i; j < s.length(); j++) {
                    char c = s.charAt(j);
                    if (set.contains(c)) {
                        break;
                    }
                    set.add(c);
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }

            return maxLen;
        }
    }

    /**
     * 슬라이딩 윈도우 + HashMap
     * -> 슬라이딩 윈도우: 중복이 발생하지 않는 구간을 좌우 포인터로 유지
     * -> Map or Set: 문자의 마지막 위치를 기억해서 중복을 빠르게 감지
     * <p>
     * 시간 복잡도 O(n): 각 문자는 최대 한 번씩만 윈도우에 들어오고 나간다
     * O(min(n, m)): n은 문자열 길이, m은 문자 집합 크기 (ASCII 128 또는 Unicode 256)
     */
    static class Solution3 {
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int maxLength = 0;
            int start = 0;

            for (int end = 0; end < s.length(); end++) {
                char c = s.charAt(end);
                if (map.containsKey(c) && map.get(c) >= start) {
                    start = map.get(c) + 1;
                }

                map.put(c, end);
                maxLength = Math.max(maxLength, end - start + 1);
            }

            return maxLength;
        }
    }

    /**
     * Set + 이중 포인터 (Two Pointer - Basic Sliding Window)
     * 중복을 막기 위해 Set 사용, 오른쪽 포인터를 늘려가며 탐색
     * -> 중복 문자가 나오면 왼쪽 포인터를 앞으로 이동하면서 Set에서 제거
     * -> HashSet 을 통해 현재 substring에 어떤 문자가 있는지 빠르게 검사
     * <p>
     * 시간복잡도: O(n), 각 문자는 Set에 한 번 들어가고 한 번 나옴
     * 공간복잡도: O(min(n, m)) (m = 알파벳 개수)
     */
    static class Solution4 {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int left = 0, right = 0, maxLen = 0;

            while (right < s.length()) {
                char c = s.charAt(right);
                // 중복이면 왼쪽 포인터 이동하며 문자 제거
                while (set.contains(c)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(c);
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            }

            return maxLen;
        }
    }

    /**
     * 배열을 이용한 문자 인덱스 기록 (ASCII 캐릭터 최적화)
     * int[128] 배열을 사용해서 각 문자의 최근 인덱스를 저장하면 HashMap 보다 빠름
     */
    static class Solution5 {
        public int lengthOfLongestSubstring(String s) {
            int[] index = new int[128]; // ASCII 문자
            int maxLen = 0, start = 0;

            for (int end = 0; end < s.length(); end++) {
                char c = s.charAt(end);
                start = Math.max(index[c], start);
                maxLen = Math.max(maxLen, end - start + 1);
                index[c] = end + 1; // 위치 +1 저장
            }

            return maxLen;
        }
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        solution.lengthOfLongestSubstring("abcabcbb");
    }
}

