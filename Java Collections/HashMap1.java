import java.util.HashMap;
import java.util.Map;

// Hashmap similar to HashTable
// Hashmap is Unsynchronoised with only 1 null key allowed

class HashMap1 {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("vishal", 10);
        map.put("sachin", 30);

        System.out.println("Size of map is:- " + map.size());
        System.out.println(map);
        if (map.containsKey("vishal")) {
            int a = map.get("vishal");
            // System.out.println("a "+ a);

        }

        // HashMap()
        // HashMap(int initialCapacity)
        HashMap<Integer, String> hm1 = new HashMap<>(3);
        hm1.put(1, "one");
        hm1.put(2, "two");
        hm1.put(3, "three");
        hm1.put(5, "value");
        hm1.put(3, "333333");

        System.out.println("Hm1 " + hm1);
        // HashMap(int initialCapacity, float loadFactor)
        HashMap<Integer, String> hm2 = new HashMap<>(5, 0.75f);

        // HashMap(Map map)
        Map<Integer, String> hm3 = new HashMap<>(hm1);

        // Operations on Map :
        // Add
        hm1.put(5, "aa");
        // Remove
        hm1.remove(5); // key
        System.out.println("jj" + hm1.remove(8)); // return null if key not present

        String s = hm1.getOrDefault( 5,"default"); // Returns value for String 
        // Traversel of Map
        for (Map.Entry<Integer, String> e : hm1.entrySet())
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
        for (Integer i : hm1.keySet()  )
            System.out.println("Value :" +i);

            // putIfAbsent(K key, V value);

    }
}