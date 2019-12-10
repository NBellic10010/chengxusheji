package com.company;

public class permutation_recursive {
    private int[] a;

    public permutation_recursive(int[] a) {
        this.a = a;
    }

    public void print() {
        for(int i = 0; i < this.a.length; i++) {
            System.out.print(this.a[i] + " ");
        }
        System.out.print("\n");
    }

    public void swap(int x, int y) {
        int temp = this.a[x];
        this.a[x] = this.a[y];
        this.a[y] = temp;
    }

    public void f(int m) {
        if(m == this.a.length - 1) {
            int sum1 = this.a[0] + this.a[1] + this.a[3];
            int sum2 = this.a[0] + this.a[2] + this.a[5];
            int sum3 = this.a[3] + this.a[4] + this.a[5];
            if(sum1 == sum2) {
                if(sum2 == sum3) print();
            }
            //print();
            return;
        }
        for(int i = m; i < this.a.length; i++) {
            swap(i, m);
            f(m+1);
            swap(i, m);
        }
    }

    public static void main(String[] args) {
        permutation_recursive p = new permutation_recursive(new int[]{1,2,3,4,5,6});
        p.f(0);
        p.print();

    }
}
