package codingtest.in2021;

import java.util.Arrays;

class KakaoMakers1Solution {
    public int solution(int[] gift_cards, int[] wants) {
        int answer = wants.length;
        for (int i = 0; i < wants.length; i++) {
            for (int j = 0; j < gift_cards.length; j++) {
                if (wants[i] == gift_cards[j]) {
                    int temp = gift_cards[i];
                    gift_cards[i] = gift_cards[j];
                    gift_cards[j] = temp;
                }

            }
            System.out.println(Arrays.toString(gift_cards));
        }

        for (int i = 0; i < gift_cards.length; i++) {
            if (gift_cards[i] == wants[i]){
                answer--;
            }
        }

        return answer;
    }
}

public class KakaoMakers1 {
    public static void main(String[] args) {
        KakaoMakers1Solution sol = new KakaoMakers1Solution();
        System.out.println(sol.solution(new int[]{4, 5, 3, 2, 1}, new int[]{2, 4, 4, 5, 1}));
        System.out.println(sol.solution(new int[]{5, 4, 5, 4, 5}, new int[]{1, 2, 3, 5, 4}));
    }
}
