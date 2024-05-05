package codingtest.in2020;

class PrgmsWinterCoding2Solution {
    public String solution(String encryptedText, String key, int rotation) {
        String answer = decrypt(encryptedText, key, rotation);


        return answer;
    }

    private String decrypt(String encryptedText, String key, int rotation) {
        StringBuilder decrypted = new StringBuilder();

        String decryptedText = rotate(encryptedText.toString(), -rotation);
        char[] decryptedTexts = decryptedText.toCharArray();
        char[] keys = key.toCharArray();

        for (int i = 0; i < decryptedTexts.length; i++) {
            char decryptedChar = (char) (decryptedTexts[i] - (keys[i] - 'a' + 1));
            while (decryptedChar < 'a') {
                decryptedChar = (char) ('z' - ('a' - decryptedChar) + 1);
            }
            decrypted.append(decryptedChar);
        }

        System.out.println(encrypt("hellopython", key, rotation));

        return decrypted.toString();
    }

    private String encrypt(String plainText, String key, int rotation) {
        StringBuilder encrypted = new StringBuilder();
        char[] plainTexts = plainText.toCharArray();
        char[] keys = key.toCharArray();

        for (int i = 0; i < plainTexts.length; i++) {
            char encryptedChar = (char) (plainTexts[i] + (keys[i] - 'a' + 1));
            while (encryptedChar > 'z') {
                encryptedChar = (char) ('a' + encryptedChar - 'z' - 1);
            }
            encrypted.append(encryptedChar);
        }
        return rotate(encrypted.toString(), rotation);
    }

    private String rotate(String encryptedText, int rotation) {
        String rotated;
        rotation %= encryptedText.length();

        if (rotation >= 0) {
            rotation = encryptedText.length() - rotation;
        } else {
            rotation = -rotation;
        }
        rotated = encryptedText.substring(rotation) + encryptedText.substring(0, rotation);

        return rotated;
    }
}

public class PrgmsWinterCoding2 {
    public static void main(String[] args) {
        PrgmsWinterCoding2Solution sol = new PrgmsWinterCoding2Solution();
        System.out.println(sol.solution("qyyigoptvfb", "abcdefghijk", 3));
    }
}
