package com.daitarus;

import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Authentication extends LayoutMenu{

    private final String[] systemAMess = new String[] {
            "Что бы вернуться назад введите \"exit\" (логин и пароль не может быть \"exit\")",
            "Введите ваш логин: ",
            "Введите ваш пароль: ",
            "Успешная регистрация!",
            "Ошибка регистрации!",
            "Пользователь с таким логином уже существует!",
            "Неверный логин или пароль!",
            "Вы успешно вошли"
    };
    private String login;
    private String password;

    public Authentication()
    {
        writeSM();
    }

    public String getLogin() {
        return this.login;
    }
    public String getPassword(){

        return this.password;
    }
    public void authentificationAll()
    {
        int answer = 0; int auth;
        while(answer!=4)
        {
            if(answer==0) {
                answer = menu();
            }
            if(answer==1){
                auth = authorization();
                if(auth==2){
                    System.out.println(systemAMess[7]);
                    answer=4;
                }
                else{
                    if(auth==0){
                        answer=0;
                    }
                    else{
                        System.out.println(systemAMess[6]);
                    }
                }
            }
            if(answer==2){
                registration();
                answer=0;
            }
            if(answer==3){
                exit();
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
        FileWork profile;
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
        profile = new FileWork("Data//Profiles//"+login+"//profile");
        if (!profile.exists()) {
            return 1;
        }else{
            if(password.equals(profile.readLine(0))){
                this.login=login;
                this.password=password;
                return 2;
            }
            else{
                return 1;
            }
        }
    }

    private boolean registration()
    {
        Scanner in = new Scanner(System.in);
        File dirProfile;
        FileWork profile;
        System.out.println(systemAMess[0]);
        String login = null;
        boolean o = true;
        while(o) {
            o = false;
            System.out.print(systemAMess[1]);
            login = in.nextLine();
            if (login.equals("exit")) {
                return false;
            }
            dirProfile = new File("Data//Profiles//" + login);
            if (dirProfile.exists()) {
                o = true;
                System.out.println(systemAMess[5]);
            }
        }
        System.out.print(systemAMess[2]);
        String password = in.nextLine();
        if (password.equals("exit"))
        {
            return false;
        }
        dirProfile = new File("Data//Profiles//"+login);
        if(!dirProfile.mkdirs()){
            return false;
        }
        profile = new FileWork("Data//Profiles//"+login+"//profile");
        if(profile.createFile()){
            if(profile.write(password)){
                System.out.println(systemAMess[3]);
                return true;
            }
            else{
                System.out.println(systemAMess[4]);
                return false;
            }
        }
        else{
            System.out.println(systemAMess[4]);
            return false;
        }
    }
}
