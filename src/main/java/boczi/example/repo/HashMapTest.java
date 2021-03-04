package boczi.example.repo;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapTest {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        map.put("jama", 1);
        map.put("jama1", 2);
        map.put("jam323a", 10);
        map.put("jamsdfdsfa", 11);


        List<String> results = new ArrayList<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .peek(e->results.add(e.getKey()))
                .collect(Collectors.toList());


        for (String s : results){
            System.out.println(s);
        }

    }
}




