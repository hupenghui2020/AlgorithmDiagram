package one;


import java.util.Arrays;

/**
 * 选择排序
 * 思路：用第一个与后面的的对比，大于第一个的话对换，并继续，找出最小的那个
 * 用第二个与后面的对比，大于第二个的话对换，并继续，再找出最小的那个
 * 。。。。一直这样下去
 * @author hph
 */
public class Demo1 {

    public static void main(String[] args) {

        int[] ints = {45,15,4,346,9,8,0,7,62};

        diIt(ints);

        System.out.println(Arrays.toString(ints));
    }

    private static void diIt(int[] ints) {

        for(int i = 0 ; i < ints.length ; i++){

            for(int j = i + 1 ; j < ints.length ; j++){

                if(ints[i] > ints[j]){

                    int a = ints[i];

                    ints[i] = ints[j];

                    ints[j] = a;
                }
            }
        }
    }
}
