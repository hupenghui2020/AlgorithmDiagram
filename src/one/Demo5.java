package one;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 快速排序
 * @author hph
 */
public class Demo5 {

    public static void main(String[] args) {
        Integer[] a = {15,4,8,1,45,81,486,13};

        String b = new Demo5().doIt(a);

        System.out.println(b);
    }

    private String doIt(Integer[] a) {

        // 递归条件
        if(a.length > 1){
            int base = a[0];
            // 小于base的数
            Integer[] less = getLess(a, base);
            // 大于base的数
            Integer[] greater = getGreater(a, base);
            return doIt(less) + "[" +base + "]" + doIt(greater);
        }

        // 基线条件
        return a.length ==0 ? "" : Arrays.toString(a);
    }

    private Integer[] getGreater(Integer[] a, int base) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 1; i < a.length; i++){
            if(base < a[i]){
                arrayList.add(a[i]);
            }
        }
        return arrayList.toArray(new Integer[0]);
    }

    private Integer[] getLess(Integer[] a, int base) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 1; i < a.length; i++){
            if(base > a[i]){
                arrayList.add(a[i]);
            }
        }
        return arrayList.toArray(new Integer[0]);
    }
}
