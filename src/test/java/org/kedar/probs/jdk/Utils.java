package org.kedar.probs.jdk;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kedar
 * Date: Jul 26, 2009
 * Time: 3:46:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class Utils {
    static void printStats(MyHashMap<?, ?> m) {
        System.out.println("----------------------------------");
        System.out.println("size: " + m.size());
        System.out.println("table.length: " + m.table.length);
        System.out.println("Size of each bucket");
        int index = 0;
        for(MyHashMap.Entry e : m.table) {
            if (e == null) {
                System.out.println("Nothing hashed at index: " + index);
            }
            else {
                System.out.println("hash: " + e.hash + " at index: " + index);
                int chain = 0;
                do {
                    System.out.println("k,v: " + e.key + ", " + e.value);
                    e = e.next;
                    chain++;
                } while (e != null);
                System.out.println("chain length: " + chain);
                if (chain > 1)
                    System.out.println("Got it, we have 2 or more elements in the chain, " + chain);
            }
            index++;
        }
        System.out.println("----------------------------------");
    }
    static void printMap(MyHashMap<?, ?> map) {
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            System.out.println("entry key: " + entry.getKey() + ", value: " + entry.getValue() + ", hashCode: " + entry.hashCode());
        }
    }
}
