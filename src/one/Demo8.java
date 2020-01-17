package one;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 贪婪算法
 * 最少广播台覆盖的州数
 * 思路:
 * @author hph
 */
public class Demo8 {

    public static void main(String[] args) {

        doIt();
    }

    private static void doIt() {

        // 所有的州
        Set<String> statesNeeded = new HashSet<>();

        // 所有的广播台
        Map<String, Set<String>> stations = new HashMap<>(5);

        init(statesNeeded, stations);
        
        // 处理逻辑
        Set<String> td = todo(statesNeeded, stations);
        System.out.println(td.size());
    }

    private static Set<String> todo(Set<String> statesNeeded, Map<String, Set<String>> stations) {

        Set<String> finalStations = new HashSet<>();

        while(!statesNeeded.isEmpty()){

            Set<String> statesCovered = Collections.emptySet();

            for(Map.Entry<String, Set<String>> stringSetEntry : stations.entrySet()){

                // 当前广播台广播的州与statesNeeded的交集
                Set<String> covered = stringSetEntry.getValue().stream().filter(statesNeeded::contains).collect(Collectors.toSet());

                if(covered.size() > statesCovered.size()){
                    statesCovered = covered;
                    finalStations.add(stringSetEntry.getKey());
                }
                // 剔除已经匹配的州
                Set<String> finalStatesCovered = statesCovered;
                statesNeeded = statesNeeded.stream().filter(sta -> !finalStatesCovered.contains(sta)).collect(Collectors.toSet());
            }
        }
        return finalStations;
    }

    private static void init(Set<String> statesNeeded, Map<String, Set<String>> stations) {

        // 添加州
        String[] strings = {"mt","wa","or","id","nv","ut","ca","az","jx"};
        statesNeeded.addAll(Arrays.asList(strings));

        // 添加广播台
        String[] kone = {"id","nv","ut"};
        stations.put("kone", new HashSet<>(Arrays.asList(kone)));

        String[] ktwo = {"wa","id","mt"};
        stations.put("ktwo", new HashSet<>(Arrays.asList(ktwo)));

        String[] kthree = {"or","nv","ca"};
        stations.put("kthree", new HashSet<>(Arrays.asList(kthree)));

        String[] kfive = {"ca","az"};
        stations.put("kfive", new HashSet<>(Arrays.asList(kfive)));
    }
}
