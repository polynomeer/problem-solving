package prgms.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution_12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int round = 0;
        int drop = 0;
        boolean isDropped = false;

        Set<String> set = new HashSet<>();
        char last = '0';
        for (String word : words) {
            if (last != '0' && (last != word.charAt(0) || set.contains(word))) {
                isDropped = true;
                break;
            }
            last = word.charAt(word.length() - 1);
            set.add(word);
            drop = (drop + 1) % n;
            round++;
        }

        if (isDropped) {
            answer[0] = drop + 1;
            answer[1] = round / n + 1;
        }
        return answer;
    }
}

public class prgms_12981 {
    public static void main(String[] args) {
        Solution_12981 sol = new Solution_12981();
        System.out.println(Arrays.toString(sol.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(sol.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"})));
        System.out.println(Arrays.toString(sol.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}
