package one;

import java.util.Arrays;
import java.util.List;

/**
 * 动态规划
 * 解决9.2问题
 * 最大6磅的背包，只能装以下物品，最大的价值是多少？
 * 水（重3磅，价值10）
 * 书（重1磅，价值3）
 * 食物（重2磅，价值9）
 * 夹克（重2磅，价值5）
 * 相机（重1磅，价值6）
 * @author hph
 */
public class Demo9 {

    public static void main(String[] args) {

        doIt();
    }

    private static void doIt() {

        Something[] somethings = {
                new Something("水",3,10),
                new Something("书",1,3),
                new Something("食物",2,9),
                new Something("夹克",2,5),
                new Something("相机",1,6)};
        List<Something> somethingList = Arrays.asList(somethings);

        // 表建模
        int[][] ints = new int[5][6];

        // 每一个物品进行遍历（表往下走）
        for(int i = 0; i < somethingList.size(); i++){

            Something something = somethingList.get(i);
            // 物品的价格
            int cost = something.getCost();
            // 物品的重量
            int weight = something.getWeight();
            // 遍历假设的容量（往右走）
            for(int j = 0;j < 6; j++){

                int capacity = j + 1;
                // 装不下的话容量增大1
                if(weight > capacity){
                    continue;
                }
                // 放第一个物品，直接放
                if(i == 0){
                    ints[i][j] = cost;
                }else{
                    // 放后面的物品
                    // 放进去后还剩多少容量
                    int n = capacity - weight;
                    // 如果剩下还有n的容量，则加上n容量包的物品
                    int m = n > 0 ? n - 1 : j;
                    int newCost = cost + ints[i-1][m];
                    // 与上一方案的价值进行比较哪个更有价值，取最有价值的方案
                    ints[i][j] = Math.max(newCost, ints[i-1][j]);
                }
            }
        }
        System.out.println(ints[4][5]);
    }
}
