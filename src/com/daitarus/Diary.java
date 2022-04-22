package com.daitarus;

import java.util.Scanner;

public class Diary extends LayoutMenu{

    private String login;
    private final String[] systemAMess = new String[] {
            "Что бы вернуться назад введите \"exit\"",
            "Сегодня: ",
            "Введите дату события: ",
            "Неверный формат даты",
            "Введите событие",
            "Событие успешно добавленно",
            "Ошибка: Событие не добалвено!"
    };
    public Diary(String login){
        this.login=login;
        writeSM();
    }

    public void diaryAll(){
        int answer = 0;
        while(answer!=5)
        {
            if(answer==0) {
                System.out.println(systemAMess[1]+WorkDate.getNowDate());
                answer = menu();
            }
            if(answer==1){
                answer=0;
            }
            if(answer==2){
                addEvent();
                answer=0;
            }
            if(answer==3){
                answer=0;
            }
            if(answer==4){
                answer=0;
            }
            if(answer==5){
                exit();
            }
        }
    }
    @Override
    protected void writeSM(){
        systemMess = new String[]{
                "Ошибка ввода, повторите попытку",
                "1. Посмотреть события на сегодня",
                "2. Добавить событие",
                "3. Удалить событие",
                "4. Редактировать событие",
                "5. Выход"
        };
    }

    private byte addEvent(){
        Scanner in = new Scanner(System.in);
        WorkDate date = new WorkDate();
        System.out.println(systemAMess[0]);
        String dateS;
        while(true){
            System.out.print(systemAMess[2]);
            dateS = in.nextLine();
            if(dateS.equals("exit")){
                return 0;
            }
            if(date.setDate(dateS)){
                break;
            }
            else{
                System.out.println(systemAMess[3]);
            }
        }
        System.out.println(systemAMess[4]);
        System.out.println(systemAMess[0]);
        String event = in.nextLine();
        if(event.equals("exit")){
            return 0;
        }
        FileWork profile = new FileWork("Data//Profiles//"+this.login+"//"+date.getDate());
        if(profile.createFile()){
            if(profile.write(event)){
                System.out.println(systemAMess[5]);
                return 1;
            }
            else{
                System.out.println(systemAMess[6]);
                return 2;
            }
        }
        else{
            System.out.println(systemAMess[6]);
            return 2;
        }
    }
}
