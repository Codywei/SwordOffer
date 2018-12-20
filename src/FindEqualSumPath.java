import java.util.ArrayList;
/**
�������к�Ϊĳһֵ��·��(��������)

 ��Ŀ����
 ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 ��ͼ�Ķ�������������Ϊ 22 ��·����10, 5, 7 �� 10, 12
 * */
public class FindEqualSumPath {

    private ArrayList<ArrayList<Integer>> ret=new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        backtracking(root,target,new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            //����ע�͵��Ǵ����д����������path���������½�һ��ArrayList��,���ֱ�Ӱ�path����ret,֮���path�Ĳ�����ֱ��Ӱ��ret���path��
            ret.add(new ArrayList<>(path));
            //ret.add(path);
        } else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        //��ӣ���������ǰ�ڵ�����
        path.remove(path.size() - 1);

    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(10);
        TreeNode t2=new TreeNode(5);
        TreeNode t3=new TreeNode(12);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(7);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        FindEqualSumPath fp=new FindEqualSumPath();
        ArrayList<ArrayList<Integer>> list=fp.FindPath(t1,22);
        for (int i = 0; i<list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j)+" ");
            }
            System.out.println();

        }

    }
}
