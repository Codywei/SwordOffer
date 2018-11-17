import java.util.ArrayList;

/**
 和为 S 的连续正数序列（数组）

 题目描述
 输出所有和为 S 的连续正数序列。
 * */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

        int start=1;
        int end=2;
        int cursum=3;
        while(end<sum){
            if(cursum>sum){
                cursum-=start;
                start++;
            }
            else if(cursum<sum){
                end++;
                cursum+=end;
            }
            else{
                ArrayList<Integer> list=new ArrayList<>();
                for(int i=start;i<=end;i++){
                    list.add(i);
                }
                ret.add(list);
                cursum-=start;
                start++;
                end++;
                cursum+=end;
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
