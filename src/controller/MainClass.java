package controller;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Question;
import utils.E_Level;
import view.MainPage;

public class MainClass extends Application  {
    
	    @Override
	    public void start(Stage primaryStage) throws Exception {
	    	importFromJson jsc= new importFromJson();
	    //	jsc.ImportQuestions();
	    	
	    	jsc.getQuestionFromJson();
	    	
	    	
	        
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


