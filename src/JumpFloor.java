/**
 跳台阶（动态规划）

 题目描述
 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

 解题思路
最后的一次跳跃的结果，可以通过把前1步和前2步的跳法相加得到
 * */
public class JumpFloor {

    public int JumpFloor(int n){
        if(n<=2){
            return n;
        }
        int result=0;
        int pre2=1;
        int pre1=2;
        //注意这里的赋值步骤不要搞错了
        for(int i=3;i<=n;i++){
            result=pre1+pre2;
            pre2=pre1;
            pre1=result;

        }
        return result;
 }

    public static void main(String[] args) {
         JumpFloor jf=new JumpFloor();
        System.out.println(jf.JumpFloor(6));
    }
}
