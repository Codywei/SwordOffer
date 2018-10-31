import java.util.ArrayList;
/**
�������к�Ϊĳһֵ��·��
 
 ��Ŀ����
 ����һ�Ŷ�������һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����
 ��ͼ�Ķ�������������Ϊ 22 ��·����10, 5, 7 �� 10, 12
 * */
public class FindequalsumPath {
    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backtracking(root, target, new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode node, int target, ArrayList<Integer> path) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target -= node.val;
        if (target == 0 && node.left == null && node.right == null) {
            ret.add(new ArrayList<>(path));
        } else {
            backtracking(node.left, target, path);
            backtracking(node.right, target, path);
        }
        //��ӣ���������ǰ�ڵ�����
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {

    }
}
