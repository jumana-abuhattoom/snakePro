package controller;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JOptionPane;

import org.json.JSONArray;
import org.json.JSONObject;

import jdk.nashorn.internal.parser.JSONParser;
import model.Player;
import model.Question;
import utils.E_Level;


public class sysdata {
    //Players and questions
    public Set<Player> players;
    public Set<Question> questions;
    //singletone's instance 
    private static sysdata instance; 
    private sysdata(){ 
        players = new HashSet<>();
        questions = new HashSet<>();
    }
    // Singletone
   public static sysdata getInstance(){
       if(instance==null){
           instance = new sysdata();
           return instance;
       } else 
           return instance;
   }
    
   //Adding new player 
    public boolean AddPlayer(String name, String password){ 
        for(Player p : players){ 
            if(p.name.equals(name)){ 
                return false; 
            }
        }
        if(name.equals("Admin") || name.equals("admin")) return false; 
        
        players.add(new Player(name, password)); 
        return true; 
    }
    
     public boolean DeletePlayer(String name, String password){ 
        for(Player p : players){ 
            if(p.name.equals(name)){ 
                players.remove(p);
                return true;
            }
        }
        
       
        return false; 
    }
    
//    Adding New Question
    public boolean AddQuestion(String questionNumber,ArrayList<String> answers,int IndexOfCorrectAnswer,int level){ 
        if(questionNumber==null || answers==null || IndexOfCorrectAnswer<1 || IndexOfCorrectAnswer>4 || level <1 || level>3) return false;
        if(questionNumber.charAt(0)!='Q' && questionNumber.charAt(0)!='q') return false;
        Question q = new Question(questionNumber, answers, IndexOfCorrectAnswer, E_Level.getLevelbyNumber(level)); 
     
        // if one of the answers is empty 
        for (String ans : answers) {
			if(ans.equals("")) return false; 
		}
        
        //if two answers are identical:
        
        if(answers.get(0).equals(answers.get(1))
        		|| answers.get(0).equals(answers.get(2))
        				||answers.get(0).equals(answers.get(3))
        						||answers.get(1).equals(answers.get(2))
        								||answers.get(2).equals(answers.get(3))
        									||answers.get(3).equals(answers.get(1))) {
        	return false;
        }
         // duplicate question numbers
        for (Question qq : questions) {
			if(qq.questionNumber.equals(questionNumber)) {
				return false;
			}
		}
        
        
        
        
        questions.add(q);
        return true;
    }
       
    //--------------------------------------------------Helping methods for tests------------------------------------------------
    
    public boolean CheckUsernameAndPassword(String User, String Pass) { 
    	for (Player p : sysdata.getInstance().players) {
			if (p.name.equals(User) && p.password.equals(Pass)) {
				return true;
			}
		}
    	if(User=="Admin" && Pass=="admin11") return true;
    	return false;
    }
    
    
    public boolean UpdatePlayerDetails(String prevUser, String PrevPass, String CurrentUser, String CurrentPass) { 
    	  sysdata.getInstance().DeletePlayer(prevUser,PrevPass); 
          if(sysdata.getInstance().AddPlayer(CurrentUser, CurrentPass )){
             return true; 
          }else { 
              sysdata.getInstance().AddPlayer(prevUser,PrevPass);
              return false;
          }
    }
	public boolean DeleteQuestion(String num) {
		if(num == null ) return false; 
		
		for (Question q : questions) {
			if(q.questionNumber.equals(num)) { 
				questions.remove(q);
				return true;
			}
		}
		return false; 
		
	}
    
    
    
    
    
    
}
