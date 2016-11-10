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
public class Activity {
    int a_id;
    String a_name;
    int duracao;
    
    int i_day;
    int i_mon;
    int i_hour;
    
    int max;
    int local;
    int score;
    
    String req; // individual ou grupo
    
    boolean finalized;
    ArrayList<Object> participants = new ArrayList<Object>();
    public String dateindex(){
        return i_mon+""+i_day;
    }
    public String date(){
        return i_mon+"/"+i_day+" "+i_hour+"h";
    }
}
