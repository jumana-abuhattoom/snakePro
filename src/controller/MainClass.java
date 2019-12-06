package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import view.MainPage;

public class MainClass extends Application  {
    
	    @Override
	    public void start(Stage primaryStage) {
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


