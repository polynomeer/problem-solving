package prgms;

class Solution42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++) {
                if (i == j) continue;
                if (phone_book[i].length() <= phone_book[j].length() &&
                        phone_book[i].equals(phone_book[j].substring(0, phone_book[i].length()))) {
                    return false;
                }
            }
        }
        return answer;
    }
}

public class Programmers42577 {
    public static void main(String[] args) {
        Solution42577 sol = new Solution42577();
        System.out.println(sol.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(sol.solution(new String[]{"23","456","789"}));
        System.out.println(sol.solution(new String[]{"12","123","1235","567","88"}));
    }
}
