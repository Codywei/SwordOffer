import java.util.ArrayList;
import java.util.Arrays;
/**
 字符串的排列（字符串，回溯）

 题目描述
 输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 * */
public class Permutation {
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        if(str.length()==0){
            return ret;
        }
        char[] chars=str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars,new boolean[chars.length],new StringBuilder());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuilder s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }
            // 保证不重复(如“abbc”中的‘b’)，加上!hasUsed[i - 1]就是说明在i-1已经完成了一轮backtracking，使用标志位重新置为false,或是i-1位之前就有相同元素完成backtracking,导致i-1位直接跳过。
            // 这时如果第i位和第i-1位相等，为避免重复，就不应该在同一个位置进行回溯。
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) {
                continue;
            }
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }

    }

    public static void main(String[] args) {
        ArrayList<String> ret=new ArrayList<>();
        String str="abbc";
        Permutation permutation=new Permutation();
        ret=permutation.Permutation(str);
        for (int i = 0; i < ret.size(); i++) {
            System.out.println(ret.get(i));

        }

    }
}
