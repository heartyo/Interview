package com.test.jar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
//        HashSet<String> hashSet = new HashSet<>();
//        hashSet.add("1");
//        hashSet.add("2");
//        hashSet.add("1");
//        Iterator<String> iterator = hashSet.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        Collection<String> collection = new ArrayList<>();
        collection.add("10");
        collection.add("11");
        HashSet<String> set = new HashSet<>(collection);

        set.add("1");
        set.add("2");
        set.add("1");
        Iterator<String> iterator2 = set.iterator();

        while (iterator2.hasNext()) {
            System.out.println(iterator2.next()+"我是");
        }
    }
}
