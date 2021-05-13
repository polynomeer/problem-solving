package leetcode;

/*class OneBitCharactersSolution {
    public boolean isOneBitCharacter(int[] bits) {
        int bit = 0;
        while (bit < bits.length - 1) {
            if (bits[bit] == 0) {
                bit += 1;
            } else if (bits[bit] == 1) {
                bit += 2;
            }
        }
        return bit == bits.length - 1;
    }
}*/

class OneBitCharactersSolution {
    public boolean isOneBitCharacter(int[] bits) {
        int bit = 0;
        for (int i = 0; i < bits.length - 1; ) {
            if (bits[i] == 1) {
                bit += 2;
                i += 2;
            } else {
                bit++;
                i++;
            }
        }
        return bit == bits.length - 1;
    }
}

public class OneBitCharacters {
    public static void main(String[] args) {
        OneBitCharactersSolution sol = new OneBitCharactersSolution();
        System.out.println(sol.isOneBitCharacter(new int[]{1, 0, 0}));
        System.out.println(sol.isOneBitCharacter(new int[]{1, 1, 1, 0}));
    }
}
