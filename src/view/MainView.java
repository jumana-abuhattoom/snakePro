package view;

import java.util.ArrayList;
import controller.Controller;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.*;

public class MainView {

	/**
	 * Width of the game board
	 */
	public final static int WIDTH = 600;
	/**
	 * Height of the game board
	 */
	public final static int HEIGHT = 600;
	/**
	 * Color of the scene
	 */
	public final static String SCENE_COLOR = "white";
	/**
	 * Snake object
	 */
	private Snake snake;
	/**
	 * Object to hold the actual scene
	 */
	private Scene scene;
	/**
	 * The stage
	 */
	private Stage stage;
	/**
	 * Actual state of the game
	 */
	private GameState state;
	/**
	 * Array to hold fruits passed by board class
	 */
	private ArrayList<Apple> apples;
	private ArrayList<Banana> bananas;
	private ArrayList<Pear> pears;
	private ArrayList<Question> easyQuestions;
	private ArrayList<Question> mediumQuestions;
	private ArrayList<Question> hardQuestions;

	/**
	 * Array of obstacles passed by board class
	 */
	private ArrayList<Obstacle> obstacles;
	/**
	 * Board object
	 */
	private Board board;
	private Group g;
	private Pane canvas;
	private GridPane grid;
	private StackPane stack;
	private Color bodyColor;

	/**
	 * Default constructor initializes the basic variables and objects
	 */
	public MainView() {
		board = new Board();
		snake = board.getSnake();
		apples = board.getApples();
		// +++
		bananas = board.getBananas();
		pears = board.getPears();
		easyQuestions = board.getEasyQ();
		mediumQuestions = board.getMediumQ();
		hardQuestions = board.getHardQ();
		obstacles = board.getObstacles();

		stage = new Stage();
		stage.setTitle("Snake");
		canvas = new Pane();
		canvas.setStyle("-fx-background-color: " + SCENE_COLOR);
		canvas.setStyle(" -fx-background-image: url(/icon/startBackground.jpg)");
		canvas.setPrefSize(WIDTH, HEIGHT);

		stack = new StackPane();
		grid = new GridPane();

		g = new Group();
		scene = new Scene(g, WIDTH - 10, HEIGHT + ScoreView.SCORE_HEIGHT - 10);
		Image img = new Image("/icon/startBackground.jpg");
		scene.setFill(new ImagePattern(img));
		render();
	}

	/**
	 * The render method, that displays the graphics
	 */
	public void render() {

		this.state = Controller.getState(); // get the actual game state
		switch (state) { // checks for actual game state

		case Started: // if game state is Started display the starting screen
			whenStarted();
			break;
		case Running:
			whenRunning(); // if Running show the board, snake, objects, etc.
			break;
		case Paused: // if Paused show the pause screen
			whenPaused();
			break;
		case Finished: // if Finished show the ending game screen and display the score
			whenFinished();
			break;
		default:
			break;
		}
	}

	/**
	 * Method to get the scene
	 * 
	 * @return Returns the actual scene
	 */
	public Scene getScene() {
		return stage.getScene();
	}

	/**
	 * Method to get the stage
	 * 
	 * @return Returns the game stage
	 */
	public Stage getStage() {
		return stage;
	}

	/**
	 * Method for displaying starting screen
	 */
	private void whenStarted() {

		g = new Group();
//		Button backBtn = new Button("Back");
//		backBtn.setPrefSize(100 , 50);
//		backBtn.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 16));
//		backBtn.setTextFill(Color.DARKGREEN);
//		backBtn.setStyle("-fx-font: 16 arial; -fx-base: #b6e7c9;");
//	
//		backBtn.setOnAction(new EventHandler<ActionEvent>() {	
//			@Override
//			public void handle(ActionEvent event) {
//				MainPage2 mp  = new MainPage2(true);
//				mp.setVisible(true);
//			}
//		});
//	
		
		Text largeText = new Text(WIDTH / 2 - 170, HEIGHT / 2 - 30, "Snake Game");
		largeText.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 50));
		Text smallText = new Text(WIDTH / 2 - 130, HEIGHT / 2 + 20, "Press ENTER to play");
		smallText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 25));
		smallText.setFill(Color.DARKGREEN);
		g.getChildren().addAll(smallText, largeText);
		scene.setRoot(g);
		stage.setScene(scene);
	}

	/**
	 * Main render method to display the actual running game
	 */
	private void whenRunning() {

		grid.getChildren().clear(); // clear grid
		canvas.getChildren().clear(); // clear canvas
		stack = board.getScoreView().getStack(); // get the graphic panel created for score
		// sFruit = board.getSuperFruit(); // get the super fruit, to display if not
		// null

		int helpX, helpY, snakeY, snakeX; // variables for loops

		Circle c = new Circle(snake.getHead().getX(), snake.getHead().getY(), GameObject.SIZE / 2);
		c.setFill(SnakeView.HEAD_COLOR);
		canvas.getChildren().add(c);

		bodyColor = SnakeView.BODY_COLOR;

		// snake's body to canvas
		for (int i = 1; i < snake.getSize(); ++i) {
			snakeX = snake.getBodyPart(i).getX();
			snakeY = snake.getBodyPart(i).getY();
			c = new Circle(snakeX, snakeY, GameObject.SIZE / 2);
			c.setFill(bodyColor);
			canvas.getChildren().add(c);
		}
		// loading fruits to canvas
		for (int i = 0; i < apples.size(); ++i) {
			helpX = apples.get(i).getX();
			helpY = apples.get(i).getY();
			c = new Circle(helpX, helpY, GameObject.SIZE * 2 / 3);
			// add photo to apple
			Image img = new Image("/icon/apple.png");
			c.setFill(new ImagePattern(img));
			canvas.getChildren().add(c);

		}
		// ++++++ BANANAAA VIEW

		for (int i = 0; i < bananas.size(); ++i) {
			helpX = bananas.get(i).getX();
			helpY = bananas.get(i).getY();
			c = new Circle(helpX, helpY, GameObject.SIZE * 2 / 3);

			Image img = new Image("/icon/banana.png");
			c.setFill(new ImagePattern(img));

			canvas.getChildren().add(c);
		}

		// +++++++++++++++++ PEARS VIEW
		for (int i = 0; i < pears.size(); ++i) {
			helpX = pears.get(i).getX();
			helpY = pears.get(i).getY();
			c = new Circle(helpX, helpY, GameObject.SIZE * 2 / 3);

			Image img = new Image("/icon/pear.png");
			c.setFill(new ImagePattern(img));

			canvas.getChildren().add(c);

		}
		// +++ EASY QUESTION VIEW
		for (int i = 0; i < easyQuestions.size(); ++i) {
			helpX = easyQuestions.get(i).getX();
			helpY = easyQuestions.get(i).getY();
			c = new Circle(helpX, helpY, GameObject.SIZE / 2);

			Image img = new Image("/icon/easyQ.png");
			c.setFill(new ImagePattern(img));

			canvas.getChildren().add(c);

		}

		// +++ MEDIUM QUESTION VIEW
		for (int i = 0; i < mediumQuestions.size(); ++i) {
			helpX = mediumQuestions.get(i).getX();
			helpY = mediumQuestions.get(i).getY();
			c = new Circle(helpX, helpY, GameObject.SIZE / 2);

			Image img = new Image("/icon/mediumQ.png");
			c.setFill(new ImagePattern(img));

			canvas.getChildren().add(c);

		}

		// +++ HARD QUESTION VIEW
		for (int i = 0; i < hardQuestions.size(); ++i) {
			helpX = hardQuestions.get(i).getX();
			helpY = hardQuestions.get(i).getY();
			c = new Circle(helpX, helpY, GameObject.SIZE / 2);

			Image img = new Image("/icon/hardQ.png");
			c.setFill(new ImagePattern(img));

			canvas.getChildren().add(c);

		}

		// loading obstacles to canvas
		for (int i = 0; i < obstacles.size(); ++i) {
			helpX = obstacles.get(i).getX();
			helpY = obstacles.get(i).getY();
			Rectangle r = new Rectangle(helpX - (GameObject.SIZE / 2), helpY - (GameObject.SIZE / 2), GameObject.SIZE,
					GameObject.SIZE);
			r.setFill(ObstacleView.OBSTACLE_COLOR);
			canvas.getChildren().add(r);
		}

		// adding canvas that holds the game objects, and stack that holds the score
		// display, together
		grid.add(stack, 0, 1);
		grid.add(canvas, 0, 0);
		scene.setRoot(grid);
		stage.setScene(scene);
	}

	/**
	 * Method invoked when game is paused
	 */
	private void whenPaused() {

		g = new Group();

		Text largeText, smallText, t1, t2, t3, t4, t22, t5, t6, t7, t55, t66, t77;

		largeText = new Text(WIDTH / 2 - 190, 50, "Game Paused");
		largeText.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 50));
		smallText = new Text(WIDTH / 2 - 190, 80, "Press SPACE to resume");
		smallText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 30));
		smallText.setFill(Color.DARKGREEN);
		t1 = new Text(WIDTH / 2 - 250, HEIGHT / 2 - 200, "- apple gives 10 points");
		t1.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 13));
		t2 = new Text(WIDTH / 2 - 250, HEIGHT / 2 - 150, "- banana gives 15 points");
		t2.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 13));
		t22 = new Text(WIDTH / 2 - 250, HEIGHT / 2 - 100, "- pear gives 20 points");
		t22.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 13));
		t5 = new Text(WIDTH / 2 - 250, HEIGHT / 2, "- red queastion gives 3 points for correct answer");
		t5.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 13));
		t55 = new Text(WIDTH / 2 - 250, HEIGHT / 2 + 50, "- red queastion decreases 30 points for wrong answer");
		t55.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 13));
		t6 = new Text(WIDTH / 2 - 250, HEIGHT / 2 + 100, "- white queastion gives 1 points for correct answer");
		t6.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 13));
		t66 = new Text(WIDTH / 2 - 250, HEIGHT / 2 + 150, "- white queastion decreases 10 points for wrong answer");
		t66.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 13));
		t7 = new Text(WIDTH / 2 - 250, HEIGHT / 2 + 200, "- yellow queastion gives 2 points for correct answer");
		t7.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 13));
		t77 = new Text(WIDTH / 2 - 250, HEIGHT / 2 + 250, "- yellow queastion decreases 20 points for wrong answer");
		t77.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 13));
		t3 = new Text(WIDTH / 2 - 250, 250, "- inner walls or surrounding game board, hitting them decreases life");
		t3.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 13));
		t4 = new Text(WIDTH / 2 - 250, HEIGHT / 2 + 270, "");
		t4.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 13));

		g.getChildren().addAll(smallText, largeText, t1, t2, t22, t3, t4, t5, t55, t6, t66, t7, t77);
		scene.setRoot(g);
		stage.setScene(scene);
	}

	/**
	 * Shows the finish screen when game is ended
	 */
	private void whenFinished() {

		g = new Group();
		Text largeText = new Text(WIDTH / 2 - 220, HEIGHT / 2 - 80, "Game Over");
		largeText.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 70));
		largeText.setFill(Color.RED);
		Text largeText2 = new Text(WIDTH / 2 - 170, HEIGHT / 2 - 20, "FINAL SCORE: " + board.getHighScore());
		largeText2.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 37));
		Text smallText = new Text(WIDTH / 2 - 160, HEIGHT / 2 + 100, "Press ENTER to replay");
		smallText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 25));
		smallText.setFill(Color.DARKGREEN);
		Text smallText2 = new Text(WIDTH / 2 - 130, HEIGHT / 2 + 130, " or ESCAPE to exit");
		smallText2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.ITALIC, 25));
		smallText2.setFill(Color.DARKGREEN);
		g.getChildren().addAll(smallText, largeText2, smallText2, largeText);
		scene.setRoot(g);
		stage.setScene(scene);
	}

	/**
	 * Method to get, or rather pass the Snake object
	 * 
	 * @return The snake object
	 */
	public Snake getSnake() {
		return snake;
	}

	/**
	 * Method to get, or rather pass the Board object
	 * 
	 * @return Board object
	 */
	public Board getBoard() {
		return board;
	}
}
