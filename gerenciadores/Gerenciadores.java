/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gerenciadores;
import dbg.*;
import clube.*;
import log.*;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
/**
 *
 * @author Crash
 */
class A{}
class T{}
class L{}
class U{}
public class Gerenciadores {

    /**
     * @param args the command line arguments
     */
    public static Scanner sc;
    public static Clube cb;
    public static GerenciadorUsuario gu = new GerenciadorUsuario();
    public static GerenciadorLocal<L> gl = new GerenciadorLocal<L>();
    public static GerenciadorAtividade ga = new GerenciadorAtividade();
    public static GerenciadorCalendario<A, T, L, U> gc = new GerenciadorCalendario<A, T, L, U>();
    public static GerenciamentoClubeJogosInterface gcji = new GerenciamentoClubeJogosInterface();
    public static void main(String[] args){
        System.out.println("Hello World...");
        Prompt.clube.weekBreak = 3;
        sc = new Scanner(System.in);
        /*String supercommand = "insert into room values(1, 0)/insert into room values(2, 0)/insert into activity values(0, Campeonato Tenis de Mesa, 2, 4:22:10, 40, 1, grupo, 5)/insert into activity values(1, Campeonato LOL, 2, 4:22:10, 40, 2, grupo, 5)/insert into student values(1, Crash)/insert into team values(1, Team Avengers)/insert into student-team values(1, 1)/insert into student-activity values(1, 1)/insert into team-activity values(1, 2)";
        supercommand = "insert into room values(1, 0)/insert into activity values(0, Campeonato Tenis de Mesa, 2, 4:19:10, 40, 1, grupo, 5)";
        String[] commands = supercommand.split("/");
        for(String cmd : commands){
            System.out.println(">>> "+ cmd);
            String output = prompt.command(cmd);
            System.out.println(log.Log.popUsr());
        }*/
        
        //GerenciadorUsuario gu = new GerenciadorUsuario();
        
        ArrayList<String> actions = new ArrayList<String>();
        actions.add("adicionar");
        actions.add("cadastrar usuarios antigo");
        actions.add("exporta usuarios antigo");
        actions.add("save");
        actions.add("restore prev");
        actions.add("show log");
        actions.add("exit");
        System.out.println("==============\nList of actions:");
        for (String action : actions){
            System.out.printf(" - %s\n", action);
        }
        boolean skip = false;
        while(sc.hasNext()){
            skip = false;
            String cmd = sc.nextLine();
            if (cmd.equals("exit")) {
                System.out.println("Bye.");
                break;
            }
            else if (cmd.equals("adicionar")) {if (!adicionar()) skip = true;}
            else if (cmd.equals("cadastrar usuarios antigo")) cua();
            else if (cmd.equals("exporta usuarios antigo")) eua();
            else if (cmd.equals("save")) save();
            else if (cmd.equals("restore prev")) restore();
            else if (cmd.equals("show log")) showlog();
            else {
                System.out.println("No actions supported");
                skip = true;
            }
            if (!skip) System.out.println(Log.popUsr());
            System.out.println();
            System.out.println("==============\nList of actions:");
            for (String action : actions){
                System.out.printf(" - %s\n", action);
            }
        }
    }
    
    public static void restore(){
        Prompt.makeClean();
        try{
            System.out.println("Insira nome do arquivo que deseja restaurar:");
            String nomearquivo = sc.nextLine();
            File file = new File("./"+nomearquivo);
			Scanner input = new Scanner(file);
			int first = 1;
			while(input.hasNext()){
			    String line = input.nextLine();
			    if (line.equals("===")) {
			        first = 0;
			        Log.cleanUsr();
			        continue;
			    }
			    if (first == 1){
			        Prompt.command(line);
			    }else{
			        Log.addUsr(line);
			    }
			}
			Prompt.addLogUsr("Restaurando sistema do arquivo "+nomearquivo+"!");
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static boolean adicionar(){
        ArrayList<String> actions = new ArrayList<String>();
        actions.add("usuario");
        //actions.add("time");
        actions.add("sala");
        //actions.add("turma");
        actions.add("atividade");
        actions.add("back");
            System.out.println("    ======\n    List of actions for [adicionar]:");
        for (String action : actions){
            System.out.printf("      - %s\n", action);
        }
        while(sc.hasNext()){
            String cmd = sc.nextLine();
            if (cmd.equals("back")){
                System.out.println("    Leaving adicionar section.");
                return false;
            }
            else if (cmd.equals("usuario")) {
                if (!addusr()){
                    System.out.println("    Falha ao cadastrar novo usuario.");
                }
            }
            else if (cmd.equals("sala")) {
                if (!addsala()){
                    System.out.println("    Falha ao cadastrar nova sala.");
                }
            }
            /*else if (cmd.equals("turma")) {
                if (!addturma()){
                    System.out.println("    Falha ao cadastrar nova turma.");
                }
            }*/
            else if (cmd.equals("atividade")) {
                if (!addact()){
                    System.out.println("    Fala ao cadastrar nova atividade.");
                }
            }else {
                System.out.println("    No action available.");
            }
            System.out.println();
            System.out.println("    ======\n    List of actions for [adicionar]:");
            for (String action : actions){
                System.out.printf("      - %s\n", action);
            }
        }
        return true;
    }
    
            public static boolean addusr(){
                return gu.cadastrarNovoUsuario();
            }
            
            public static boolean addturma(){
                return gc.adicionaTurma(new T());
            }
            
            public static boolean addsala(){
                return gl.cadastrarNovoLocal();
            }
            
            public static boolean addact(){
                return ga.cadastrarAtividade();
            }
    
    public static void cua(){
        System.out.println("Insira localizacao do arquivo:");
        String path = sc.nextLine();
        Path pathFile = Paths.get("./"+path);
        gu.cadastraUsuariosAntigos(pathFile);
    }
    
    public static void eua(){
        gu.exportaUsuariosSistemaAntigo();
    }
    
    public static void save(){
        gcji.salvarEstadoSistema();
    }
    
    public static void showlog(){
        gcji.exibeLog();
    }
}
