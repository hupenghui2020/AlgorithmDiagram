package one;

import java.util.Arrays;

/**
 * 根据数组包含的元素创建一个乘法表，即如果数组为 [2,3,7,8,10]，
 * 首先将每个元素都乘以2，再将每个元素乘以3，然后将每一个元素乘以7，以此类推
 * @author hph
 */
public class Demo6 {
    public static void main(String[] args) {

        long[] a = {2,3,7,8,10};

        // 因为下面都是用的a引用，需要保存一份原数据作为后续的乘数
        long[] b = a.clone();
        doIt(a, 0 ,b);
        System.out.println(Arrays.toString(a));
    }

    private static void doIt(long[] a, int i,long[] b) {

        if(i < a.length){
            count(a,b[i]);
            doIt(a, ++i,b);
        }
    }

    private static void count(long[] a, long c) {

        for(int i = 0; i < a.length; i++){
            a[i] = a[i] * c;
        }
    }
}
