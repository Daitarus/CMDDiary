package com.daitarus;

import java.util.Scanner;
import java.io.File;

public class Authentication extends LayoutMenu{
    public Authentication()
    {
       writeSM();
       menu();
       switch(answer){
           case 1:
           {
               authorization();
               break;
           }
           case 2:
           {
               registration();
               menu();
               break;
           }
           case 3:
           {
               exit();
               break;
           }
           default:
               break;
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

    private void authorization()
    {
        //System.out.println("авторизация");
    }

    private void registration()
    {
        in = new Scanner(System.in);
        System.out.print("Что бы вернуться назад введите \"exit\" (логин и пароль не может быть \"exit\")");
        System.out.print("Введите ваш логин: ");
        String login = in.nextLine();
        System.out.println();
        if (login=="exit")
        {
            return;
        }
        System.out.print("Введите ваш пароль: ");
        String password = in.nextLine();
        System.out.println();
        if (password=="exit")
        {
            return;
        }
        //file
        System.out.println("Пользователь " + login + " создан!");
    }
}
