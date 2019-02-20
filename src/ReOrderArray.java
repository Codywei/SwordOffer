/**
 调整数组顺序使奇数位于偶数前面（数组）

 题目描述
 需要保证奇数和奇数，偶数和偶数之间的相对位置不变

 解题思路
 数组拷贝（先记录奇数的个数作为下标）
 引用变量也是基本数据类型，在进行方法调用时会对引用变量进行复制。
 */
public class ReOrderArray {
    public void reOrderArray(int[] nums) {
        // 记录奇数个数
        int oddCnt = 0;
        for (int val : nums) {
            if (val % 2 == 1) {
                oddCnt++;
            }
        }
        //复制数组用于遍历
        int[] copy = nums.clone();
        int i = 0, j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1) {
                nums[i++] = num;
            }
            else {
                nums[j++] = num;
            }
        }


/**
 * 底下这个是显示有问题的，本意是想建一个copy空数组，在这个copy数组上调整好元素顺序，再在最后一行nums=copy将新数组copy赋值给nums，但这个
 * nums并不等于main方法中的nums，nums这个引用变量在方法调用的时候复制了一份，所以改方法中的引用变量是无效的(作用域问题)
 * */
//        int cnt=0;
//        for(int val:nums){
//            if(val%2==1){
//                cnt++;
//            }
//        }
//        int[] copy=new int[nums.length];
//        int i=0;
//        int j=cnt;
//        for(int val:nums){
//            if(val%2==1){
//                copy[i++]=val;
//            }else{
//                copy[j++]=val;
//            }
//        }
        //编译器会提示nums这个引用变量被赋值，但并没有被用到
//        nums=Arrays.copyOf(copy,copy.length);
   }

    public static void main(String[] args) {
        ReOrderArray ro=new ReOrderArray();
        int[] nums={1,2,3,4,5,6,7};
        ro.reOrderArray(nums);
        for(int num:nums){
            System.out.println(num);
        }
    }
}
