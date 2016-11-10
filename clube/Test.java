/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clube;

import java.util.HashMap;

/**
 *
 * @author crashlaker
 */
public class Test {
    public static void main(String args[]){
        String cmd = "values(0, Class 1)";
        System.out.println((cmd.split("("))[1]);
        //System.out.println(cmd.split("(")[1].split(")")[0].split(", ")[0]);
    }
}
