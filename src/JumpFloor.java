/**
 ��̨��

 ��Ŀ����
 һֻ����һ�ο������� 1 ��̨�ף�Ҳ�������� 2 ���������������һ�� n ����̨���ܹ��ж�����������

 ����˼·
����һ����Ծ�Ľ��������ͨ����ǰ1����ǰ2����������ӵõ�
 * */
public class JumpFloor {

    public int JumpFloor(int n){
        if(n<=2){
            return n;
        }
        int pre2=1;
        int pre1=2;
        int result=0;
        while(n>2){
            result=pre2+pre1;
            pre2=pre1;
            pre1=result;
            n--;
        }
          return result;
    }

    public static void main(String[] args) {
         JumpFloor jf=new JumpFloor();
        System.out.println(jf.JumpFloor(6));
    }
}
