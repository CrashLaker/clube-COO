/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clube;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Random;
/**
 *
 * @author crashlaker
 */
public class Clube {

    ArrayList<Student> students;
    ArrayList<Class> classes;
    ArrayList<Team> teams;
    ArrayList<Room> rooms;
    ArrayList<Activity> activities;
    HashMap<String, ArrayList<Activity>> calendar = new HashMap<String, ArrayList<Activity>>();
    public static int weekBreak;
    //String[] weekdays = {"sundays", "mondays", "tuesdays", "wednesdays", "thursdays", "fridays", "saturdays"};
    String[] weekdays = {"gambiarra", "aos domingos", "as segundas", "as terças", "as quartas", "as quintas", "as sextas", "aos sabados"};
    String[] months = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"};
    public Clube() {
        students = new ArrayList<Student>();
        classes = new ArrayList<Class>();
        teams = new ArrayList<Team>();
        rooms = new ArrayList<Room>();
        activities = new ArrayList<Activity>();
    }
    public int stdCount(){
        return students.size()+1;
    }
    public void addStudent(Student st) {
        students.add(st);
    }

    public void addClass(Class cl) {
        classes.add(cl);
    }

    public void addTeam(Team t) {
        teams.add(t);
    }

    public void addRoom(Room r) {
        rooms.add(r);
    }

    public void addActivity(Activity a) {
        activities.add(a);
        ArrayList<Activity> temp = calendar.get(a.dateindex());
        if (temp != null) {
            temp.add(a);
        } else {
            ArrayList<Activity> temp2 = new ArrayList<Activity>();
            temp2.add(a);
            //System.out.println("adicionado hashmap " + a.dateindex());
            calendar.put(a.dateindex(), temp2);
        }
    }

    public Student getStd(int id) {
        return students.get(id);
    }

    public Activity getAct(int id) {
        return activities.get(id);
    }

    public Team getTeam(int id) {
        return teams.get(id);
    }

    public boolean verConflict(Activity act) {
        for (int i = 0; i < activities.size(); i++) {
            Activity t = activities.get(i);
            if (t.local == act.local
                    && t.i_mon == act.i_mon
                    && t.i_day == act.i_day) {
                if ((t.i_hour == act.i_hour && t.duracao == act.duracao)
                        || (t.i_hour < act.i_hour && t.i_hour + t.duracao > act.i_hour)
                        || (t.i_hour < act.i_hour + act.duracao && t.i_hour + t.duracao > act.i_hour + act.duracao)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String isDayBreak(int month, int day) {
        Calendar calendar = new GregorianCalendar(2016, month, day, 00, 00, 00);
       //SimpleDateFormat sdf = new SimpleDateFormat();
        //System.out.println(sdf.format(calendar.getTime()));
        //System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
        if (calendar.get(Calendar.DAY_OF_WEEK) == 1 || calendar.get(Calendar.DAY_OF_WEEK) == weekBreak
                || calendar.get(Calendar.DAY_OF_WEEK) == 7) {
            return weekdays[calendar.get(Calendar.DAY_OF_WEEK)];
        }
        return "ok";
    }

    public void printCalendar(int month) {
        String incDate;
        Calendar c = new GregorianCalendar(2016, month, 1, 00, 00, 00);
        int maxDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
        System.out.println("Calendário mês de "+months[c.get(Calendar.MONTH)]);
        for (int co = 0; co < maxDay; co++) {
            printDay(month, c.get(Calendar.DAY_OF_MONTH));
            c.add(Calendar.DATE, 1);
        }
    }

    public void printDay(int month, int day) {
        System.out.print("Dia "+day+": ");
        ArrayList<Activity> temp = calendar.get(month+""+day);
        //System.out.println("procurando "+month+""+day);
        if (temp != null){
            System.out.println("Possui "+temp.size()+" atividades:");
            for (int i = 0; i < temp.size(); i++){
                System.out.println(temp.get(i).a_name+" as "+temp.get(i).i_hour+" em "+rooms.get(temp.get(i).local-1));
            }
        }else{
            System.out.println(" não há atividades registradas.");
        }
    }
    public int randInt(int min, int max){
        Random rand = new Random();
        return rand.nextInt((max-min) + 1) + min;
    }
}
