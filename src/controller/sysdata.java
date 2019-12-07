package controller;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

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
//        Question q = new Question(questionNumber, answers, IndexOfCorrectAnswer, level); 
//        questions.add(q);
        return true;
    }
    public HashSet<Question> getQuestionFromJson(){
        HashSet<Question> q = new HashSet<>();
        JSONParser parser = new JSONParser("/questions.json", null, false);
        try {
       InputStream in = getClass().getResourceAsStream("/questions.json");
       BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

          String line;
        
          while ((line = br.readLine()) != null) {
              sb.append(line);
          }
          
//           JSONObject json = (JSONObject) parser.parse();
           JSONObject json = new JSONObject(sb.toString());
          JSONArray questions = (JSONArray)json.get("questions");
          for (int i = 0; i < questions.length(); ++i) {
          JSONObject rec = questions.getJSONObject(i);
          String question = rec.getString("question");  
          int IndexOfCorrectAnswer = rec.getInt("correct_ans");
          int level = rec.getInt("level");
          String team = rec.getString("team");  
          
          JSONArray answers = (JSONArray)rec.get("answers");
                ArrayList<String> s = new ArrayList<>();
          for (int j = 0; j < answers.length(); ++j) {
           s.add(answers.get(j).toString());
          }
          Question q1 = new Question(question,
        		  team, s,IndexOfCorrectAnswer,  E_Level.EASY);
          this.questions.add(q1);
          System.out.println(this.questions);

          }

      
        } catch(Exception e) {
            e.printStackTrace();
        }
      
        return q;
       }
    public boolean Addquestiontojson(Question q ){
    	this.questions.add(q);
JSONObject jsonObject1 = new JSONObject();
		
		//JSON object and values
JSONArray jsonArray1 = new JSONArray();
for(Question s : this.questions ){
	JSONObject jsonObject = new JSONObject();
	jsonObject.put("question",s.questionNumber);
	JSONArray jsonArray = new JSONArray();
	jsonArray.put(s.answers.get(0));
	jsonArray.put(s.answers.get(1));
	jsonArray.put(s.answers.get(2));
	jsonArray.put(s.answers.get(3));
	jsonObject.put("answers", jsonArray);
	jsonObject.put("correct_ans", s.IndexOfCorrectAnswer);
	jsonObject.put("level",s.level.getLevel() );
	jsonObject.put("team",s.team );
	
	//JSON array and values
	

	
	jsonArray1.put(jsonObject);

}
jsonObject1.put("questions", jsonArray1);

		// writing the JSONObject into a file(info.json)
		try {
			FileWriter fileWriter = new FileWriter("res/questions.json");
			fileWriter.write(jsonObject1.toString());
			fileWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jsonObject1);
		return true;
	}
    
    
}
