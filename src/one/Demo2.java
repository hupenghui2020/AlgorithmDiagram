package one;

/**
 * 计算阶乘的递归函数
 * 递归诀窍：找出基线条件和递归条件，以递归条件递归，以基线条件结束
 * @author hph
 */
public class Demo2 {
    public static void main(String[] args) {

        long n = doIt(9);
        System.out.println(n);
    }

    private static long doIt(int i) {

        // i > 0 为递归条件，反之为基线条件
        return i > 0 ? i * doIt(--i) : 1;
    }
}
