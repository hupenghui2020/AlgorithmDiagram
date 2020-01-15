package one;

/**
 * 使用递归解决土地分割的问题
 * @author hph
 */
public class Demo3 {

    public static void main(String[] args) {
        int n = doIt(640, 1680);
        System.out.println(n);
    }

    /**
     * 土地分割
     * @param width 宽
     * @param height 长
     * @return
     */
    private static int doIt(int width, int height) {

        // 递归条件走这
        if(width > 0 && height > width){

            height = width;
            int temp = height;
            width = temp % width;
            return doIt(width, height);
        }
        // 基线条件走这
        return height;
    }
}
