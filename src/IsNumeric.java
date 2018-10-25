/**
 表示数值的字符串

 题目描述
 true
 "+100"
 false
 "12e"

 解题思路
 使用正则表达式进行匹配。

 []  ： 字符集合
 ()  ： 分组
 ?   ： 重复 0 ~ 1
 +   ： 重复 1 ~ n
 *   ： 重复 0 ~ n
 .   ： 任意字符
 \\. ： 转义后的 .
 \\d ： 数字

 * */
public class IsNumeric {
    public boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        return new String(str).matches("[+-]?\\d*(\\.\\d+)?([eE][+-]?\\d+)?");
    }

    public static void main(String[] args) {
        IsNumeric in=new IsNumeric();
        String str="+1000";
        System.out.println(in.isNumeric(str.toCharArray()));
    }
}
