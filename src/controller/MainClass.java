package controller;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Question;
import utils.E_Level;
import view.MainPage;

public class MainClass extends Application  {
    
	    @Override
	    public void start(Stage primaryStage) {
	    	importFromJson jsc= new importFromJson();
	    	jsc.getQuestionFromJson();
	    	ArrayList<String> s = new ArrayList<>();
	    	s.add("ssd");
	    	s.add("ssd1");
	    	s.add("ssd2");
	    	s.add("ssd3");
	        jsc.Addquestiontojson(
	        		new Question("1", s, 1, E_Level.EASY));
	        
	        MainPage mp = new MainPage(false); 
	   
	        mp.show(true);
	    }

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String[] args) {
	        launch(args);
	    }
	    
	}


