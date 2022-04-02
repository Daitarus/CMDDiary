package com.daitarus;
import java.util.Scanner;

public abstract class LayoutMenu {
    protected String[] systemMess;
    protected Scanner in;
    protected int answer;

    protected void writeSM(){
        systemMess = new String[0];
    }

    protected void menu()
    {
        boolean o = true; int ans = 0;
        in = new Scanner(System.in);
        int amount = systemMess.length;
        for (int i = 1; i < amount; i++) {
            System.out.println(systemMess[i]);
        }
        do {
            o = true;
            ans = in.nextInt();
            if (!((ans >= 1) & (ans <= amount))) {
                o = false;
            }
            if (!o) {
                System.out.println(systemMess[0]);
            }
        } while(!o);
        answer = ans;
        in.close();
    }
    protected void exit()
    {
        System.exit(0);
    }
}
