package com.daitarus;

import java.util.Scanner;
import java.io.*;

public class Authentication extends LayoutMenu{

    private final String[] systemAMess = new String[] {
            "Что бы вернуться назад введите \"exit\" (логин и пароль не может быть \"exit\")",
            "Введите ваш логин: ",
            "Введите ваш пароль: ",
            "Успешная регистрация!",
            "Ошибка регистрации!",
            "Пользователь с таким логином уже существует!"
    };

    public Authentication()
    {
        int answer = 0;
        writeSM();
        while(answer!=3)
        {
            answer=menu();
            if(answer==1){
                authorization();
            }
            if(answer==2){
                registration();
            }
        }
    }

    @Override
    protected void writeSM(){
        systemMess = new String[]{
                "Ошибка ввода, повторите попытку",
                "1. Авторизация",
                "2. Регистрация",
                "3. Выход"
        };
    }

    private int authorization()
    {
        Scanner in = new Scanner(System.in);
        File dir = new File("Data//Profiles");
        File profile;
        System.out.println(systemAMess[0]);
        System.out.print(systemAMess[1]);
        String login = in.nextLine();
        if (login.equals("exit")) {
            return 0;
        }
        System.out.print(systemAMess[2]);
        String password = in.nextLine();
        if (password.equals("exit")) {
            return 0;
        }
        profile = new File(dir, login);
        if (!profile.exists()) {
            return 1;
        }
        return 0;
    }

    private boolean registration()
    {
        Scanner in = new Scanner(System.in);
        File dir = new File("Data//Profiles");
        File profile;
        System.out.println(systemAMess[0]);
        String login = "0";
        boolean o = true;
        while(o){
            o = false;
            System.out.print(systemAMess[1]);
            login = in.nextLine();
            if (login.equals("exit"))
            {
                return false;
            }
            profile = new File(dir, login);
            if(profile.exists()) {
                o = true;
                System.out.println(systemAMess[5]);
            }
        }
        profile = new File(dir, login);
        System.out.print(systemAMess[2]);
        String password = in.nextLine();
        if (password.equals("exit"))
        {
            return false;
        }
        try {
            boolean cr = profile.createNewFile();
            if(cr) {
                FileWriter writer = new FileWriter(profile, false);
                writer.write("Password: " + password);
                writer.flush();
            }
            System.out.println(systemAMess[3]);
            return true;
        }catch (IOException ex){
            System.out.println(systemAMess[4]);
            return false;
        }

    }
}
