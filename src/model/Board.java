package model;

import java.util.ArrayList;
import java.util.Random;


import controller.Controller;
import controller.sysdata;
import javafx.animation.*;
import javafx.util.Duration;
import utils.Constants;
import utils.E_Level;
import view.MainView;
import view.ScoreView;

public class Board {
	/**
	 * Number of GameObjects to store in X-axis
	 */
	private static final int BWIDTH = MainView.WIDTH / GameObject.SIZE;
	/**
	 * Number of GameObjects to store in Y-axis
	 */
	private static final int BHEIGHT = MainView.HEIGHT / GameObject.SIZE;
	/**
	 * List of fruits
	 */
	private ArrayList<Apple> apples;
	private ArrayList<Banana> bananas;
	private ArrayList<Pear> pears;
	private ArrayList<Question> allQuestions;

	private ArrayList<Question> easyQ; // to hold question in game
	private ArrayList<Question> medeiumQ; // to hold quesiton that have been answered so it wont get repeated
	private ArrayList<Question> hardQ;
	private ArrayList<Integer> lastPlacePear;

	/**
	 * Super fruit object
	 */
	private SuperFruit sFruit;
	/**
	 * List of obstacles
	 */
	private ArrayList<Obstacle> obstacles; // List of obstacles
	/**
	 * Score value
	 */
	private int score, highscore, fruitsEaten, life = 3;
	/**
	 * Snake object
	 */
	private Snake snake;
	/**
	 * Snake's head
	 */
	private BodyPart head;
	/**
	 * Random number for generating points to place objects on them
	 */
	Random rand;
	/**
	 * State of the game
	 */
	private GameState state;
	/**
	 * Object of ScoreView to exchange informations about actual score
	 */
	private ScoreView scoreView;
	/**
	 * Boolean value that tells if it's time to set a new super fruit on the board
	 */
	private boolean isSuper;
	/**
	 * Boolean value that tells if a new obstacle can be added
	 */
	private boolean addObstacle;
	/**
	 * Number of possible obstacles on the field
	 */
	private int obstaclesNumber;

	/**
	 * Boolean value set true if snake is in super mode after eating the super fruit
	 */
	private boolean superState;

	/**
	 * Timers for super fruit and it's effect
	 */
	private Timeline timeSuper, timeSFruit;

	/**
	 * Default constructor of board class to initialize starting variables
	 */
	public Board() {
//++
		allQuestions= new ArrayList<>();
		allQuestions.addAll(sysdata.getInstance().questions); //add all question from sys data to game question arraylist
		
		
		scoreView = new ScoreView();
		apples = new ArrayList<>();
		// ++++
		bananas = new ArrayList<>();
		pears = new ArrayList<>();
		easyQ = new ArrayList<>();
		medeiumQ = new ArrayList<>();
		hardQ = new ArrayList<>();
         lastPlacePear=new ArrayList<>();
		
         obstacles = new ArrayList<>();
		score = fruitsEaten = 0;
		snake = new Snake();
		rand = new Random();
		head = snake.getHead();
		state = GameState.Started;
		sFruit = null;
		isSuper = false;
		superState = true;
		addObstacle = true;
		obstaclesNumber = Obstacle.OBSTACLES_START_NUMBER;

	}

	/**
	 * Method to check if an collision occurred, either of the snake head with it's
	 * body or with an obstacle on the board
	 * 
	 * @return Returns the finished state of game
	 */
	public GameState checkCollision() {

		int headX, headY, helpX, helpY;

		headX = head.getX();
		headY = head.getY();

		// checks if snake hit itself
		for (int i = 1; i < snake.getSize(); ++i) {

			helpX = snake.getBodyPart(i).getX();
			helpY = snake.getBodyPart(i).getY();

			if (helpX == headX && helpY == headY) {
				life -= 1;
				if (life == 0) {
					highscore = score;
					reset();
					return GameState.Finished;
				} else if (life > 0) {
					snake.setSnakePosition();
				}
			}
		}

//		if (!superState) { // check when snake isn't immune - didn't eat super fruit
		
		
		
		// checks if snake hit obstacle
		for (int i = 0; i < obstacles.size(); ++i) {

			helpX = obstacles.get(i).getX();
			helpY = obstacles.get(i).getY();

			if (helpX == headX && helpY == headY) {
				life -= 1;
				if (life == 0) {
					highscore = score;
					reset();
					return GameState.Finished;
				} else if (life > 0) {
					snake.setSnakePosition();
				}
			}
		}
//		}

		return Controller.getState();
	}

	/**
	 * update life of game
	 * 
	 * @return
	 */
	public GameState updateLife() {
		this.life -= 1;
		if (this.life == 0) {
			highscore = score;
			reset();
			return GameState.Finished;
		}
		return Controller.getState();
	}

	
	
	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	/**
	 * Method called in controller to update the state of obstacles in the game
	 */
	public void updateObstacles() {

//		if (fruitsEaten % 10 == 0 && fruitsEaten != 0 && !addObstacle) { // place an obstacle each 10 points
//			addObstacle = true; // Possible to add obstacle, also ensures only one is added
//			obstaclesNumber++; // Now we can have one obstacle more on board
//		}
		while (obstacles.size() < obstaclesNumber && addObstacle) { // placing possible amount of obstacles
			placeObstacles();
		}
	}
	/** 
	  * Looks for a point on the board to add new PEAR. Checks it to not collide
	 * with the snake body/ other fruits/questions
	 */
	private int[] placePear() {
		
		int[] point = new int[2];
		ArrayList<Integer> screenCorners = new ArrayList<Integer>(); // arraylist that contains corners points
		boolean same=true;
		int tmpX, tmpY ;
		

		screenCorners.add(BWIDTH *GameObject.SIZE-50);
		screenCorners.add(GameObject.SIZE+GameObject.SIZE / 2);

		
		while (same) {
			tmpX = screenCorners.get(new Random().nextInt(screenCorners.size()));
			tmpY = screenCorners.get(new Random().nextInt(screenCorners.size()));
			
			if (lastPlacePear.isEmpty()) {
				point[0] = tmpX;
				point[1] = tmpY;
				same = false;
				return point;
			}
			if (lastPlacePear.get(0) == tmpX && lastPlacePear.get(1) == tmpY) {

				same = true;
			}
			
			
			//check collision 
			else {
		lastPlacePear.removeAll(lastPlacePear); 
		same =false;
		point[0] = tmpX;
		point[1] = tmpY;
		return point;}
		}
		return point;
	}
//	/**
//	 * Method to Check that pear
//	 * @param pearX
//	 * @param pearY
//	 * @return
//	 */
//	
//	private boolean pearCheckCollision(int pearX,int pearY) {
//		int  helpX, helpY;
//
//		for (int i = 0; i < snake.getSize(); ++i) { // to not collide with SNAKE
//
//			helpX = snake.getBodyPart(i).getX();
//			helpY = snake.getBodyPart(i).getY();
//			if (helpX == pearX && helpY == pearY) {
//				return true;
//			}
//		}
//		for (int i = 0; i < apples.size(); ++i) { // to not collide with APPLE
//
//			helpX = apples.get(i).getX();
//			helpY = apples.get(i).getY();
//
//			if (helpX == pearX && helpY == pearY) {
//				return true;
//			}
//		}
//
//		for (int i = 0; i < bananas.size(); ++i) { // to not collide with BANANA
//
//			helpX = bananas.get(i).getX();
//			helpY = bananas.get(i).getY();
//
//			if (helpX == pearX && helpY == pearY) {
//				return true;
//			}
//		}
//
//		for (int i = 0; i < easyQ.size(); ++i) { // to not collide with easyQ
//
//			helpX = easyQ.get(i).getX();
//			helpY = easyQ.get(i).getY();
//
//			if (helpX == pearX && helpY == pearY) {
//				return true;
//			}
//		}
//		for (int i = 0; i < medeiumQ.size(); ++i) { // to not collide with mediumQ
//
//			helpX = medeiumQ.get(i).getX();
//			helpY = medeiumQ.get(i).getY();
//
//			if (helpX == pearX && helpY == pearY) {
//				return true;
//			}
//		}
//		for (int i = 0; i < hardQ.size(); ++i) { // to not collide with hardQ
//
//			helpX = hardQ.get(i).getX();
//			helpY = hardQ.get(i).getY();
//
//			if (helpX == pearX && helpY == pearY) {
//				return true;
//			}
//		}
//		for (int i = 0; i < obstacles.size(); ++i) { // to not collide with Obstacles
//
//			helpX = obstacles.get(i).getX();
//			helpY = obstacles.get(i).getY();
//
//			if (helpX == pearX && helpY == pearY) {
//				return true;
//			}
//		}
//
//		return false;
//	}
//	
		
		

	
	/**
	 * Looks for a point on the board to add new obstacle. Checks it to not collide
	 * with the snake body or fruits
	 */
	private void placeObstacles() {

		int obstacleX = 0, obstacleY = 0, helpX, helpY;
		int headX = snake.getHead().getX(), headY = snake.getHead().getY();
		boolean collision = true, helpS, helpF; // helpS if doesn't collide with snake, helpF for fruit

		while (collision) {

			helpS = helpF = false;
			obstacleX = (rand.nextInt(BWIDTH) * GameObject.SIZE) + GameObject.SIZE / 2; // random point on board
			obstacleY = (rand.nextInt(BHEIGHT) * GameObject.SIZE) + GameObject.SIZE / 2;
			for (int i = 0; i < snake.getSize(); ++i) { // to not collide with snake

				helpX = snake.getBodyPart(i).getX();
				helpY = snake.getBodyPart(i).getY();

				// if collides, start while again and generate new point
				if (helpX == obstacleX && helpY == obstacleY) {
					break;
				}

				// leave 4 places in the row in front of head snake, so it doesn't bump up and
				// block the road
				if (obstacleX == headX) {
					if (Math.abs(obstacleY - headY) < 4 * GameObject.SIZE) {
						break;
					}
				} else if (obstacleY == headY) {
					if (Math.abs(obstacleX - headX) < 4 * GameObject.SIZE) {
						break;
					}
				}

				// if doesn't collide with any snake part, go over to check fruits
				if (i == snake.getSize() - 1) {
					helpS = true;
				}
			}

			if (helpS) { // to not collide with fruits

				// if there are no fruits on the field
				if (apples.size() == 0) {
					helpF = true;
				} else {

					for (int i = 0; i < apples.size(); ++i) {

						helpX = apples.get(i).getX();
						helpY = apples.get(i).getY();

						// back to while to generate new point, and check everything again
						if (helpX == obstacleX && helpY == obstacleY) {
							break;
						}

						// doesn't collide with fruits
						if (i == apples.size() - 1) {
							helpF = true;
						}
					}
				}

				// if there's a super fruit on board, check to not collide with it
//				if (isSuper) {
//					if (obstacleX == sFruit.getX() && obstacleY == sFruit.getY()) {
//						continue;
//					}
//				}

				// point for obstacle doesn't collide with any snake part or fruit
				if (helpF) {
					collision = false;
				}
			}
		}
		// add new obstacle
		addObstacle(obstacleX, obstacleY);
	}

	/**
	 * Add new obstacle to array
	 * 
	 * @param X coordinate
	 * @param Y coordinate
	 */
	private void addObstacle(int X, int Y) {
		obstacles.add(new Obstacle(X, Y));
	}

	/**
	 * Method to check if snake ate a fruit
	 */
	public void checkEaten() {

		int headX, headY, foodX, foodY;
		headX = head.getX();
		headY = head.getY();

		// check for a fruit on board //// APPLE  - same for banana 
		for (int i = 0; i < apples.size(); ++i) {

			foodX = apples.get(i).getX();
			foodY = apples.get(i).getY();

			if (foodX == headX && foodY == headY) {

				removeApple(i);
				addLength(); // adds body part to snake
				++fruitsEaten;

				if (superState)
					score += 2;
				else
					score+=Constants.pointsAddedApple;

				new java.util.Timer().schedule(new java.util.TimerTask() {
					@Override
					public void run() {
						// your code here
						updateFruit();
					}
				}, Constants.appleAppearAfterSEC * 1000);
				addObstacle = false;
			}
		}
		
		// check for bananaa on board 
		for (int i = 0; i < bananas.size(); ++i) {

			foodX = bananas.get(i).getX();
			foodY = bananas.get(i).getY();

			if (foodX == headX && foodY == headY) {

				removeBanana(i);
				addLength(); // adds body part to snake
					score+=Constants.pointsAddedBnana;

				new java.util.Timer().schedule(new java.util.TimerTask() {
					@Override
					public void run() {
						// your code here
						updateFruit();
					}
				}, Constants.bnanaAppearAfterSEC * 1000);
				addObstacle = false;
			}
		}
		
		// check for pear on board ++++
		
		for (int i = 0; i < pears.size(); ++i) {

			foodX = pears.get(i).getX();
			foodY = pears.get(i).getY();

			if (foodX == headX && foodY == headY) {
				addLength(); // adds body part to snake
					score+=Constants.pointsAddedPear;
					lastPlacePear.add(0,pears.get(i).getX());
					lastPlacePear.add(1,pears.get(i).getY());
					pears.remove(i);

				new java.util.Timer().schedule(new java.util.TimerTask() {
					@Override
					public void run() {
						// your code here
						updateFruit();
					}
				}, Constants.pearAppearAfterSEC * 1000);
				addObstacle = false;
			}
		}
	// check for EASY QUESTION  on board ++++
		
		for (int i = 0; i < easyQ.size(); ++i) {

			foodX = easyQ.get(i).getX();
			foodY = easyQ.get(i).getY();

			if (foodX == headX && foodY == headY) {

				allQuestions.remove(easyQ.get(i));
				removeEasyQ(i);
				updateFruit();
				//+++++++++ ezed no2att 
				addObstacle = false;
			}
		}
		
		// check for MEDIUM QUESTION  on board ++++
		for (int i = 0; i < medeiumQ.size(); ++i) {

			foodX = medeiumQ.get(i).getX();
			foodY = medeiumQ.get(i).getY();

			if (foodX == headX && foodY == headY) {

				allQuestions.remove(medeiumQ.get(i));
				medeiumQ.remove(i);
				updateFruit();
				//+++++++++ add score and length to snake 
				addObstacle = false;
			}
		}
		// check for HARD QUESTION  on board ++++
		for (int i = 0; i < hardQ.size(); ++i) {

			foodX = hardQ.get(i).getX();
			foodY = hardQ.get(i).getY();

			if (foodX == headX && foodY == headY) {

				allQuestions.remove(hardQ.get(i));
				hardQ.remove(i);
				updateFruit();
				//+++++++++ add score and length to snake 
				addObstacle = false;
			}
		}
		
		
	}
	

	/**
	 * Method for updating fruits on board
	 */
	public void updateFruit() {

		 int foodX = 0, foodY = 0, sFoodX = -1, sFoodY = -1; // foodX, foodY - coordinates for normal fruit, with s for
															// super
		int[] place; // place on board, will hold X and Y

		if (apples.size() <= 0) { // if there's no fruit

			do {
				place = placeFruit();
				foodX = place[0];
				foodY = place[1];
				
			} while (foodX == sFoodX && foodY == sFoodY);

			
			addFruit(foodX, foodY, sFoodX, sFoodY);
		}
		//++++ BANANA 
		if (bananas.size() <= 0) { // if there's no fruit

			do {
				place = placeFruit();
				foodX = place[0];
				foodY = place[1];

			} while (foodX == sFoodX && foodY == sFoodY);

			bananas.add(new Banana(foodX,foodY));
		}
		
		//++++  PEARS 
		
 		if (pears.size() <= 0) { // if there's no fruit

			do {
				place =placePear();
				foodX = place[0];
				foodY = place[1];
				
			} while (foodX == sFoodX && foodY == sFoodY);

			pears.add(new Pear(foodX,foodY));
		}
		//++++ EASY QUESTIONS 
		if (easyQ.size() <= 0) { // after eating easy question generate new one

			do {
				place = placeFruit();
				foodX = place[0];
				foodY = place[1];

			} while (foodX == sFoodX && foodY == sFoodY);
			
			ArrayList <Question> allEasyQ = getArrayBylevel(E_Level.EASY);
			if(allEasyQ.size()>0) {
			int rndIndex = getRandomQuestion(allEasyQ);//get random index
	         Question rndQuestion = allEasyQ.get(rndIndex);  // get random question
	         rndQuestion.setX(foodX);
	         rndQuestion.setY(foodY);
	         easyQ.add(rndQuestion);}
		}
		//++++ MEDIUM QUESTION
		if (medeiumQ.size() <= 0) { // after eating easy question generate new one

			do {
				place = placeFruit();
				foodX = place[0];
				foodY = place[1];

			} while (foodX == sFoodX && foodY == sFoodY);
			
			ArrayList <Question> allMediumQ = getArrayBylevel(E_Level.MEDIUM);
			if(allMediumQ.size()>0) {
			int rndIndex = getRandomQuestion(allMediumQ);//get random index
	         Question rndQuestion = allMediumQ.get(rndIndex);  // get random question
	         rndQuestion.setX(foodX);
	         rndQuestion.setY(foodY);
	         
	         medeiumQ.add(rndQuestion);}
		}
		//++++ MEDIUM QUESTION
		if (hardQ.size() <= 0) { // after eating easy question generate new one

			do {
				place = placeFruit();
				foodX = place[0];
				foodY = place[1];

			} while (foodX == sFoodX && foodY == sFoodY);
			
			ArrayList <Question> allHardQ = getArrayBylevel(E_Level.HARD);
			if(allHardQ.size()>0) {
			int rndIndex = getRandomQuestion(allHardQ);//get random index
	         Question rndQuestion = allHardQ.get(rndIndex);  // get random question
	         rndQuestion.setX(foodX);
	         rndQuestion.setY(foodY);
	         
	         hardQ.add(rndQuestion);}
		}
		
	}
	
	
	
	
	
	/**
	 * method to return all questions according to level
	 * @param level
	 * @return
	 */
	private ArrayList <Question> getArrayBylevel (E_Level level){
		ArrayList <Question> tmp = new ArrayList<>();
		for(int i=0;i<allQuestions.size();i++) {
			if(allQuestions.get(i).getLevel()==level)
				tmp.add(allQuestions.get(i));
		}
		return tmp;
		
	}
	
	
	

	/**
	 * Method to place a fruit on the board
	 * 
	 * @return Returns point(X,Y) on board
	 */
	private int[] placeFruit() {

		int[] point = new int[2];

		int helpX, helpY, foodX = 0, foodY = 0;
		boolean helpS, helpO; // for Snake and Obstacles
		boolean collision = true;

		while (collision) {

			helpS = helpO = false;
			foodX = (rand.nextInt(BWIDTH) * GameObject.SIZE) + GameObject.SIZE / 2;
			foodY = (rand.nextInt(BHEIGHT) * GameObject.SIZE) + GameObject.SIZE / 2;

        //check collision with snake //
			for (int i = 0; i < snake.getSize(); ++i) {

				helpX = snake.getBodyPart(i).getX();
				helpY = snake.getBodyPart(i).getY();

				if (helpX == foodX && helpY == foodY) {
					break;
				}

				if (i == snake.getSize() - 1) {
					helpS = true;
				}
			}

			if (helpS) {

				if (obstacles.size() == 0) {
					helpO = true;
				} else {

					for (int i = 0; i < obstacles.size(); ++i) {

						helpX = obstacles.get(i).getX();
						helpY = obstacles.get(i).getY();

						if (foodX == helpX && foodY == helpY) {
							break;
						}

						if (i == obstacles.size() - 1) {
							helpO = true;
						}
					}
					
				}
				if (helpO) {
					collision = false;
				}
			}
		}
		point[0] = foodX;
		point[1] = foodY;
		return point;
	}

	/**
	 * Method to generate a new fruit in the game(2 if it's time for the
	 * super-fruit)
	 * 
	 * @param foodX
	 *            X coordinate of normal fruit
	 * @param foodY
	 *            Y coordinate of normal fruit
	 * @param sFoodX
	 *            X coordinate of super fruit(-1 by default)
	 * @param sFoodY
	 *            Y coordinate of super fruit(-1 by default)
	 */
	public void addFruit(int foodX, int foodY, int sFoodX, int sFoodY) {

		if (sFoodX != -1 && sFoodY != -1) { // check if a super fruits is added
			sFruit = new SuperFruit(sFoodX, sFoodY); // create new super fruit
			timeSFruit = new Timeline(
					new KeyFrame(Duration.millis(SuperFruit.ON_BOARD_TIME), lambda -> removeSuperFruit()));
			timeSFruit.play();
		}
		apples.add(new Apple(foodX, foodY)); // add new fruit to fruit array
	}

	/**
	 * Method to remove a normal fruit from the board, after being eaten by snake
	 * 
	 * @param i
	 *            Position of the fruit in array list
	 */
	public void removeApple(int i) {
		apples.remove(i);
	}

	// same for banaanaa++++++++

	private void removeBanana(int i) {
		// TODO Auto-generated method stub
		bananas.remove(i);
		
	}

	private void removePear(int i) {
		// TODO Auto-generated method stub
		pears.remove(i);
		
	}
	
	private void removeEasyQ(int i) {
		// TODO Auto-generated method stub
		easyQ.remove(i);
		
		
	}



	/**
	 * Method to remove super fruit(make it a null value)
	 */
	public void removeSuperFruit() {
		isSuper = false;
		sFruit = null;
	}

	/**
	 * Method for calling another method from ScoreView to add a point to the score
	 */
	public void updateScore() {
		scoreView.addScore(score);
	}

	/**
	 * Method for calling another method from ScoreView to update
	 */
	public void updateLifeONview() {
		scoreView.addLife(life);
	}

	/**
	 * Add new part to snake's body after eating a fruit
	 */
	public void addLength() {
		BodyPart b1 = snake.getBodyPart(snake.getSize() - 1), b2 = snake.getBodyPart(snake.getSize() - 2);
		if (b1.getX() > b2.getX())
			snake.addBodyPart(b1.getX() + GameObject.SIZE, b1.getY());
		else if (b1.getX() < b2.getX())
			snake.addBodyPart(b1.getX() - GameObject.SIZE, b1.getY());
		else if (b1.getY() >= b2.getY())
			snake.addBodyPart(b1.getX(), b1.getY() + GameObject.SIZE);
		else if (b1.getY() >= b2.getY())
			snake.addBodyPart(b1.getX(), b1.getY() - GameObject.SIZE);
	}

	/**
	 * Resets basic values of the game after lose
	 */
	private void reset() {
		snake.setStart();
		obstacles.clear();
		apples.clear();
		//+++
		bananas.clear();
		score = fruitsEaten = 0;
		addObstacle = true;
		superState = false;
		life=3;
		removeSuperFruit();
		obstaclesNumber = Obstacle.OBSTACLES_START_NUMBER;
	}

	/**
	 * Returns fruits
	 * 
	 * @return Array with fruits
	 */
	public ArrayList<Apple> getApples() {
		return apples;
	}

	// +++++
	public ArrayList<Banana> getBananas() {
		return bananas;
	}

	public ArrayList<Pear> getPears() {
		return pears;
	}

	public ArrayList<Question> getEasyQ() {
		return easyQ;
	}
	
	public ArrayList<Question> getMediumQ() {
		return medeiumQ;
	}
	
	public ArrayList<Question> getHardQ() {
		return hardQ;
	}

	/**
	 * Returns the super fruit
	 * 
	 * @return Super fruit object
	 */
	public SuperFruit getSuperFruit() {
		return sFruit;
	}

	/**
	 * Returns obstacles
	 * 
	 * @return Array with obstacles
	 */
	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	/**
	 * Returns the snake
	 * 
	 * @return Snake object
	 */
	public Snake getSnake() {
		return snake;
	}

	/**
	 * Returns the object representing ScoreView in Board class
	 * 
	 * @return The ScoreView object
	 */
	public ScoreView getScoreView() {
		return scoreView;
	}

	/**
	 * Returns the actual score
	 * 
	 * @return Value of score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Returns the highscore when game finished
	 * 
	 * @return Value of final score
	 */
	public int getHighScore() {
		return highscore;
	}

	/**
	 * Returns the actual state of the game
	 * 
	 * @return Value of GameState
	 */
	public GameState getState() {
		return state;}
	
	

	/**
	 * Returns true if snake is in super state or false if not
	 * 
	 * @return Boolean true or false
	 */
	public boolean getSuperState() {
		return superState;}
	
	
	
/**++
 * method to get random index for question
 * @param questions
 * @return
 */
		private static int getRandomQuestion(ArrayList<Question> questions){
		    if(!questions.isEmpty()){
		        return new Random().nextInt(questions.size());
	        }
	        else{
		        return 1;}
	    }

}