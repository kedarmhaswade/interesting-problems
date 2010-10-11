package org.kedar.probs.jdk;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.kedar.probs.BasicOnes;


/**
 * @author &#2325;&#2375;&#2342;&#2366;&#2352 (km@dev.java.net)
 */
public class MyHashMapTest {
    @Test
    public void sizeTest() {
        MyHashMap<String, Integer> mm = new MyHashMap<String, Integer>(2);
        mm.put("kedar", 1);
        mm.put("deepa", 2);
        mm.put("apoorv", 3);
        mm.put("rujuta", 4);
        mm.put("unknown", 5);
        mm.put("resizer", 6);
        assertEquals(6, mm.size());
    }

    //@Test
    public void many() {
        int hi = 1 << 13;  //8 K
        int lo = 1;
        MyHashMap<Integer, String> map = new MyHashMap<Integer, String>(hi, 1);
        for (int i = lo ; i < hi ; i++) {
            if (map.threshold == 1 + map.size)
                Utils.printStats(map);
            map.put(i, BasicOnes.toEnglish(i));
        }
        System.out.println("FINALLY");
        Utils.printStats(map);
    }

    @Test
    public void testNull() {
        int n = 4;
        MyHashMap<Integer, String> map = new MyHashMap<Integer, String>(n+1, 1);
        for (int i = 0 ; i < n ; i++) {
            map.put(null, i+"");
            map.put(i, i+"");
        }
        System.out.println("Now iterating ...");
        Utils.printMap(map);
    }

    private static class BadKey {
        @Override
        public int hashCode() {
            return 1;
        }
    }
    @Test
    public void badkeyPerformance() {
        int n = 10;
        BadKey [ ]bks = new BadKey[n];
        for (int i = 0 ; i < n ; i++) {
            bks[i] = new BadKey();
        }
        MyHashMap<BadKey, Integer> map = new MyHashMap<BadKey, Integer>(10, 1);
        for (int i = 0 ; i < n ; i++) {
            map.put(bks[i], i);
        }
        Utils.printStats(map);
        System.out.println("bks[0] is a key? " + map.containsKey(bks[0]));
        System.out.println("bks[0] value: "  + map.get(bks[0]));
    }
}
