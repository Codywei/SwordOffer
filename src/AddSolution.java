/**
 ���üӼ��˳����ӷ�

 ��Ŀ����
 дһ������������������֮�ͣ�Ҫ�󲻵�ʹ�� +��-��*��/ ����������š�

 ����˼·
 a ^ b ��ʾû�п��ǽ�λ������������ĺͣ�(a & b) << 1 ���ǽ�λ��
 �ݹ����ֹ��ԭ���� (a & b) << 1 ���ұ߻��һ�� 0����ô�����ݹ飬��λ���ұߵ� 0 ���������࣬����λ���Ϊ 0���ݹ���ֹ��
 * */
public class AddSolution {
    public int Add(int a, int b) {
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        AddSolution as=new AddSolution();
        System.out.println(as.Add(7,8));
    }
}
