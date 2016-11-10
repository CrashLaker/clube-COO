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
public class Team {
    int t_id;
    String t_name;
    int score;
    ArrayList<Integer> students = new ArrayList<Integer>();
    ArrayList<Activity> activities = new ArrayList<Activity>();
    public Team(int t_id, String t_name){
        this.t_id = t_id;
        this.t_name = t_name;
        this.score = 0;
        //if (Prompt.dbg) System.out.println("Team added: "+this);
        Prompt.addLogUsr("Team added: "+this);
    }
    public String toString(){
        return t_name+"["+t_id+"]";
    }
}
