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
public class Class {
    int c_id;
    String c_name;
    ArrayList<Integer> students = new ArrayList<Integer>();
    public Class(int c_id, String c_name){
        this.c_id = c_id;
        this.c_name = c_name;
        if (Prompt.dbg) System.out.println("Class added: "+this);
    }
    public String toString(){
        return c_name+"["+c_id+"]";
    }
}
