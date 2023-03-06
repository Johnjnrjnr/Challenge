package com.company;

public class Main {

    public static void main(String[] args) {
        String[] array = {"elem1", "elem2", "elem3", "elem4", "elem5", "elem6", "elem7"};
        String[][] result = splitArray(array);
        for (String[] arr: result) {
            System.out.print("[");
            for(String x : arr){
                System.out.print(x + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

    private static String[][] splitArray(String[] array){
        int numArrays = (int)Math.ceil(array.length / 3.0);
        String[][] result = new String[numArrays][];

        int index = 0;
        for(int i = 0; i < numArrays; i++){
            int subarrayLength = Math.min(3, array.length - index);
            result[i] = new String[subarrayLength];

            for(int j = 0; j < subarrayLength; j++){
                result[i][j] = array[index++];
            }
        }
        return result;
    }
}
