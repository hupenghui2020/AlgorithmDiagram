package one;

/**
 * 递归解决数组元素相加的问题
 */
public class Demo4 {
    public static void main(String[] args) {

        int[] a = {4,8,1,45,78,26,59,4,5,2};
        System.out.println(doIt(a,0));
    }

    private static int doIt(int[] a, int start) {

        // 递归条件走这
        if(start <= a.length - 1){

            return a[start] + doIt(a, start + 1);
        }
        // 基线条件走这
        return 0;
    }
}
