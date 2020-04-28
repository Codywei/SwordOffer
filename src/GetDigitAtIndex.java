/**
 ���������е�ĳһλ����(�ַ��������л�)

 ��Ŀ����
 ������ 0123456789101112131415... �ĸ�ʽ���л���һ���ַ����У�������ַ����ĵ� index λ��
 * */
public class    GetDigitAtIndex {
    public int getDigitAtIndex(int index) {
        if(index<0){
            return -1;
        }
        int place=1;
        while(true){
            int amount=getAmountOfPlace(place);
            int totalAmount=amount*place;
            if(index<=totalAmount){
                return getDigitAtIndex(index,place);
            }
            index-=totalAmount;
            place++;
        }

    }

    /**
     * place λ����������ɵ��ַ�������
     * 10, 90, 900, ...
     */
    private int getAmountOfPlace(int place) {
        if(place==1){
            return 10;
        }
        return (int)Math.pow(10,place-1)*9;
    }

    /**
     * place λ������ʼ����
     * 0, 10, 100, ...
     */
    private int getBeginNumberOfPlace(int place) {
        if(place==1){
            return 0;
        }
        return (int)Math.pow(10,place-1);
    }

    /**
     * �� place λ����ɵ��ַ����У��� index ����
     */
    private int getDigitAtIndex(int index, int place) {
        int beginNumber = getBeginNumberOfPlace(place);
        int shiftNumber = index / place;
        String number = (beginNumber + shiftNumber) + "";
        int count = index % place;
        return number.charAt(count) - '0';
    }

    public static void main(String[] args) {
        GetDigitAtIndex gi=new GetDigitAtIndex();
        System.out.println(gi.getDigitAtIndex(29));
    }
}
