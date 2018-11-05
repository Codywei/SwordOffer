import java.util.BitSet;
/**
 第一个只出现一次的字符位置

 题目描述
 在一个字符串中找到第一个只出现一次的字符，并返回它的位置。

 解题思路
 最直观的解法是使用 HashMap 对出现次数进行统计，但是考虑到要统计的字符范围有限，因此可以使用整型数组代替 HashMap。
 以上实现的空间复杂度还不是最优的。考虑到只需要找到只出现一次的字符，那么需要统计的次数信息只有 0,1,更大，使用两个比特位就能存储这些信息。
 * */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        int[] cnts = new int[256];
        for (int i = 0; i < str.length(); i++) {
            cnts[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (cnts[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public int FirstNotRepeatingChar2(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c)) {
                // 0 0 -> 0 1
                bs1.set(c);
            }
            else if (bs1.get(c) && !bs2.get(c)) {
                // 0 1 -> 1 1
                bs2.set(c);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 0 1
            if (bs1.get(c) && !bs2.get(c)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstNotRepeatingChar fa=new FirstNotRepeatingChar();
        String str="adfawaf";
        System.out.println(fa.FirstNotRepeatingChar(str));
        System.out.println(fa.FirstNotRepeatingChar2(str));
    }
}
