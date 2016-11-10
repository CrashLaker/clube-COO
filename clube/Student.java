/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clube;

import java.util.ArrayList;

/**
 *
 * @author crashlaker
 */
public class Student {
    int s_id;
    String s_name;
    int s_age;
    String s_sexo;
    String s_addr;
    String s_tel;
    //insert into student values(id, nome, idade, endereco, telefone)
    int score;
    ArrayList<Activity> activities = new ArrayList<Activity>();
    public Student(int s_id, String s_name, String s_age, String s_sexo, String s_addr, String s_tel){
        this.s_id = s_id;
        this.s_name = s_name;
        this.s_age = Integer.valueOf(s_age);
        this.s_sexo = s_sexo;
        this.s_addr = s_addr;
        this.s_tel = s_tel;
        this.score = 0;
        //if (Prompt.dbg) System.out.println("Student added: "+this);
        Prompt.addLogUsr("Student added: "+this);
    }
    public String toString(){
        return s_name+"["+ s_id +"]";
    }
    public boolean verConflict(Activity act){
       for(int i = 0; i < activities.size(); i++){
           Activity t = activities.get(i);
           if (t.i_mon == act.i_mon &&
               t.i_day == act.i_day){
               if ((t.i_hour == act.i_hour && t.duracao == act.duracao) || 
                  (t.i_hour < act.i_hour && t.i_hour+t.duracao > act.i_hour) ||
                  (t.i_hour < act.i_hour+act.duracao && t.i_hour+t.duracao > act.i_hour+act.duracao)){
                           return false;
                       }
           }
       }
       return true;
   }
}
