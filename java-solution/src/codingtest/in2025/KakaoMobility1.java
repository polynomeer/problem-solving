package codingtest.in2025;

import java.util.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class KakaoMobility1Solution {

    public String solution(String S, String C) {
        String company = C.toLowerCase();
        Map<String, Integer> emailCount = new HashMap<>();

        return Stream.of(S.split(", "))
                .map(fullName -> {
                    String emailId = generateEmailId(fullName, emailCount);
                    String email = emailId + "@" + company + ".com";
                    return fullName + " <" + email + ">";
                })
                .collect(Collectors.joining(", "));
    }

    private String generateEmailId(String fullName, Map<String, Integer> emailCount) {
        var tokens = fullName.split(" ");
        var first = Character.toLowerCase(tokens[0].charAt(0));
        var middle = tokens.length >= 3 ? Character.toLowerCase(tokens[1].charAt(0)) : '\0';
        var rawLast = tokens[tokens.length - 1].replace("-", "").toLowerCase();
        var last = rawLast.substring(0, Math.min(8, rawLast.length()));
        var baseId = String.valueOf(first) + (middle != '\0' ? middle : "") + last;
        var count = emailCount.merge(baseId, 1, Integer::sum);
        return count == 1 ? baseId : baseId + count;
    }
}


class KakaoMobility1Solution___ {
    public String solution(String S, String C) {
        var names = S.split(", ");
        var company = C.toLowerCase();
        var emailCount = new HashMap<String, Integer>();
        var result = new ArrayList<String>();

        for (var fullName : names) {
            var emailId = generateEmailId(fullName, emailCount);
            var email = emailId + "@" + company + ".com";
            result.add(fullName + " <" + email + ">");
        }

        return String.join(", ", result);
    }

    private String generateEmailId(String fullName, Map<String, Integer> emailCount) {
        var parts = fullName.split(" ");
        var first = parts[0];
        var middle = parts.length == 3 ? parts[1] : "";
        var last = parts[parts.length - 1].replace("-", "").toLowerCase();
        var lastPart = last.length() > 8 ? last.substring(0, 8) : last;

        var sb = new StringBuilder();
        sb.append(Character.toLowerCase(first.charAt(0)));
        if (!middle.isEmpty()) {
            sb.append(Character.toLowerCase(middle.charAt(0)));
        }
        sb.append(lastPart);

        var baseEmailId = sb.toString();
        var count = emailCount.getOrDefault(baseEmailId, 0) + 1;
        emailCount.put(baseEmailId, count);

        return count == 1 ? baseEmailId : baseEmailId + count;
    }
}


class KakaoMobility1Solution__ {
    public String solution(String S, String C) {
        String[] names = S.split(", ");
        String company = C.toLowerCase();
        Map<String, Integer> emailCount = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (String name : names) {
            String[] parts = name.split(" ");
            String first = parts[0];
            String middle = parts.length == 3 ? parts[1] : "";
            String last = parts[parts.length - 1].replace("-", "");

            StringBuilder email = new StringBuilder();
            email.append(Character.toLowerCase(first.charAt(0)));
            if (!middle.isEmpty()) {
                email.append(Character.toLowerCase(middle.charAt(0)));
            }
            email.append(last.substring(0, Math.min(8, last.length())).toLowerCase());

            String emailId = email.toString();
            int count = emailCount.getOrDefault(emailId, 0) + 1;
            emailCount.put(emailId, count);

            if (count > 1) {
                emailId += count;
            }

            String fullEmail = emailId + "@" + company + ".com";
            result.add(name + " <" + fullEmail + ">");
        }

        return String.join(", ", result);
    }
}

class KakaoMobility1Solution_ {
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
