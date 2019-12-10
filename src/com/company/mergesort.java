package com.company;


import java.util.Arrays;

public class mergesort {
    private int[] array;
    public mergesort(int[] argument) {
        array = Arrays.copyOf(argument, argument.length);
    }

    public int[] res() {
        return this.array;
    }
    public void merge(int a_left, int a_right, int b_left, int b_right) { //a_right < b_left
        int[] temp = new int[this.array.length];
        for(int i = a_left; i < b_right; i++) {
            temp[i] = this.array[i];
        }
        int t = a_left, left = a_left, right = b_left;
        while(left <= a_right && right <= b_right) {
            //System.out.println(this.array.length);
            if(temp[left] < temp[right]) this.array[t++] = temp[left++];
            else this.array[t++] = temp[right++];
        }

        while(left <= a_right) this.array[t++] = temp[left++];
        while(right <= a_right) this.array[t++] = temp[right++];
    }

    public void sort() {
        for(int size = 2; size < this.array.length * 2; size *= 2) {
            for(int blocks = 0; blocks < (this.array.length + size - 1) / size; blocks++) {
                int a_left = size*blocks;
                int a_right  = a_left + size/2 >= this.array.length ? (this.array.length - 1) : (a_left + size/2 - 1);
                int b_left = a_right + 1;
                int b_right = size*(blocks + 1) - 1 >= this.array.length ? (this.array.length - 1) : (size*(blocks + 1) - 1);
                System.out.println(a_left+","+a_right+","+b_left+","+b_right);
                merge(a_left, a_right, b_left, b_right);
            }
        }
    }


}
