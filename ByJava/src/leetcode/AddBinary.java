package leetcode;

class AddBinarySolution {

    static class Unit {
        int carry;
        int sum;

        public Unit(int carry, int sum) {
            this.carry = carry;
            this.sum = sum;
        }
    }

    public String addBinary(String a, String b) {
        if (a.equals("0") && b.equals("0")){
            return "0";
        }

        StringBuilder answer = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;

        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        int carry = 0;
        int sum = 0;
        while (i >= 0 || j >= 0) {
            char charA = i < 0 ? 0 : charsA[i];
            char charB = j < 0 ? 0 : charsB[j];

            Unit unit = add(charA, charB);
            sum = unit.sum + carry;
            carry = unit.carry;

            if (sum >= 2) {
                sum = 0;
                carry++;
            }

            i--;
            j--;
            answer.append(sum);
        }

        if (carry > 0) {
            answer.append(carry);
        }
        return answer.reverse().toString();
    }

    private Unit add(char a, char b) {
        Unit unit = new Unit(0, 0);
        if (a == '1' && b == '1') {
            unit.carry = 1;
            unit.sum = 0;
        } else if (a == '1' || b == '1') {
            unit.carry = 0;
            unit.sum = 1;
        }
        return unit;
    }
}

/*class AddBinarySolution {
    public String addBinary(String a, String b) {
        String answer = "";

        long sum = toDecimal(a) + toDecimal(b);
        System.out.println(toBinary(sum));
        StringBuilder sb = new StringBuilder();
        sb.append(toBinary(sum));
        sb.reverse();

        answer = sb.toString();
        if (answer.equals("")) answer = "0";
        return answer;
    }

    private long toDecimal(String s) {
        long binary = Long.parseLong(s);
        long decimal = 0;
        long power = 0;
        while (binary > 0) {
            long temp = binary % 10;
            for (int i = 0; i < power; i++) {
                temp *= 2;
            }
            decimal += temp;
            binary /= 10;
            power++;
        }
        return decimal;
    }

    private String toBinary(long decimal) {
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            long temp = decimal % 2;
            binary.append(temp);
            decimal /= 2;
        }
        return binary.toString();
    }
}*/

public class AddBinary {
    public static void main(String[] args) {
        AddBinarySolution sol = new AddBinarySolution();
        System.out.println(sol.addBinary("11", "1"));
        System.out.println(sol.addBinary("1010", "1011"));
        System.out.println(sol.addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101",
                "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011"));
    }
}
