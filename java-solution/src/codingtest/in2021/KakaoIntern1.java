package codingtest.in2021;

import java.util.Locale;

class KakaoIntern1Solution {
    public int solution(String s) {
        return Integer.parseInt(toNumber(s));
    }

    private String toNumber(String s) {
        return s.toLowerCase(Locale.ROOT)
                .replace("zero","0")
                .replace("one", "1")
                .replace("two","2")
                .replace("three","3")
                .replace("four","4")
                .replace("five","5")
                .replace("six","6")
                .replace("seven","7")
                .replace("eight","8")
                .replace("nine","9");
    }
}

public class KakaoIntern1 {
    public static void main(String[] args) {
        KakaoIntern1Solution sol = new KakaoIntern1Solution();
        System.out.println(sol.solution("one4seVeneight"));
        System.out.println(sol.solution("23four5six7"));
        System.out.println(sol.solution("2three45sixseven"));
        System.out.println(sol.solution("123"));
    }
}
