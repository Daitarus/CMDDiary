package com.daitarus;


public class Main {

    public static void main(String[] args) {
        Authentication authentication = new Authentication();
        authentication.authentificationAll();
        System.out.println(authentication.getLogin());
        System.out.println(authentication.getPassword());
    }
}
