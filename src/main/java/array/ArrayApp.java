package array;

import java.util.Arrays;

public class ArrayApp {
    public static void main(String[] args) {
        final int[] arr = new int[10];
        for (int j : arr) {
            System.out.println(j);
        }
    }

    public static class Array<E> {
        private E[] data;
        private int size;

        public Array(int capacity){
            data = (E[])new Object[capacity];
            size = 0;
        }
    }
}
