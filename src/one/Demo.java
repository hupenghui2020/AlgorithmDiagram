package one;

/**
 * 二分法
 * @author hph
 */
public class Demo {
    public static void main(String[] args) {

        int[] ints = {1,5,8,12,15,48,55,96};
        int n = 15;
        int start = 0;
        int end = ints.length - 1;
        System.out.println( dos(ints, n, start, end));
    }

    /**
     * 递归
     * @param ints
     * @param n
     * @param start
     * @param end
     * @return
     */
    private static int dos(int[] ints, int n, int start, int end) {
        if(start <= end){
            int mid = (start + end) / 2;
            if(ints[mid] == n){
                return mid;
            }else if(ints[mid] > n){
                // mid位置不是的话就往左移一步
                end = mid - 1;
            }else{
                // 往右移一步
                start = mid + 1;
            }
            return dos(ints, n, start, end);
        }
        return -1;
    }
}
