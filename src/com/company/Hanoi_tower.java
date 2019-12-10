package com.company;

public class Hanoi_tower {
    public void solve(int count, char from, char inter, char to) {
        if(count == 1) {
            System.out.print("Disk 1 from " + from + " to " + to + "\n");
        }else {
            solve(count - 1, from, to, inter);
            System.out.print("Disk " + count + " from " + from + " to " + to + "\n");
            solve(count - 1, inter, from, to);
        }
    }

    public static void main(String[] args) {
        Hanoi_tower h = new Hanoi_tower();
        h.solve(5, 'A', 'B','C');
    }
}
