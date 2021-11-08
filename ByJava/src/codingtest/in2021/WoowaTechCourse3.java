package codingtest.in2021;

import java.util.HashMap;
import java.util.Map;

class WoowaTechCourse3Solution {
    public int solution(String[] ings, String[] menu, String[] sell) {
        int answer = 0;
        Map<String, Integer> ingredients = new HashMap<>();
        Map<String, Integer> profits = new HashMap<>();

        for (String ing : ings) {
            String[] token = ing.split(" ");
            String ingredient = token[0];
            int price = Integer.parseInt(token[1]);
            ingredients.put(ingredient, price);
        }

        for (String m : menu) {
            String[] token = m.split(" ");
            String name = token[0];
            String[] need = token[1].split("");
            int profit = Integer.parseInt(token[2]);

            for (String n : need) { // 순이익 = 원가 - 재료비
                profit -= ingredients.get(n);
            }

            profits.put(name, profit);
        }

        for (String s : sell) {
            String[] token = s.split(" ");
            String name = token[0];
            int saleCount = Integer.parseInt(token[1]);

            answer += profits.get(name) * saleCount;
        }

        return answer;
    }
}

public class WoowaTechCourse3 {
    public static void main(String[] args) {
        WoowaTechCourse3Solution sol = new WoowaTechCourse3Solution();
        System.out.println(sol.solution(new String[]{"r 10", "a 23", "t 124", "k 9"},
                new String[]{"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"},
                new String[]{"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"}));
        System.out.println(sol.solution(new String[]{"x 25", "y 20", "z 1000"},
                new String[]{"AAAA xyxy 15", "TTT yy 30", "BBBB xx 30"},
                new String[]{"BBBB 3", "TTT 2"}));
    }
}
