package one;


import java.util.Arrays;

/**
 * 选择排序
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
