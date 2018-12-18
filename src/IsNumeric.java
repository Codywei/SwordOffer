/**
 表示数值的字符串（字符串，正则表达式）

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


/*
以下对正则进行解释:
[\\+\\-]?            -> 正或负符号出现与否
\\d*                 -> 整数部分是否出现，如-.34 或 +3.34均符合
(\\.\\d+)?           -> 如果出现小数点，那么小数点后面必须有数字；
                    否则一起不出现
([eE][\\+\\-]?\\d+)? -> 如果存在指数部分，那么e或E肯定出现，+或-可以不出现，
                    紧接着必须跟着整数；或者整个部分都不出现
*/
        //return new String(str).matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }


    public boolean isNumeric2(char[] str) {

        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                // e后面一定要接数字
                if (i == str.length-1) {
                    return false;
                }
                // 不能同时存在两个e
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (sign && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!sign && i > 0 && str[i-1] != 'e' && str[i-1] != 'E') {
                    return false;
                }
                sign = true;
            } else if (str[i] == '.') {
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || decimal) {
                    return false;
                }
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') {
                // 不合法字符
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        IsNumeric in=new IsNumeric();
        String str="+.80e+21";
        System.out.println(in.isNumeric2(str.toCharArray()));
    }
}
