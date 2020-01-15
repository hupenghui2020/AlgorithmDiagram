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
    }

    private static void todo(Map<Node, Map<Node, Integer>> graph, Map<Node, Integer> costs,
                             Map<Node, Node> parents) {
        // 在未处理的节点中找出开销最小的节点
        Node node = findLowestCostNode(costs);
    }

    private static Node findLowestCostNode(Map<Node, Integer> costs) {

        
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
