import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
从上往下打印二叉树（树）

 题目描述
 从上往下打印出二叉树的每个节点，同层节点从左至右打印。


 解题思路
 使用队列来进行层次遍历。

 * */
public class PrintFromTopToBottom {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode t = queue.poll();
                if (t == null) {
                    continue;
                }
                ret.add(t.val);
                queue.add(t.left);
                queue.add(t.right);
            }
        }
        return ret;
    }

    public ArrayList<Integer> PrintFromTopToBottom2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ret = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
                TreeNode t = queue.poll();
                if (t != null) {
                    ret.add(t.val);
                    queue.add(t.left);
                    queue.add(t.right);
            }
        }
        return ret;

    }

    public static void main(String[] args) {
        PrintFromTopToBottom pf=new PrintFromTopToBottom();
        ArrayList<Integer> ret=new ArrayList<Integer>();
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
        TreeNode t8=new TreeNode(8);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        t6.left=t8;

        ret=pf.PrintFromTopToBottom2(t1);
        for(int i=0;i<ret.size();i++){
            System.out.println(ret.get(i));
        }
    }
}
