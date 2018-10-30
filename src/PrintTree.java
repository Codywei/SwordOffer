import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 把二叉树打印成多行

 * */
public class PrintTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode node = queue.poll();
                if (node == null) {
                    continue;
                }
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (list.size() != 0) {
                ret.add(list);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        PrintTree printTree=new PrintTree();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
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
        ret=printTree.Print(t1);
        for (int i = 0; i <ret.size(); i++) {
          for(int j=0;j<ret.get(i).size();j++){
              System.out.print(ret.get(i).get(j));
          }
            System.out.println();

        }

    }
}
