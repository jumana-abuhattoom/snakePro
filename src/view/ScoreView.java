package view;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class ScoreView {
	
	private StackPane stack; 
	private Label l1, l2, l3, l4,l5,l6;
	/**
	 * Height of score panel
	 */
	public static final int SCORE_HEIGHT = 50;
	/**
	 * Color of score label
	 */
	private final Color scoreColor = Color.GREEN;
	/**
	 * Color of the score panel
	 */
	private final Color scoreFieldColor = Color.rgb(31, 58, 0);
	
	public ScoreView() {
		
		stack = new StackPane();
		stack.setStyle("-fx-background-color: "+MainView.SCENE_COLOR);
		Rectangle r = new Rectangle(MainView.WIDTH, SCORE_HEIGHT);
	    r.setFill(scoreFieldColor);
	    
	    // triangles on the sides
//	    double x = (double)MainView.WIDTH;
//	    double y = (double)SCORE_HEIGHT;
//	    double z = (double)MainView.HEIGHT;
//	    
//	    Polygon t1 = new Polygon();
//        t1.getPoints().addAll(new Double[]{
//            0.0, y+z,
//            y, y+z,
//            y, z });
//        
//        Polygon t2 = new Polygon();
//        t2.getPoints().addAll(new Double[]{
//            x, y+z,
//            x-y, y+z,
//            x-y, z });
//	    
//	    t1.setFill(scoreFieldColor);
//	    t2.setFill(scoreFieldColor);
        
	    // setting the labels
		l1 = new Label("SCORE: ");
		l1.setFont(new Font(25));
		l1.setTextFill(scoreColor);
	
		l2 = new Label("0");
		l2.setFont(new Font(25));
		l2.setTextFill(scoreColor);
		
		l5=new Label("LIFE: ");
		l5.setFont(new Font(25));
		l5.setTextFill(scoreColor);
	
		
		l6 = new Label("3");
		l6.setFont(new Font(25));
		l6.setTextFill(scoreColor);
		
		l3 = new Label("Press SPACE to Pause");
		l3.setFont(new Font(13));
		l3.setTextFill(scoreColor);
		
		l4 = new Label("Press ESC to Exit");
		l4.setFont(new Font(13));
		l4.setTextFill(scoreColor);
		
		//stack.getChildren().addAll(r, t1, t2, l1, l2, l3, l4,l5,l6);
		stack.getChildren().addAll(r, l1, l2, l3, l4,l5,l6);		

//		stack.getChildren().get(1).setTranslateX(-(r.getWidth()/2+SCORE_HEIGHT/2));
//		stack.getChildren().get(2).setTranslateX(r.getWidth()/2+SCORE_HEIGHT/2);
		stack.getChildren().get(1).setTranslateX(-100);
		stack.getChildren().get(2).setTranslateX(-30);
		stack.getChildren().get(5).setTranslateX(75);
		stack.getChildren().get(6).setTranslateX(125);
		stack.getChildren().get(3).setTranslateX(200);		
		stack.getChildren().get(3).setTranslateY(15);		
		stack.getChildren().get(4).setTranslateX(-200);		
		stack.getChildren().get(4).setTranslateY(15);
	}
	
	/**
	 * Gets the actual score and displays it on the scene
	 * @param score in game
	 */
	public void addScore(int score) {
		l2.setText(Integer.toString(score));
	}
	/**
	 * Gets the actual life and displays it on the scene
	 * @param life in game
	 */
	public void addLife(int life) {
		l6.setText(Integer.toString(life));
	}
	/**
	 * Returns the stack that holds all elements to be displayed on the score panel
	 * @return the stack
	 */
	public StackPane getStack() {
		return stack;
	}	
}