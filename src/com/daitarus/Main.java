package com.daitarus;


public class Main {

    public static void main(String[] args) {
        Authentication authentication = new Authentication();
        authentication.authentificationAll();
        Diary diary = new Diary(authentication.getLogin());
        diary.diaryAll();
        //change diary

    }
}
