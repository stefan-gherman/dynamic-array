package com.codecool.dynamicArrayDojo;

import java.util.Arrays;

// put your code here!
public class DynamicIntArray {

    int size;
    private int[] arr;

    public DynamicIntArray(int size) {
        this.size = size;
        arr = new int[size];
    }

    public DynamicIntArray() {
        arr = new int[0];
    }

    public void add(int value) {
        int[] copyArray = arr.clone();
        arr = new int[arr.length + 1];

        for (int i = 0; i< copyArray.length; i++) {
            arr[i] = copyArray[i];
        }
        arr[arr.length - 1] = value;

    }

    public void remove(int value) {
        boolean existent = false;
        int existentIndex = -3;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                existent = true;
                existentIndex = i;
                break;
            }
        }

        if (existent == true) {
            if (existentIndex == arr.length - 1) {
                int[] copyArray = arr.clone();
                arr = new int[arr.length -1];
                for (int i=0; i<copyArray.length-1; i++) {
                    arr[i] = copyArray[i];
                }

            } else if(existentIndex == 0) {
                int[] copyArray = arr.clone();
                arr = new int[arr.length -1];
                int j = 0;
                for (int i=1; i<copyArray.length; i++) {
                    arr[j] = copyArray[i];
                    j++;
                }
            } else {
                int[] copyArray = arr.clone();
                arr = new int[arr.length -1];
                for (int i=0; i<existentIndex; i++) {
                    arr[i] = copyArray[i];
                }
                int j = existentIndex;
                for (int i=existentIndex+1; i<copyArray.length; i++) {
                    arr[j] = copyArray[i];
                    j++;
                }
            }
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public void insert(int index, int value) {

        if (index >= 0) {
            if(index >= arr.length) {
                int[] copyArray = arr.clone();
                arr = new int[arr.length + 1];
                for(int i=0; i<copyArray.length; i++) {
                    arr[i] = copyArray[i];
                }
                arr[copyArray.length] = value;
            } else {
                int[] copyArray = arr.clone();
                arr = new int[arr.length + 1];
                for (int i = 0; i < index; i++) {
                    arr[i] = copyArray[i];
                }
                arr[index] = value;
                int j= index +1;
                for (int i = index; i < copyArray.length; i++) {
                    arr[j] = copyArray[i];
                    j++;
                }
            }
        }
    }

    @Override
    public String toString() {
        String stringRepresentation="";
        for (int i = 0; i< arr.length; i++)
        {
            stringRepresentation  += " " + arr[i];
        }
        return stringRepresentation;
    }
}


