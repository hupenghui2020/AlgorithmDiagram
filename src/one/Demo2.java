package one;

/**
 * 计算阶乘的递归函数
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
