/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clube;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ArrayList;
import dbg.*;
import log.*;
import java.io.PrintWriter;

/**
 *
 * @author crashlaker
 */
public class Prompt {
     /**
     * @param args the command line arguments
     */
    public static Clube clube = new Clube();
    public static boolean dbg = true;
    public static Scanner e;
    public static String[] fIdString(String cmd){
        return cmd.split("\\(")[1].split("\\)")[0].split(", ");
    }
    public static void makeClean(){
        clube = new Clube();
        clube.weekBreak = 3;
        Log.makeClean();
    }
    public static int stdC(){
        return clube.students.size()+1;
    }
    public static int aC(){
        return clube.activities.size();
    }
    public static int rC(){
        return clube.rooms.size();
    }
    public static void save(String nome){
        try{
            PrintWriter writer = new PrintWriter(nome, "UTF-8");
            for (String log : Log.sql){
                writer.println(log);
            }
            writer.println("===");
            for (String log : Log.usr){
                writer.println(log);
            }
    		writer.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static void showLog(){
        for (String log : Log.usr){
            System.out.println(log);
        }
        //addLogUsr("Pedido para mostrar log.");
    }
    public static void usuariosSistemaAntigo(){
        for (int i = 0; i < clube.students.size(); i++){
		 	Student std = clube.students.get(i);
		 	System.out.printf("%s,%d,%s,%s,%s", std.s_name, std.s_age, std.s_sexo, std.s_addr, std.s_tel);
		 	if (i != clube.students.size()-1) System.out.print("|");
		 }
		 System.out.println();
		addLogUsr("Exportar usuarios sitema antigo.");
    }
    public static void addLogUsr(String cmd){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        //System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
        String datef = dateFormat.format(date);
        String log = datef + " " + cmd;
        if (DBG.v) System.out.println(log);
        Log.addUsr(log);
        //log.Log.usr.add(log);
    }
    public static void addLogSql(String cmd){
        if (DBG.v) System.out.println(cmd);
        Log.addSql(cmd);
    }
    public static ArrayList genForm(String b){
        String a[] = b.split(", ");
        ArrayList<String> temp = new ArrayList<String>();
        for (int i = 0; i < a.length; i++)
            temp.add(a[i]);
            
        return temp;
    }
    public static String command(String command){
        if (clube == null){
            clube = new Clube();
            clube.weekBreak = 3;
        }
        addLogSql(command);
        String output = "ok";
        String cmd2[] = command.split(" ", 4);
        if (cmd2[0].equals("insert")){
            String temp1[] = fIdString(cmd2[3]);
            if (cmd2[2].equals("student")){
                // insert into student values(id[0], nome[1], idade[2], sexo[3], endereco[4], telefone[5])
                clube.addStudent(new Student(Integer.valueOf(temp1[0]), temp1[1], temp1[2], temp1[3], temp1[4], temp1[5]));
            }else if (cmd2[2].equals("class")){
                clube.addClass(new Class(Integer.valueOf(temp1[0]), temp1[1]));
            }else if (cmd2[2].equals("team")){
                clube.addTeam(new Team(Integer.valueOf(temp1[0]), temp1[1]));
            }else if (cmd2[2].equals("room")){
                clube.addRoom(new Room(Integer.valueOf(temp1[0]), temp1[1], Integer.valueOf(temp1[2])));
            }else if (cmd2[2].equals("activity")){
                Activity act = new Activity();
                act.a_id = Integer.valueOf(temp1[0]);
                act.a_name = temp1[1];
                act.duracao = Integer.valueOf(temp1[2]);

                String temp2[] = temp1[3].split(":");
                act.i_mon = Integer.valueOf(temp2[0])-1;
                act.i_day = Integer.valueOf(temp2[1]);
                act.i_hour = Integer.valueOf(temp2[2]);

                act.max = Integer.valueOf(temp1[4]);
                act.local = Integer.valueOf(temp1[5]);
                act.req = temp1[6];
                act.score = Integer.valueOf(temp1[7]);

                act.finalized = false;

                String out = clube.isDayBreak(act.i_mon, act.i_day);
                if (!out.equals("ok")){
                    //if (dbg) System.out.println("Clube não abre "+out+"!");
                    output = "Clube não abre "+out+"!";
                    addLogUsr("Tentando inserir atividade n"+out+". Clube não abre!");
                }else if (clube.rooms.size() == 0 || act.local > clube.rooms.size()){
                    //if (dbg) System.out.println("Não há salas disponiveis!");
                    output = "Não há salas disponiveis!";
                    addLogUsr("Tentando inserir atividade mas está lotado");
                }else if (!clube.verConflict(act)){
                    //if (dbg) System.out.println("Há conflito de horários para o mesmo local!");
                    output = "Há conflito de horários para o mesmo local!";
                    addLogUsr("Há conflito de horários para o local que está tentando inserir!");
                }else{
                    if (dbg) System.out.printf("Activity (%s) [%d] created date [%s] at %s req %s\n", act.a_name, act.a_id, act.date(), act.local, act.req);
                    String asdf = String.format("Activity (%s) [%d] created date [%s] at %s req %s\n", act.a_name, act.a_id, act.date(), act.local, act.req);
                    addLogUsr(asdf);
                    clube.addActivity(act);
                }
            }else if (cmd2[2].equals("student-class")){
                int sid = Integer.valueOf(temp1[0])-1;
                int cid = Integer.valueOf(temp1[1])-1;
                if (dbg) System.out.printf("Assigned %s -> %s\n", clube.students.get(sid), clube.classes.get(cid));
                String asdf = String.format("Assigned %s -> %s\n", clube.students.get(sid), clube.classes.get(cid));
                addLogUsr(asdf);
                clube.classes.get(cid).students.add(sid);
            }else if (cmd2[2].equals("student-team")){
                int sid = Integer.valueOf(temp1[0])-1;
                int tid = Integer.valueOf(temp1[1])-1;
                if (dbg) System.out.printf("Assigned %s -> %s\n", clube.students.get(sid), clube.teams.get(tid));
                String asdf = String.format("Assigned %s -> %s\n", clube.students.get(sid), clube.teams.get(tid));
                addLogUsr(asdf);
                clube.teams.get(tid).students.add(sid);
            }else if (cmd2[2].equals("student-activity")){
                int sid = Integer.valueOf(temp1[0])-1;
                int aid = Integer.valueOf(temp1[1])-1;
                Student std = clube.students.get(sid);
                Activity act = clube.activities.get(aid);
                if (!std.verConflict(act)){
                    //System.out.println("Há conflito de horários para o aluno");
                    output = "Há conflito de horários para o aluno";
                    addLogUsr("Tentando inserir aluno em atividade mas há conflito de dados para aluno");
                }
                if (output.equals("ok")){
                    if (dbg) System.out.printf("Assigned %s -> %s\n", clube.students.get(sid), clube.activities.get(aid));
                    String asdf = String.format("Assigned %s -> %s\n", clube.students.get(sid), clube.activities.get(aid));
                    addLogUsr(asdf);
                    clube.activities.get(aid).participants.add(clube.students.get(sid));
                    clube.students.get(sid).activities.add(act);
                }
            }else if (cmd2[2].equals("team-activity")){
                int tid = Integer.valueOf(temp1[0])-1;
                int aid = Integer.valueOf(temp1[1])-1;
                Activity act = clube.getAct(aid);
                Team team = clube.getTeam(tid);
                boolean sim = false;
                for (int i = 0; i < team.students.size(); i++){
                    Student std = clube.getStd(team.students.get(i));
                    if (!std.verConflict(act)){
                        //System.out.println("Há conflito de horários para o aluno");
                        output = "Há conflito de horários para o aluno "+std.s_name+" dentro de time!";
                        addLogUsr(output);
                        sim = true;
                        break;
                    }
                }
                if(!sim){
                    System.out.printf("Team %s -> Atividade %s\n", team.t_name, act.a_name);
                    String asdf = String.format("Team %s -> Atividade %s\n", team.t_name, act.a_name);
                    addLogUsr(asdf);
                    team.activities.add(act);
                    act.participants.add(team);
                }
            }
        } // insert
        else if (cmd2[0].equals("show")){
            if (cmd2[1].equals("score")){
                if (cmd2[2].equals("students")){
                    int fst, snd, trd;
                    int ifst, isnd, itrd;
                    ifst = isnd = itrd = 0;
                    fst = snd = trd = -1;
                    
                    for (int i = 0; i < clube.students.size(); i++){
                        if (fst == -1) {ifst = i; fst = clube.students.get(i).score; continue;}
                        if (snd == -1) {isnd = i; snd = clube.students.get(i).score; continue;}
                        if (trd == -1) {itrd = i; trd = clube.students.get(i).score; continue;}
                        if (clube.students.get(i).score > fst){
                            ifst = i;
                            fst = clube.students.get(i).score;
                        }else if (clube.students.get(i).score > snd){
                            isnd = i;
                            snd = clube.students.get(i).score;
                        }else if (clube.students.get(i).score > trd){
                            itrd = i;
                            trd = clube.students.get(i).score;
                        }
                    }
                    addLogUsr("Pedido para mostrar score estudantes");
                    System.out.println(clube.students.get(ifst)+" "+fst);
                    System.out.println(clube.students.get(isnd)+" "+snd);
                    System.out.println(clube.students.get(itrd)+" "+trd);
                }else if(cmd2[2].equals("teams")){
                    int fst, snd, trd;
                    int ifst, isnd, itrd;
                    ifst = isnd = itrd = 0;
                    fst = snd = trd = -1;
                    
                    for (int i = 0; i < clube.teams.size(); i++){
                        if (fst == -1) {ifst = i; fst = clube.teams.get(i).score; continue;}
                        if (snd == -1) {isnd = i; snd = clube.teams.get(i).score; continue;}
                        if (trd == -1) {itrd = i; trd = clube.teams.get(i).score; continue;}
                        if (clube.teams.get(i).score > fst){
                            ifst = i;
                            fst = clube.teams.get(i).score;
                        }else if (clube.teams.get(i).score > snd){
                            isnd = i;
                            snd = clube.teams.get(i).score;
                        }else if (clube.teams.get(i).score > trd){
                            itrd = i;
                            trd = clube.teams.get(i).score;
                        }
                    }
                    addLogUsr("Pedido para mostrar score times");
                    System.out.println(clube.teams.get(ifst)+" "+fst);
                    System.out.println(clube.teams.get(isnd)+" "+snd);
                    System.out.println(clube.teams.get(itrd)+" "+trd);
                } 
            }else if (cmd2[1].equals("calendar")){
                addLogUsr(String.format("Pedido para mostrar calendário de atividades do mes %s\n", cmd2[2]));
                //System.out.println("Options: Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec");
                HashMap<String, Integer> months = new HashMap<String, Integer>();
                //months.put("Jan", 0);
                //months.put("Feb", 1);
                //months.put("Mar", 2);
                //months.put("Apr", 3);
                //months.put("May", 4);
                //months.put("Jun", 5);
                //months.put("Jul", 6);
                //months.put("Aug", 7);
                //months.put("Sep", 8);
                //months.put("Oct", 9);
                //months.put("Nov", 10);
                //months.put("Dec", 11);
                months.put("jan", 0);
                months.put("feb", 1);
                months.put("mar", 2);
                months.put("apr", 3);
                months.put("may", 4);
                months.put("jun", 5);
                months.put("jul", 6);
                months.put("aug", 7);
                months.put("sep", 8);
                months.put("oct", 9);
                months.put("nov", 10);
                months.put("dec", 11);
                clube.printCalendar(months.get(cmd2[2]));
            }
        } if (cmd2[0].equals("bless")){
            if (cmd2[1].equals("student")){
                int idstudent = clube.randInt(0, clube.students.size()-1);
                int score = clube.randInt(0, 10);
                if (dbg) System.out.printf("Student %s given %d score.\n", clube.students.get(idstudent), score);
                addLogUsr(String.format("Student %s given %d score.\n", clube.students.get(idstudent), score));
                clube.students.get(idstudent).score += score;
            }else if (cmd2[1].equals("team")){
                int idteam = clube.randInt(0, clube.teams.size()-1);
                int score = clube.randInt(0, 10);
                clube.teams.get(idteam).score += score;
                if (dbg) System.out.printf("Team %s given %d score.\n", clube.teams.get(idteam), score);
                addLogUsr(String.format("Team %s given %d score.\n", clube.teams.get(idteam), score));
            }
        }
        return output;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        clube = new Clube();
        clube.weekBreak = 3;
        e = new Scanner(System.in);
        String cmd1, cmd2, cmd3, cmd4;
        String[] temp1, temp2, temp3, temp4;
        while(e.hasNext()){
            cmd1 = e.nextLine();
            String output = command(cmd1);
            System.out.println(output);
        }
    }
}
