package codingtest.in2021;

import java.util.HashMap;
import java.util.Map;

class KakaoMobility1Solution {
    /**
     * @param S string containing a list of names
     * @param C the name of company
     * @return the list of email addresses
     */
    public String solution(String S, String C) {
        StringBuilder answer = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        String[] tokens = S.split(",");

        for (String token : tokens) {
            String fullName = token.trim();
            String[] names = fullName.split(" ");
            String id = "";

            if (names.length == 2) {
                id = names[0].toLowerCase().charAt(0) + names[1].toLowerCase();
            }

            if (names.length == 3) {
                String lastName = names[2].replace("-", "").trim().toLowerCase();
                if (lastName.length() > 8) {
                    lastName = lastName.substring(0, 8);
                }
                id = names[0].toLowerCase().charAt(0) + (names[1].toLowerCase().charAt(0) + lastName);
            }

            map.put(id, map.getOrDefault(id, 0) + 1);
            int count = map.getOrDefault(id, 1);

            if (count > 1) id += count;

            String result = fullName + " <" + id + "@" + C.toLowerCase() + ".com>";
            answer.append(result).append(", ");
        }
        return answer.substring(0, answer.length() - 2);
    }
}

public class KakaoMobility1 {
    public static void main(String[] args) {
        KakaoMobility1Solution sol = new KakaoMobility1Solution();
        System.out.println(sol.solution("John Doe, Peter Parker, Mary Jane Watson-Parker, James Doe, John Elvis Doe, Jane Doe, Penny Parker", "Example")
                .equals("John Doe <jdoe@example.com>, Peter Parker <pparker@example.com>, Mary Jane Watson-Parker <mjwatsonpa@example.com>, James Doe <jdoe2@example.com>, John Elvis Doe <jedoe@example.com>, Jane Doe <jdoe3@example.com>, Penny Parker <pparker2@example.com>"));
    }


}
