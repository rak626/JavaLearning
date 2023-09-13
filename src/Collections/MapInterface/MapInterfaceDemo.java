package Collections.MapInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapInterfaceDemo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("rakesh", 2);
        map.put("ranit", 5);
        map.put("arpan", 4);
        map.put("sanni", 5);
        map.put("sanni", 3);
        map.put("rakesh", 5);

        System.out.println(map);
        //it throws null pointer exception,
//        System.out.println(map.get("abc").getClass());

        System.out.println(map.getOrDefault("abc", 2).getClass());


        Map<Integer, List<Integer>> adj = new HashMap<>();

        adj.computeIfAbsent(1, f -> new ArrayList<>()).add(2);
        adj.computeIfAbsent(1, f -> new ArrayList<>()).add(3);
        adj.computeIfAbsent(1, f -> new ArrayList<>()).add(5);
        adj.computeIfAbsent(2, f-> new ArrayList<>()).add(3);

        System.out.println(adj);

     }
}
