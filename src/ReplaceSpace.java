/**
 �滻�ո��ַ������ַ����飩

 ��Ŀ����
 ��һ���ַ����еĿո��滻�� "%20"��


 ����˼·
 ���ַ���β����������ַ���ʹ���ַ����ĳ��ȵ����滻֮��ĳ��ȡ���Ϊһ���ո�Ҫ�滻�������ַ���%20������˵�������һ���ո�ʱ����Ҫ��β��������������ַ���
 �� P1 ָ���ַ���ԭ����ĩβλ�ã�P2 ָ���ַ������ڵ�ĩβλ�á�P1 �� P2 �Ӻ���ǰ�������� P1 ������һ���ո�ʱ������Ҫ�� P2 ָ���λ��������� 02%��ע��������ģ������������� P1 ָ���ַ���ֵ��
 �Ӻ���ǰ������Ϊ���ڸı� P2 ��ָ�������ʱ������Ӱ�쵽 P1 ����ԭ���ַ��������ݡ�
 * */
public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int P1=str.length()-1;
        //����i���ж�Ҫʹ��P1������str.length()����Ϊ�ַ�����������������
        for(int i=0;i<=P1;i++){
            if(str.charAt(i)==' '){
                str.append("  ");
            }
        }
        int P2=str.length()-1;
        //�ж�ԭ�ַ�������û�����꣬�����ַ����������ɴ���ԭ�ַ������ȣ��о����ж�P2>P1���һЩ��
        while(P2>P1&&P1>=0){
            char c=str.charAt(P1--);
            if(c==' '){
                str.setCharAt(P2--,'0');
                str.setCharAt(P2--,'2');
                str.setCharAt(P2--,'%');
            }else {
                str.setCharAt(P2--, c);
            }
        }
          return str.toString();


}



    public static void main(String[] args) {
        StringBuffer str=new StringBuffer("We Are Happy");
        ReplaceSpace rp=new ReplaceSpace();
        System.out.println(rp.replaceSpace(str));

    }

}
