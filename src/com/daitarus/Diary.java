package com.daitarus;

public class Diary extends LayoutMenu{

    private final String[] systemAMess = new String[] {
            "Что бы вернуться назад введите \"exit\"",
            "Сегодня: "
    };
    public Diary(){
        writeSM();
    }

    public void diaryAll(){
        int answer = 0; int auth;
        while(answer!=5)
        {
            if(answer==0) {
                System.out.println(systemAMess[1] + WorkDate.getDate());
                answer = menu();
            }
            if(answer==1){
                System.out.println(answer);
                answer=0;
            }
            if(answer==2){
                System.out.println(answer);
                answer=0;
            }
            if(answer==3){
                System.out.println(answer);
                answer=0;
            }
            if(answer==4){
                System.out.println(answer);
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
                "1. Посмотреть события",
                "2. Добавить событие",
                "3. Удалить событие",
                "4. Редактировать событие",
                "5. Выход"
        };
    }
}
