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
public class Room {
    int r_id;
    String r_name;
    int type; // 0 inside 1 outside
    ArrayList<Activity> activities = new ArrayList<Activity>();
    public Room(int r_id, String r_name, int type){
        this.r_id = r_id;
        this.r_name = r_name;
        this.type = type;
        //if (Prompt.dbg) Prompt.addLogUsr("Room created: "+this);
        Prompt.addLogUsr("Room created: "+this);
    }
    public String toString(){
        return "Room["+r_id+"] type " + ((type==0) ? "inside" : "outside");
    }
    
}
