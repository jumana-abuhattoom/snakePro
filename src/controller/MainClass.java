package controller;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import model.Question;
import utils.E_Level;
import view.MainPage;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Mateusz Krawczyk
 * The Main class
 */
public class MainClass extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
	 	importFromJson jsc= new importFromJson();
    	jsc.getQuestionFromJson();

			// Controller object, default constructor sets up basic game parameters and the View and Model together
			Controller setUpGame = new Controller();
			// Getting the game stage from controller, which got it from MainView class
			primaryStage = setUpGame.getStage();
			// Stage can't change size
			primaryStage.setResizable(false);
			// Show the stage and actual scenes
			primaryStage.show();
			
//			 MainPage mp = new MainPage(false); 
//			   
//			        mp.show(true);
	}
	
	public static void main(String args[]){ 	
		  launch(args);
	}
}





	    
	


