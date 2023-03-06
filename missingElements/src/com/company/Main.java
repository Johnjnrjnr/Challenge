package com.company;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[][] arrays = {{"elem1", "elem2", "elem3"}, {"elem1", "elem2", "elem3", "elem4", "elem5", "elem6", "elem7"}, {"elem2", "elem3"}};
        Map<String, Integer> elementCount = new HashMap<>();

        for (String[] array : arrays) {
            for (String element : array) {
                if (elementCount.containsKey(element)) {
                    elementCount.put(element, elementCount.get(element) + 1);
                } else {
                    elementCount.put(element, 1);
                }
            }
        }

        List<String> notInEveryArray = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : elementCount.entrySet()) {
            if (entry.getValue() != arrays.length) {
                notInEveryArray.add(entry.getKey());
            }
        }

        System.out.println("Elements not in every array:");
        for (String element : notInEveryArray) {
            System.out.println(element);
        }
    }
}
