/**
 ��ӡ�� 1 ������ n λ�������ݣ�
 ��Ŀ����
 �������� n����˳���ӡ���� 1 ������ n λʮ���������������� 3�����ӡ�� 1��2��3 һֱ������ 3 λ���� 999��

 ����˼·
 ���� n ���ܻ�ǳ�����˲���ֱ���� int ��ʾ���֣������� char ������д洢��
 ʹ�û��ݷ��õ����е�����
 */

public class Print1ToMaxOfNDigits {
    public void print1ToMaxOfNDigits(int n) {
        if(n<=0){
            return ;
        }
        char[]number=new char[n];
        print1ToMaxOfNDigits(number,0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            //�ݹ�õ���һλ����
            print1ToMaxOfNDigits(number, digit + 1);
        }
    }


    private void printNumber(char[] number) {
        int index = 0;
        //�����ǰλ�ϵ�����0�����
        while (index < number.length && number[index] == '0') {
            index++;
        }
        while (index < number.length) {
            System.out.print(number[index++]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Print1ToMaxOfNDigits pd=new Print1ToMaxOfNDigits();
        pd.print1ToMaxOfNDigits(2);
    }
}
