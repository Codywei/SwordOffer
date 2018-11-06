import java.util.ArrayList;

/**
 和为 S 的连续正数序列

 题目描述
 输出所有和为 S 的连续正数序列。
 * */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        int start = 1, end = 2;
        int curSum = 3;
        while (end < sum) {
            if (curSum > sum) {
                curSum -= start;
                start++;
            } else if (curSum < sum) {
                end++;
                curSum += end;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    list.add(i);
                }
                ret.add(list);
                curSum -= start;
                start++;
                end++;
                curSum += end;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>>ret=new ArrayList<ArrayList<Integer>>();
        FindContinuousSequence fc=new FindContinuousSequence();
        ret=fc.FindContinuousSequence(100);
        for (int i = 0; i < ret.size(); i++) {
            for (int j = 0; j < ret.get(i).size(); j++) {
                System.out.print(ret.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
