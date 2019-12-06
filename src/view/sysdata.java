/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jumana abuHattoum
 */
public class sysdata {
    //Players ans questions
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
    
    //Ading New Question
    public boolean AddQuestion(String questionNumber,ArrayList<String> answers,int IndexOfCorrectAnswer,int level){ 
        if(questionNumber==null || answers==null || IndexOfCorrectAnswer<1 || IndexOfCorrectAnswer>4 || level <1 || level>3) return false;
        Question q = new Question(questionNumber, answers, IndexOfCorrectAnswer, level); 
        questions.add(q);
        return true;
    }
    
    
}
