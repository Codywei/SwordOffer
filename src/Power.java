/**
 ��ֵ�������η����ݹ飩

 ��Ŀ����
 ����һ�� double ���͵ĸ����� base �� int ���͵����� exponent���� base �� exponent �η���

 ����˼·
 ����������� x ���� base��n ���� exponent��
 ��Ϊ (x*x)n/2 ����ͨ���ݹ���⣬����ÿ�εݹ� n ����Сһ�룬��������㷨��ʱ�临�Ӷ�Ϊ O(logN)��
 * */
public class Power {
    public double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        boolean isNegative = false;
        //������Ǹ��������ȵ�������ˣ����ø�����־λ���õ���󷵻�ֵ���ж�
        if (exponent < 0) {
            exponent = -exponent;
            isNegative = true;
        }
        double pow = power(base * base, exponent / 2);
        //��Ϊ�����������Ľ���ϳ˸�base
        if (exponent % 2 != 0) {
            pow = pow * base;
        }
        return isNegative ? 1 / pow : pow;

    }

    public static void main(String[] args) {
        Power power=new Power();
        System.out.println(power.power(3.0,-2));

    }
}
