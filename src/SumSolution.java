/**
 �� 1+2+3+...+n

 ��Ŀ����
 Ҫ����ʹ�ó˳�����for��while��if��else��switch��case �ȹؼ��ּ������ж���� A ? B : C��

 ����˼·
 ʹ�õݹ�ⷨ����Ҫ����ָ���������������Ǳ����޷�ֱ��ʹ�� if �����ָ������������
 ������ && ���ж�·ԭ�򣬼��ڵ�һ���������Ϊ false ������²���ȥִ�еڶ���������䡣
 ������һ���ԣ����ݹ�ķ�������ȡ��Ȼ����Ϊ && �ĵ�һ��������䣬�ݹ������ת��Ϊ�ڶ���������䣬��ô���ݹ�ķ�������Ϊ true ������¾Ͳ���ִ�еݹ�����岿�֣��ݹ鷵�ء�
 ����ĵݹ鷵������Ϊ n <= 0��ȡ�Ǻ���� n > 0���ݹ�����岿��Ϊ sum += Sum_Solution(n - 1)��ת��Ϊ����������� (sum += Sum_Solution(n - 1)) > 0��
 * */
public class SumSolution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        SumSolution ss=new SumSolution();
        System.out.println(ss.Sum_Solution(10));
    }
}
