package com.company;

import org.json.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String jsonstr = "[{\"customer_number\":1002442,\"invoice\":{\"number\":850004111}},{\"customer_number\":1352432,\"invoice\":{\"number\":850002489}},{\"customer_number\":1002442,\"invoice\":{\"number\":850004391}},{\"customer_number\":3944835,\"invoice\":{\"number\":86028494}},]";

        JSONArray jsonArray = new JSONArray(jsonstr);
        JSONArray sortedJsonArray = new JSONArray();
        List list = new ArrayList();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.getJSONObject(i));
        }

        Collections.sort(list, (Comparator<Object>) (o1, o2) -> {
            JSONObject jsonObject1 = (JSONObject) o1;
            JSONObject jsonObject2 = (JSONObject) o2;

            int customerNumber1 = (int) jsonObject1.get("customer_number");
            int customerNumber2 = (int) jsonObject2.get("customer_number");
            int invoiceNumber1 = (int) jsonObject1.getJSONObject("invoice").get("number");
            int invoiceNumber2 = (int) jsonObject2.getJSONObject("invoice").get("number");

            if (customerNumber1 != customerNumber2) {
                return customerNumber1 - customerNumber2;
            } else {
                return invoiceNumber2 - invoiceNumber1;
            }
        });

        for(int i = 0; i < jsonArray.length(); i++) {
            sortedJsonArray.put(list.get(i));
        }
        System.out.println("Sorted JSON Array: " + sortedJsonArray);
    }
}
