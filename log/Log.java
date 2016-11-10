/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log;

import java.util.ArrayList;

/**
 *
 * @author Crash
 */
public class Log {
    public static Log instance = new Log();
    public static ArrayList<String> sql = new ArrayList<String>();
    public static ArrayList<String> usr = new ArrayList<String>();
    public static Log getInstance(){
        return instance;
    }
    public static void cleanUsr(){
        usr = new ArrayList<String>();
    }
    public static void cleanSql(){
        sql = new ArrayList<String>();
    }
    public static void makeClean(){
        cleanUsr();
        cleanSql();
    }
    public static void showSql(){
        for (String e : sql)
            System.out.println(e);
    }
    public static void showUsr(){
        for (String e : usr)
            System.out.println(e);
    }
    public static void addSql(String cmd){
        sql.add(cmd);
    }
    public static void addUsr(String cmd){
        usr.add(cmd);
    }
    public static String popUsr(){
        return usr.get(usr.size()-1);
    }
}
