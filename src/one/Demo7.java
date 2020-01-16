package one;

import java.util.*;

/**
 * 狄克斯特拉算法java实现
 * 7.5章
 * @author hph
 */
public class Demo7 {

    public static void main(String[] args) {

        doIt();
    }

    private static void doIt() {

        // 存储图的描述信息
        Map<Node, Map<Node,Integer>> graph = new HashMap<>(4);
        // 节点至start节点的距离
        Map<Node, Integer> costs = new HashMap<>(3);
        // 节点的父节点
        Map<Node, Node> parents = new HashMap<>(3);
        // 初始化容器
        init(graph, costs, parents);
        // 流程逻辑
        todo(graph, costs, parents);
        // 输出最短距离
        Integer beeline = Objects.requireNonNull(costs.entrySet().stream()
                .filter(entry -> "end".equals(entry.getKey().getName())).findFirst().orElse(null)).getValue();

        System.out.println("最短距离：" + beeline);

        Node node = Objects.requireNonNull(parents.entrySet().stream()
                .filter(entry -> "end".equals(entry.getKey().getName())).findFirst().orElse(null)).getKey();

        String shortestRoute = getShortestRoute(parents, node, new StringBuilder(""));

        System.out.println("最短线路：" + shortestRoute.substring(0, shortestRoute.length() - " <--".length()));
    }

    private static String getShortestRoute(Map<Node, Node> parents, Node node, StringBuilder stringBuilder) {

        if(Objects.nonNull(node)){
            stringBuilder.append(node.getName()).append(" <-- ");
            getShortestRoute(parents, parents.get(node), stringBuilder);
        }
        return stringBuilder.toString().trim();
    }

    private static void todo(Map<Node, Map<Node, Integer>> graph, Map<Node, Integer> costs,
                             Map<Node, Node> parents) {
        // 在未处理的节点中找出开销最小的节点
        Node node = findLowestCostNode(costs);
        // 循环在处理所有节点都被处理过后结束
        while(Objects.nonNull(node)){

            Integer cost = costs.get(node);

            Map<Node, Integer> neighbors = graph.get(node);

            // 遍历当前节点所有邻居
            for(Map.Entry<Node, Integer> n : neighbors.entrySet()){

                Integer newCost = cost + n.getValue();

                // 当前邻居节点距离start节点的距离
                Integer nCost  = costs.get(n.getKey());
                // 如果经当前节点前往该邻居更近
                if(nCost > newCost){
                    // 就更新该邻居的开销（距离start节点的距离）
                    costs.put(n.getKey(), newCost);
                    // 同时设置该邻居的父节点设置为当前节点
                    parents.put(n.getKey(), node);
                }
            }
            node = findLowestCostNode(costs);
        }
    }

    private static Node findLowestCostNode(Map<Node, Integer> costs) {

        // 流处理,过滤已被处理的节点，并且在剩下的节点中找出值最小的那个
        Map.Entry<Node, Integer> entry = costs.entrySet().stream()
                .filter(node -> !node.getKey().getProcessed())
                .min(Map.Entry.comparingByValue()).orElse(null);

        if(Objects.nonNull(entry)) {
            entry.getKey().setProcessed(true);
            return entry.getKey();
        }
        return null;
    }

    private static void init(Map<Node, Map<Node,Integer>> graph, Map<Node, Integer> costs, Map<Node, Node> parents) {
        // 定义三个容器
        // 存储图的描述信息
        Map<Node,Integer> startGraph = new HashMap<>(2);
        startGraph.put(new Node("A"), 6);
        startGraph.put(new Node("B"), 2);
        graph.put(new Node("start"), startGraph);

        Map<Node, Integer> aGraph = new HashMap<>(1);
        aGraph.put(new Node("end"), 1);
        graph.put(new Node("A"), aGraph);

        Map<Node, Integer> bGraph = new HashMap<>(2);
        bGraph.put(new Node("A"), 3);
        bGraph.put(new Node("end"), 5);
        graph.put(new Node("B"), bGraph);

        graph.put(new Node("end"), Collections.emptyMap());

        // 节点至start节点的距离
        costs.put(new Node("A"), 6);
        costs.put(new Node("B"), 2);
        costs.put(new Node("end"), Integer.MAX_VALUE);

        // 节点的父节点
        parents.put(new Node("A"), new Node("start"));
        parents.put(new Node("B"), new Node("start"));
        parents.put(new Node("end"), new Node(""));
    }
}
