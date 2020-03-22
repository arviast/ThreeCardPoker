import java.util.ArrayList;
import java.util.HashMap;
import java.net.URL;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.text.*;


public class ThreeCardPokerGame extends Application {
	// members
	// ...
	private VBox ruleBox;
	private HBox setOfCard1,setOfCard2, setOfCard3, setOfButtons1,setOfBets1, setOfBets2, setOfButtons2;
	private Text Greeting, pairPlusRule;
	private Button playBtn;
	private BorderPane borderPane;
	private EventHandler<ActionEvent> deal1, play1, play2, fold1, fold2, toTheGame, deal2;
	private EventHandler<MouseEvent> playlist;
	private MenuBar menuBar;
	private Text _message, Amount1, Amount2, TotalWin1, TotalWin2, amountTotalWin1, amountTotalWin2, _player, _player2, _dealer, _ante1, _pp1, _ante2, _pp2;
	private Button btn1, btn2, btn3, btn4, btn5, btn6;
	private ImageView cardPic1, cardPic2, cardPic3, cardPic4, cardPic5, cardPic6, cardPic7, cardPic8, cardPic9;
	private TextField ante1,ante2,pp1,pp2;
	private PauseTransition pauseAfterDeal1 = new PauseTransition(Duration.seconds(2));
	private PauseTransition pauseAfterDeal2 = new PauseTransition(Duration.seconds(2));
	private PauseTransition pauseAfterPlay2 = new PauseTransition(Duration.seconds(6));
	private PauseTransition pauseOfFold1 = new PauseTransition(Duration.seconds(8));
	private PauseTransition pauseOfFold2 = new PauseTransition(Duration.seconds(6));
	private PauseTransition pauseOfFold2_1 = new PauseTransition(Duration.seconds(4));
	HashMap<String, Scene> sceneMap;
	private boolean isNewLook = false;
	private ListView<String> listView;
	private URL resource;
	private Media media;
	private MediaPlayer mediaPlayer1;
	private ObservableList<String> data;
	
	Player playerOne;
	Player playerTwo;
	Dealer theDealer;
	
	// function for 9 cards on the table on the start scene
	// ...
	public void create9cards() {
		cardPic1 = new ImageView("card.png");
		cardPic1.setFitHeight(100);
		cardPic1.setFitWidth(70);
		
		cardPic2 = new ImageView("card.png");
		cardPic2.setFitHeight(100);
		cardPic2.setFitWidth(70);
		
		cardPic3 = new ImageView("card.png");
		cardPic3.setFitHeight(100);
		cardPic3.setFitWidth(70);
		
		setOfCard1 = new HBox(10, cardPic1, cardPic2, cardPic3);
		setOfCard1.setLayoutX(50);
		setOfCard1.setLayoutY(305);
		
		cardPic4 = new ImageView("card.png");
		cardPic4.setFitHeight(100);
		cardPic4.setFitWidth(70);
		
		cardPic5 = new ImageView("card.png");
		cardPic5.setFitHeight(100);
		cardPic5.setFitWidth(70);
		
		cardPic6 = new ImageView("card.png");
		cardPic6.setFitHeight(100);
		cardPic6.setFitWidth(70);
		
		setOfCard2 = new HBox(10, cardPic4, cardPic5, cardPic6);
		setOfCard2.setLayoutX(500);
		setOfCard2.setLayoutY(305);
		
		cardPic7 = new ImageView("card.png");
		cardPic7.setFitHeight(100);
		cardPic7.setFitWidth(70);
		
		cardPic8 = new ImageView("card.png");
		cardPic8.setFitHeight(100);
		cardPic8.setFitWidth(70);
		
		cardPic9 = new ImageView("card.png");
		cardPic9.setFitHeight(100);
		cardPic9.setFitWidth(70);
		
		setOfCard3 = new HBox(10, cardPic7, cardPic8, cardPic9);
		setOfCard3.setLayoutX(260);
		setOfCard3.setLayoutY(60);
	}
	
	// GUI for the player one
	// ...
	public void Player1Create() {
		_player = new Text("PLAYER ONE");
		_player.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		_player.setFill(Color.GREEN);
		_player.setLayoutX(110);
		_player.setLayoutY(290);
				
		btn1 = new Button();
		btn1.setText("Deal");
		btn1.setMinSize(70, 20);
		btn1.setOnAction(deal1);
		
		btn2 = new Button();
		btn2.setDisable(true);
		btn2.setText("Play");
		btn2.setMinSize(70, 20);
		btn2.setOnAction(play1);
		
		btn3 = new Button();
		btn3.setDisable(true);
		btn3.setText("Fold");
		btn3.setMinSize(70, 20);
		btn3.setOnAction(fold1);
		
		setOfButtons1 = new HBox(10, btn1,btn2,btn3);
		setOfButtons1.setLayoutX(50);
		setOfButtons1.setLayoutY(450);
		
		_ante1 = new Text("Put Ante Bet->");
		ante1 = new TextField("0");
		ante1.setPrefSize(50, 20);
		
		_pp1 = new Text("Put PP Bet->");
		pp1 = new TextField("0");
		pp1.setPrefSize(50, 20);
		
		setOfBets1 = new HBox(5, _ante1, ante1, _pp1, pp1);
		setOfBets1.setLayoutX(40);
		setOfBets1.setLayoutY(420);
	}
	
	// gui for the player 2
	// ...
	public void Player2Create() {
		_player2 = new Text("PLAYER TWO");
		_player2.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		_player2.setFill(Color.GREEN);
		_player2.setLayoutX(545);
		_player2.setLayoutY(290);
				
		_ante2 = new Text("Put Ante Bet->");
		ante2 = new TextField("0");
		ante2.setDisable(true);
		ante2.setPrefSize(50, 20);
		
		_pp2 = new Text("Put PP Bet->");
		pp2 = new TextField("0");
		pp2.setDisable(true);
		pp2.setPrefSize(50, 20);
		
		setOfBets2 = new HBox(5, _ante2, ante2, _pp2, pp2);
		setOfBets2.setLayoutX(475);
		setOfBets2.setLayoutY(420);
		
		btn4 = new Button();
		btn4.setDisable(true);
		btn4.setText("Deal");
		btn4.setMinSize(70, 20);
		btn4.setOnAction(deal2);
		
		btn5 = new Button();
		btn5.setDisable(true);
		btn5.setText("Play");
		btn5.setMinSize(70, 20);
		btn5.setOnAction(play2);
		
		btn6 = new Button();
		btn6.setDisable(true);
		btn6.setText("Fold");
		btn6.setMinSize(70, 20);
		
		btn6.setOnAction(fold2);
		
		setOfButtons2 = new HBox(10, btn4,btn5,btn6);
		setOfButtons2.setLayoutX(490);
		setOfButtons2.setLayoutY(450);
	}
	
	// dealer
	public void DealerCreate() {
		_dealer = new Text("Dealer");
		_dealer.setFont(Font.font("Verdana", FontWeight.BOLD, 18));
		_dealer.setFill(Color.GREEN);
		_dealer.setLayoutX(340);
		_dealer.setLayoutY(50);
	}
	
	// setting card pics
	// ...
	public void setCardOption1() {
		Image card1 = new Image("card.png");
		cardPic1.setImage(card1);
		cardPic2.setImage(card1);
		cardPic3.setImage(card1);
		cardPic4.setImage(card1);
		cardPic5.setImage(card1);
		cardPic6.setImage(card1);
		cardPic7.setImage(card1);
		cardPic8.setImage(card1);
		cardPic9.setImage(card1);
	}
	
	// setting card pics for the new look
	// ...
	public void setCardOption2() {
		Image card2 = new Image("card_2.jpeg");
		cardPic1.setImage(card2);
		cardPic2.setImage(card2);
		cardPic3.setImage(card2);
		cardPic4.setImage(card2);
		cardPic5.setImage(card2);
		cardPic6.setImage(card2);
		cardPic7.setImage(card2);
		cardPic8.setImage(card2);
		cardPic9.setImage(card2);
	}

	// Start scene
	// ...
	public Scene createBackgroundScene() {
		// Message
		// ...
		Greeting = new Text("Welcome to the Game!\n");
		Greeting.setFont(Font.font("Verdana", FontWeight.BOLD, 40));
		Greeting.setFill(Color.WHITE);
		
		// Play button with the game
		// Jumps to another scene using Hash
		// ...
		
		Image playImage = new Image("play.jpg");
		ImageView playPic = new ImageView(playImage);
		playPic.setFitHeight(50);
		playPic.setFitWidth(200);
		playPic.setPickOnBounds(true);
		playBtn = new Button();
		playBtn.setOnAction(toTheGame);
		playBtn.setGraphic(playPic);
		playBtn.setMaxSize(100, 100);
		playBtn.setStyle("-fx-background-color:transparent;");
		
		// Greeting and Play button connected
		// ...
		ruleBox = new VBox(-25.0, Greeting, playBtn);
		ruleBox.setAlignment(Pos.CENTER);
		
		// Settings background Image
		Image image = new Image("orig_background.jpg");
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
															BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, 
															new BackgroundSize(1.0, 1.0, true, true, false, false));
		Background background = new Background(backgroundImage);
		ruleBox.setBackground(background);
		
		return new Scene(ruleBox,1000,600);
	}
	
	// Main game scene
	// ...
	public Scene createGameScene() {
		// creating players
		// ...
		playerOne = new Player();
		playerTwo = new Player();
		theDealer = new Dealer();
		
		// Main pane with background config
		// ...
		borderPane = new BorderPane();
		borderPane.setPadding(new Insets(0,10,0,10));
		Image image = new Image("background_2.jpg");
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT,
												BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
		Background background = new Background(backgroundImage);
		borderPane.setBackground(background);
		
		// Menubar at the top of the borderPane
		// ...
		menuBar = new MenuBar();
		Menu mOne = new Menu("Options");
		
		// menu item one "exit"
		MenuItem iOne = new MenuItem("Exit");
		iOne.setOnAction(e-> {
			System.exit(0);
		});
		
		// menu item 2 "fresh start"
		MenuItem iTwo = new MenuItem("Fresh Start");
		iTwo.setOnAction(e-> {
			// money reset
			// ...
			playerOne.totalWinnings = 0;
			playerTwo.totalWinnings = 0;
			playerOne.Balance = 1000;
			playerTwo.Balance = 1000;
			
			Amount1.setText("     " + Integer.toString(playerOne.Balance) + " $");
			Amount2.setText("     " + Integer.toString(playerTwo.Balance) + " $");
			amountTotalWin1.setText("     " + Integer.toString(playerOne.totalWinnings) + " $");
			amountTotalWin2.setText("     " + Integer.toString(playerTwo.totalWinnings) + " $");
			
			_message.setText("Fresh Start clicked ...\nPlease Wait ...");
			btn1.setDisable(true);
			btn2.setDisable(true);
			btn3.setDisable(true);
			ante1.setDisable(true);
			pp1.setDisable(true);
			btn4.setDisable(true);
			btn5.setDisable(true);
			btn6.setDisable(true);
			ante2.setDisable(true);
			pp2.setDisable(true);
			pauseOfFold1.play();
		});
		
		// menu item 3 "new look"
		MenuItem iThree = new MenuItem("New Look");
		iThree.setOnAction(e-> {
			isNewLook = true;
			_player2.setFill(Color.BLACK);
			_player.setFill(Color.BLACK);
			_dealer.setFill(Color.BLACK);
			pairPlusRule.setFill(Color.BLACK);
			setCardOption2();
			Image image1 = new Image("newlook.jpg");
			BackgroundImage backgroundImage1 = new BackgroundImage(image1, BackgroundRepeat.NO_REPEAT,
													BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));
			Background background1 = new Background(backgroundImage1);
			borderPane.setBackground(background1);
		});
		
		mOne.getItems().addAll(iOne,iTwo,iThree);
		menuBar.getMenus().addAll(mOne);
		borderPane.setTop(menuBar);

		// Texts placed to the left of BorderPane
		// Connected in the VBox
		Text AccountBalance = new Text("\nP1 Balance: ");
		AccountBalance.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		AccountBalance.setFill(Color.BLACK);
		
		Amount1 = new Text("     " + Integer.toString(playerOne.Balance) + " $");
		Amount1.setFill(Color.GREEN);
		
		TotalWin1 = new Text("P1 Total Winnings: ");
		TotalWin1.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		TotalWin1.setFill(Color.BLACK);
		
		amountTotalWin1 = new Text("     " + Integer.toString(playerOne.totalWinnings));
		amountTotalWin1.setFill(Color.GREEN);
		
		Text AccountBalance2 = new Text("\nP2 Balance: ");
		AccountBalance2.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		AccountBalance2.setFill(Color.BLACK);
		
		Amount2 = new Text("     " + Integer.toString(playerTwo.Balance) + " $");
		Amount2.setFill(Color.GREEN);
		
		TotalWin2 = new Text("P2 Total Winnings: ");
		TotalWin2.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		TotalWin2.setFill(Color.BLACK);
		
		amountTotalWin2 = new Text("     " + Integer.toString(playerTwo.totalWinnings));
		amountTotalWin2.setFill(Color.GREEN);
		
		pairPlusRule = new Text("Pair Plus Rule:\n"
								   + "STRAIGHT FLUSH -> 40 to 1\n"
								   + "THREE OF A KIND -> 30 to 1\n"
								   + "STRAIGHT -> 5 to 1\n"
							       + "FLUSH -> 4 to 1\n"
								   + "PAIR  -> 1 to 1\n");
		pairPlusRule.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
		pairPlusRule.setFill(Color.WHITE);
		
//		// music player
//		// ...
//		listView = new ListView<String>();		
//		data =FXCollections.observableArrayList (
//				"50 Cent - In Da Club",
//				"Eminem - Kings Never Die",
//				"Eminem - Mocking bird",
//				"Akon - Smack that");
//		listView.getItems().addAll(data);
//		listView.setOnMouseClicked(playlist);
//		listView.setPrefWidth(110);
//		listView.setPrefHeight(135);
		
		VBox info = new VBox(10, AccountBalance, Amount1, TotalWin1, amountTotalWin1, AccountBalance2, Amount2, TotalWin2, amountTotalWin2, pairPlusRule);
		borderPane.setLeft(info);
		
		// creating 9 cards for 2 players and 1 dealer
		// resized
		// ...
		create9cards();
		
		// Created a Pane to place in the Center of the BorderPane
		// Includes everything - (menubar, left rule VBox)
		// ...
		Pane centerRoot = new Pane();
		// creating players and dealer
		Player1Create();
		Player2Create();
		DealerCreate();
		
		// info msg placed bootom
		_message = new Text("Player One place a bet. Ante bet must be above $5 and less than $25"
				+ ".\nPair Plus Bet is OPTIONAL\n");
		_message.setFont(Font.font("Verdana", FontWeight.NORMAL, 20));
		_message.setFill(Color.RED);
		borderPane.setBottom(_message);
		BorderPane.setAlignment(_message, Pos.CENTER);
		//connect everything to the center Pane
		centerRoot.getChildren().addAll(_player, setOfCard1, setOfBets1, setOfButtons1, _player2, setOfButtons2, setOfCard2, _dealer, setOfCard3,
				setOfBets2);
		
		borderPane.setCenter(centerRoot);				// pane placed in the center of the BorderPane
		
		return new Scene(borderPane,1000,600);
	}
	
	// used to print results in 1 player mode
	public String printResults(ArrayList<Card> x) {
		if(ThreeCardLogic.evalHand(x) == 1) {
			return "Straight Flush";
		}
		else if(ThreeCardLogic.evalHand(x) == 2) {
			return "Three Of a Kind";
		}
		else if(ThreeCardLogic.evalHand(x) == 3) {
			return "Straight";
		}
		else if(ThreeCardLogic.evalHand(x) == 4) {
			return "Flush";
		}
		else if(ThreeCardLogic.evalHand(x) == 5) {
			return "Pair";
		}
		else {
			return "High Card";
		}
		
	}
	
	// used to print result in 2 player mode
	public String printResults_2(ArrayList<Card> dealer, ArrayList<Card> player, Player _playerTemp) {
		int x = ThreeCardLogic.compareHands(dealer, player);
		int pp1 = ThreeCardLogic.evalPPWinnings(player, _playerTemp.pairPlusBet);
		
		if(pp1 != 0) {
			_playerTemp.totalWinnings += pp1;
			_playerTemp.Balance += pp1;
		} else {
			_playerTemp.totalWinnings -= _playerTemp.pairPlusBet;
		}
		
		if( x == 1) {
			_playerTemp.totalWinnings -= 2*_playerTemp.anteBet;
			return ("The Dealer Hand Won by " + printResults(dealer) + ", Pair Plus: " + pp1 + "$");
		}
		
		else if ( x == 2 ) {
			_playerTemp.Balance += 4*_playerTemp.anteBet;
			_playerTemp.totalWinnings += 2*_playerTemp.anteBet;
			return ("The Player Hand Won by " + printResults(player) + " + " + 4*_playerTemp.anteBet + " and Pair Plus: " + pp1 + "$");
		}
		
		else if(x == 3) {
			_playerTemp.Balance += 2*_playerTemp.anteBet;
			return ("The Dealer Hand Doesn't Qualify!" + " Pair Plus: " + pp1 + "$");
		}
		else {
			_playerTemp.Balance += 2*_playerTemp.anteBet;
			return ("Neither Hands Won!" + " Pair Plus: " + pp1 + "$");
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

	//feel free to remove the starter code from this method
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Let's Play Three Card Poker!!!");
			
		HashMap<String, Scene> sceneMap = new HashMap<String, Scene>();
		
		// event handlers 
		// pause transitions
		// ...
		pauseAfterDeal1.setOnFinished(e-> {
			_message.setText("System: Player One Play or Fold");
			btn2.setDisable(false);
			btn3.setDisable(false);
			playerOne.setPlayersHand(theDealer.dealHand());
			
			String s = Integer.toString(playerOne.hand.get(0).getValue()) + playerOne.hand.get(0).getSuit() + ".jpg";
			Image p1 = new Image(s);
			cardPic1.setImage(p1);
			
			String s1 = Integer.toString(playerOne.hand.get(1).getValue()) + playerOne.hand.get(1).getSuit() + ".jpg";
			Image p2 = new Image(s1);
			cardPic2.setImage(p2);
			
			String s2 = Integer.toString(playerOne.hand.get(2).getValue()) + playerOne.hand.get(2).getSuit() + ".jpg";
			Image p3 = new Image(s2);
			cardPic3.setImage(p3);

		});
		
		// Player Deal Button Handler
		// ...
		deal1 = new EventHandler<ActionEvent> () {
			public void handle(ActionEvent action) {
				btn1.setDisable(true);
				int temp1 = 0;
				int temp2 = 0;
				
				boolean isDigit1 = false;
				for(char x : ante1.getText().toCharArray()) {
					if(Character.isDigit(x)) {
						isDigit1 = true;
					}
					else {
						isDigit1 = false;
						break;
					}
				}
				
				boolean isDigit2 = false;
				for(char x : pp1.getText().toCharArray()) {
					if(Character.isDigit(x)) {
						isDigit2 = true;
					}
					else {
						isDigit2 = false;
						break;
					}
				}
				
				// special case if player erased the value for the textfield
				if( !(ante1.getText().isEmpty()) && isDigit1) {
					temp1 = Integer.parseInt(ante1.getText());
				}
				else {
					ante1.setText("0");
					_message.setText("Admin: Ante Bet Is Empty!");
				}
				
				if( (!(pp1.getText().isEmpty()) && isDigit2) || 
						pp1.getText() == "0") {
					temp2 = Integer.parseInt(pp1.getText());
				}
				else {
					pp1.setText("0");
					_message.setText("System: Pair Plus Is Empty!");
					temp2 = 0;
				}
				
				if( (temp1 < 5 || temp1 > 25 ) ||
						(temp2 != 0 && (temp2 < 5 || temp2 > 25)) ) {
					_message.setText("Admin: Bet must be 5 < x < 25 !!!");
					btn1.setDisable(false);
				}
				else {
					ante1.setDisable(true);
					pp1.setDisable(true);
					playerOne.anteBet = temp1;
					playerOne.pairPlusBet = temp2;
					playerOne.Balance = playerOne.Balance - temp1 - temp2;
					Amount1.setText("     " + Integer.toString(playerOne.Balance) + " $");
					pauseAfterDeal1.play();
				}
			}
		};
		
		// Player Play Button Handler
		// ...
		play1 = new EventHandler<ActionEvent> () {
			public void handle(ActionEvent event) {
				playerOne.Balance = playerOne.Balance - playerOne.anteBet;
				Amount1.setText("     " + Integer.toString(playerOne.Balance) + " $");
				btn2.setDisable(true);
				btn3.setDisable(true);
				_message.setText("System: Player Two can make a bet or Fold !!! ");
				btn4.setDisable(false);
				btn6.setDisable(false);
				ante2.setDisable(false);
				pp2.setDisable(false);
			}
		};
		
		// fold player one button
		// with pause
		// ...
		pauseOfFold1.setOnFinished(e-> {
			if(!isNewLook) {
				setCardOption1();
			}
			else {
				setCardOption2();
			}
			ante1.setText("0");
			ante1.setDisable(false);
			pp1.setDisable(false);
			pp1.setText("0");
			btn1.setDisable(false);
			btn2.setDisable(true);
			btn3.setDisable(true);
			ante2.setText("0");
			pp2.setText("0");

			_message.setText("System: Player_1 place a bet.\nAnte bet must be above $5 and less than $25\n"
					+ "Pair Plus Bet is OPTIONAL");
		});
		
		
		fold1 = new EventHandler<ActionEvent> () {
			public void handle(ActionEvent event) {
				_message.setText("System: Player One choose FOLD.\nPlayer1 lost Bet.\nResetting... Please Wait.");
				btn2.setDisable(true);
				btn3.setDisable(true);
				theDealer.isNotEnoughCards();
				pauseOfFold1.play();
			}
		};
		
		// Preparation for the new game
		// after Player2 Fold button
		// ...
		pauseOfFold2.setOnFinished(e-> {
			// resetting all the cards
			// ...
			if(!isNewLook) {
				setCardOption1();
			}
			else {
				setCardOption2();
			}
			
			// prepare for the new game
			// ...
			
			_message.setText("System: Player One place a bet.\nAnte bet must be above $5 and less than $25\n"
					+ "Pair Plus Bet is OPTIONAL");
			btn1.setDisable(false);
			ante1.setDisable(false);
			pp1.setDisable(false);

			
		});		
		
		pauseOfFold2_1.setOnFinished(e-> {
			theDealer.setDealersHand(theDealer.dealHand());
			
			String s = Integer.toString(theDealer.dealersHand.get(0).getValue()) + theDealer.dealersHand.get(0).getSuit() + ".jpg";
			Image p1 = new Image(s);
			cardPic7.setImage(p1);
			
			String s1 = Integer.toString(theDealer.dealersHand.get(1).getValue()) + theDealer.dealersHand.get(1).getSuit() + ".jpg";
			Image p2 = new Image(s1);
			cardPic8.setImage(p2);
			
			String s2 = Integer.toString(theDealer.dealersHand.get(2).getValue()) + theDealer.dealersHand.get(2).getSuit() + ".jpg";
			Image p3 = new Image(s2);
			cardPic9.setImage(p3);						
			
			btn5.setDisable(true);
			btn6.setDisable(true);
			
			
			int result = ThreeCardLogic.compareHands(theDealer.dealersHand, playerOne.hand);
			
			int PPwin1 = ThreeCardLogic.evalPPWinnings(playerOne.hand, playerOne.pairPlusBet);
			if(PPwin1 != 0) {
				playerOne.totalWinnings += PPwin1;
				playerOne.Balance += PPwin1;
			}
			else {
				playerOne.totalWinnings = playerOne.totalWinnings - PPwin1;
			}
			String ppWinMessage = "\nPair Plus: " + PPwin1 + "$\nRESETTING ...Please Wait.";
			
			if(result == 2) {
				if(PPwin1 == 0) {
					_message.setText("RESULT: Player_1 Hand Won by " + printResults(playerOne.hand) + " +" + 2*playerOne.anteBet + "$" + "\nRESETTING ...Please Wait.");
				} else {
					_message.setText("RESULT: Player_1 Hand Won by " + printResults(playerOne.hand) + " +" + 2*playerOne.anteBet + "$" + ppWinMessage);
				}
					
				playerOne.Balance += 4*playerOne.anteBet;
				playerOne.totalWinnings += 2*playerOne.anteBet;
			}

			else if(result == 1) {
				if(PPwin1 == 0) {
					_message.setText("RESULT: The Dealer Hand Won by " + printResults(theDealer.dealersHand) + "\nRESETTING ...Please Wait.");
				} else {
					_message.setText("RESULT: The Dealer Hand Won by " + printResults(theDealer.dealersHand) + ppWinMessage);
				}
				playerOne.totalWinnings = playerOne.totalWinnings - 2 * playerOne.anteBet;
			}
			else if(result == 3) {
				if (PPwin1 == 0) {
					_message.setText("RESULT: The Dealer Hand Doesn't Qualify!" + " Return " + 2*playerOne.anteBet +"$" + "\nRESETTING ...Please Wait.");
				} else {
					_message.setText("RESULT: The Dealer Hand Doesn't Qualify!" + " Return " + 2*playerOne.anteBet +"$" + ppWinMessage);
				}
				playerOne.Balance += 2*playerOne.anteBet;
			}
			else {
				if (PPwin1 == 0) {
					_message.setText("RESULT: Neither Hands Won!" + " Return " + 2*playerOne.anteBet + "$\nRESETTING ... Please Wait.");
				} else {
					_message.setText("RESULT: Neither Hands Won!" + " Return " + 2*playerOne.anteBet + ppWinMessage);
				}
				
				playerOne.Balance += 2*playerOne.anteBet;
			}
			
			Amount1.setText("     " + Integer.toString(playerOne.Balance) + " $");
			amountTotalWin1.setText("     " + Integer.toString(playerOne.totalWinnings) + " $");
			theDealer.isNotEnoughCards();
			pauseOfFold2.play();
		});
		
		fold2 = new EventHandler<ActionEvent> () {
			public void handle(ActionEvent event) {
				btn1.setDisable(true);
				ante1.setDisable(true);
				pp1.setDisable(true);
				ante2.setDisable(true);
				pp2.setDisable(true);
				btn4.setDisable(true);
				btn5.setDisable(true);
				btn6.setDisable(true);		
				_message.setText("System: Running...");
				pauseOfFold2_1.play();
			}
		};
		
		// deal for player2 button handler
		// ...
		pauseAfterDeal2.setOnFinished(e-> {
			_message.setText("System: Player_2 can Play or Fold");
			btn6.setDisable(false);
			btn5.setDisable(false);
			playerTwo.setPlayersHand(theDealer.dealHand());
			
			String s4 = Integer.toString(playerTwo.hand.get(0).getValue()) + playerTwo.hand.get(0).getSuit() + ".jpg";
			Image p4 = new Image(s4);
			cardPic4.setImage(p4);
			
			String s5 = Integer.toString(playerTwo.hand.get(1).getValue()) + playerTwo.hand.get(1).getSuit() + ".jpg";
			Image p5 = new Image(s5);
			cardPic5.setImage(p5);
			
			String s6 = Integer.toString(playerTwo.hand.get(2).getValue()) + playerTwo.hand.get(2).getSuit() + ".jpg";
			Image p6 = new Image(s6);
			cardPic6.setImage(p6);		
		});
		
		deal2 = new EventHandler<ActionEvent> () {
			public void handle(ActionEvent event) {
				int temp2_1 = 0;
				int temp2_2 = 0;
				
				boolean isDigit1 = false;
				for(char x : ante2.getText().toCharArray()) {
					if(Character.isDigit(x)) {
						isDigit1 = true;
					}
					else {
						isDigit1 = false;
						break;
					}
				}
				
				boolean isDigit2 = false;
				for(char x : pp2.getText().toCharArray()) {
					if(Character.isDigit(x)) {
						isDigit2 = true;
					}
					else {
						isDigit2 = false;
						break;
					}
				}
				// special case if player erased the value for the textfield
				if( !(ante2.getText().isEmpty()) && isDigit1) {
					temp2_1 = Integer.parseInt(ante2.getText());
				}
				else {
					ante2.setText("0");
					_message.setText("System: Ante Bet_2 Is Empty!");
				}
				
				if( (!(pp2.getText().isEmpty()) && isDigit2) || 
						pp2.getText() == "0") {
					temp2_2 = Integer.parseInt(pp2.getText());
				}
				else {
					pp2.setText("0");
					_message.setText("System: Pair Plus Is Empty!");
					temp2_2 = 0;
				}
				
				if( (temp2_1 < 5 || temp2_1 > 25 ) ||
						(temp2_2 != 0 && (temp2_2 < 5 || temp2_2 > 25)) ) {
					_message.setText("System: Bet must be 5 < x < 25 !!!");
					btn4.setDisable(false);
				}
				else {
					btn4.setDisable(true);
					btn5.setDisable(true);
					btn6.setDisable(true);
					ante2.setDisable(true);
					pp2.setDisable(true);
					playerTwo.anteBet = temp2_1;
					playerTwo.pairPlusBet = temp2_2;
					playerTwo.Balance = playerTwo.Balance - temp2_1 - temp2_2;
					Amount2.setText("     " + Integer.toString(playerTwo.Balance) + " $");
					pauseAfterDeal2.play();
				}			
			}
		};
		
		// play for player 2 button
		// ...
		pauseAfterPlay2.setOnFinished(e-> {
			theDealer.setDealersHand(theDealer.dealHand());
			
			String s = Integer.toString(theDealer.dealersHand.get(0).getValue()) + theDealer.dealersHand.get(0).getSuit() + ".jpg";
			Image p1 = new Image(s);
			cardPic7.setImage(p1);
			
			String s1 = Integer.toString(theDealer.dealersHand.get(1).getValue()) + theDealer.dealersHand.get(1).getSuit() + ".jpg";
			Image p2 = new Image(s1);
			cardPic8.setImage(p2);
			
			String s2 = Integer.toString(theDealer.dealersHand.get(2).getValue()) + theDealer.dealersHand.get(2).getSuit() + ".jpg";
			Image p3 = new Image(s2);
			cardPic9.setImage(p3);	
			
			_message.setText("Player One: " + printResults_2(theDealer.dealersHand, playerOne.hand, playerOne) 
							+ "\nPlayer Two: " + printResults_2(theDealer.dealersHand, playerTwo.hand, playerTwo) + 
							"\nResetting... Please Wait.");
			
			Amount1.setText("     " + Integer.toString(playerOne.Balance) + " $");
			amountTotalWin1.setText("     " + Integer.toString(playerOne.totalWinnings) + " $");
			
			Amount2.setText("     " + Integer.toString(playerTwo.Balance) + " $");
			amountTotalWin2.setText("     " + Integer.toString(playerTwo.totalWinnings) + " $");
			theDealer.isNotEnoughCards();
			pauseOfFold1.play();
			
		});
		
		play2 = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				playerTwo.Balance = playerTwo.Balance - playerTwo.anteBet;
				Amount2.setText("     " + Integer.toString(playerTwo.Balance) + " $");
				btn5.setDisable(true);
				btn6.setDisable(true);
				_message.setText("System: Running...");
				pauseAfterPlay2.play();
				
			}	
		};
		
		// playlist handler
		// ...
		playlist = new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				if(listView.getSelectionModel().getSelectedIndex() == 0){
					resource = getClass().getResource("50cent.mp3");
					media = new Media(resource.toString());
				    mediaPlayer1 = new MediaPlayer(media);
				    if(mediaPlayer1.getStatus().equals(Status.PLAYING) )
				    {
				    	mediaPlayer1.stop();
				    }
				    mediaPlayer1.play();
				}
					
				else if(listView.getSelectionModel().getSelectedIndex() == 1){
					resource = getClass().getResource("kings.mp3");
					media = new Media(resource.toString());
				    mediaPlayer1 = new MediaPlayer(media);
				    if(mediaPlayer1.getStatus().equals(Status.PLAYING) )
				    {
				    	mediaPlayer1.stop();
				    }
				    mediaPlayer1.play();
				}
				
				else if(listView.getSelectionModel().getSelectedIndex() == 2){
					resource = getClass().getResource("mocking.mp3");
					media = new Media(resource.toString());
				    mediaPlayer1 = new MediaPlayer(media);
				    if(mediaPlayer1.getStatus().equals(Status.PLAYING) )
				    {
				    	mediaPlayer1.stop();
				    }
				    mediaPlayer1.play();
				}
				
				else if(listView.getSelectionModel().getSelectedIndex() == 3){
					resource = getClass().getResource("smack.mp3");
					media = new Media(resource.toString());
				    mediaPlayer1 = new MediaPlayer(media);
				    if(mediaPlayer1.getStatus().equals(Status.PLAYING) )
				    {
				    	mediaPlayer1.stop();
				    }
				    mediaPlayer1.play();
				}
			}
		};
		
		sceneMap.put("game",createGameScene());
		toTheGame = new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				primaryStage.setScene(sceneMap.get("game"));
			}
		};
		
		sceneMap.put("background", createBackgroundScene());
		primaryStage.setScene(sceneMap.get("background"));
		primaryStage.show();			
	}
}