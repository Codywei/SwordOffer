/**
 ���л�������������ǰ�������


 ��ʵ�������������ֱ��������л��ͷ����л���������
 * */
public class Serialization {
    private String deserializeStr;

    public String Serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    public TreeNode Deserialize(String str) {
        deserializeStr = str;
        return Deserialize();
    }

    private TreeNode Deserialize() {
        if (deserializeStr.length() == 0) {
            return null;
        }
        int index = deserializeStr.indexOf(" ");

        //���û���ҵ��ո��������node�п���λ�����һλ�����Ժ���û���ո�
        String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
        deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
        if (node.equals("#")) {
            return null;
        }
        int val = Integer.valueOf(node);
        TreeNode t = new TreeNode(val);
        t.left = Deserialize();
        t.right = Deserialize();
        return t;
    }

    private void printtree(TreeNode root){
        if(root!=null){
            System.out.println(root.val);
            printtree(root.left);
            printtree(root.right);
        }

    }

    public static void main(String[] args) {
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;

        Serialization serialization=new Serialization();
        String str=serialization.Serialize(t1);
        System.out.println(str);
        TreeNode t4=serialization.Deserialize(str);
        serialization.printtree(t4);
    }
}
