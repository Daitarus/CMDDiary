package com.daitarus;

import java.util.Scanner;

public abstract class LayoutMenu {
    protected String[] systemMess;

    protected void writeSM(){
        systemMess = new String[0];
    }

    protected final int menu()
    {
        Scanner in = new Scanner(System.in);
        boolean o = true; int ans = 0;
        int amount = systemMess.length;
        for (int i = 1; i < amount; i++) {
            System.out.println(systemMess[i]);
        }
        do {
            o = true;
            if(in.hasNextInt()){
                ans = in.nextInt();
            }
            else{
                in.nextLine();
                ans = 0;
            }
            if (!((ans >= 1) & (ans <= amount))) {
                o = false;
            }
            if (!o) {
                System.out.println(systemMess[0]);
            }
        } while(!o);
        return ans;
    }
    protected void exit()
    {
        System.exit(0);
    }
}
