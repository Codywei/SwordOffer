/**
 �����������ĺ���������У��������������

 ��Ŀ����
 ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ�����������������������������ֶ�������ͬ��
 ���磬��ͼ�Ǻ���������� 1,3,2 ����Ӧ�Ķ�����������������ָ���Ƕ���������������ƽ���������������
 * */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        return verify(sequence,0,sequence.length-1);
    }

    private boolean verify(int[] sequence, int first, int last) {
        //���last��first���ڣ����۴���С�����Խ��ܣ����Է���true
        if (last - first <= 1) {
            return true;
        }
        int rootVal = sequence[last];
        int cutIndex = first;
        //�ҵ��ȵ�ǰ�ڵ��ĵ�һ���ڵ�
        while (cutIndex < last && sequence[cutIndex] <= rootVal) {
            cutIndex++;
        }
        //���֮��Ľڵ���һ���ȵ�ǰ�ڵ�С���ͱ���
        for (int i = cutIndex; i < last; i++){
            if (sequence[i] < rootVal) {
                return false;
            }
        }
        //�ݹ��жϵ�ǰ�ڵ����������
        return verify(sequence, first, cutIndex - 1) && verify(sequence, cutIndex, last - 1);

    }

    public static void main(String[] args) {
        VerifySquenceOfBST vs=new VerifySquenceOfBST();
        int[] sequence={1,3,2};
        System.out.println(vs.VerifySquenceOfBST(sequence));

    }
}
