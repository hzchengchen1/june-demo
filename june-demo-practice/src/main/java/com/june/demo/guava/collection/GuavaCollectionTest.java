package com.june.demo.guava.collection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Table;

/**
 * Reference: https://www.yiibai.com/guava/
 *
 * @author think
 */
public class GuavaDemo {

    /**
     * com.google.common.collect.BiMap demo
     * BiMap: confirm with distinct value in map.
     * support for querying map key by inverse function.
     */
    private static void biMapDemo() {
        BiMap<String, Object> biMap = HashBiMap.create();
        biMap.put("a", 1);
        biMap.put("a", 7);
        biMap.put("b", 2);
        biMap.put("c", 3);
        biMap.forcePut("e", 2);
        System.out.println(biMap.toString());
        System.out.println(biMap.inverse());
        System.out.println(biMap.inverse().get(3));
        biMap.put("d", 3);
        System.out.println(biMap.toString());
    }

    /**
     * com.google.common.collect.Table demo
     * <b>Table<rowKey, columnKey, value></b>
     */
    private static void tableDemo() {
        Table<String, Integer, Object> table = HashBasedTable.create();
        table.put("row1", 1, "1.1");
        table.put("row1", 2, "1.2");
        table.put("row2", 1, "2.1");
        table.put("row2", 2, "2.2");
        System.out.println(table);
        System.out.println(table.row("row2"));
        System.out.println(table.rowKeySet());
    }

    public static void main(String[] args) {
        tableDemo();
        biMapDemo();
    }
}
