package view;

import button.MainButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewManager {
	private static final int HEIGHT = 600;
	private static final int WIDTH = 800;
	private AnchorPane mainPane;
	private Scene mainScene;
	private Stage mainStage;
	private Image bgImg;
	private ImageView bg;
	private MainButton newGameButton;
	private MainButton loadGameButton;
	private MainButton exitButton;
	private MainButton info;
	private boolean isInfoPressed;
	private AjarnRunSubScene aboutUs;
	
	public ViewManager() {
		this.mainPane = new AnchorPane();
		setBackgroundImage("/mainSceneBackground_withoutLogo_fixed.png");
		createMainButton();
		createLogo();
		createInfoButton();
		this.mainScene = new Scene(mainPane, WIDTH, HEIGHT);
		this.mainStage = new Stage();
		this.mainStage.setScene(mainScene);
		this.mainStage.setResizable(false);
	}
	public Stage getStage() {
		return mainStage;
	}
	public AnchorPane getMainPane() {
		return mainPane;
	}
	
	private void createMainButton() {
		double initialHeight = 20;
		
		// New Game, Load Game, Exit
		newGameButton = new MainButton("New Game");
		loadGameButton = new MainButton("Leaderboard");
		exitButton = new MainButton("Exit");
		newGameButton.setLayoutY(HEIGHT-(3*initialHeight)-newGameButton.getPrefHeight()-loadGameButton.getPrefHeight()-exitButton.getPrefHeight());
		newGameButton.setLayoutX(20.00);
		loadGameButton.setLayoutY(newGameButton.getLayoutY()+initialHeight+newGameButton.getPrefHeight());
		loadGameButton.setLayoutX(20.00);
		exitButton.setLayoutY(loadGameButton.getLayoutY()+initialHeight+loadGameButton.getPrefHeight());
		exitButton.setLayoutX(20.00);
		
		// Add to pane
		mainPane.getChildren().add(newGameButton);
		mainPane.getChildren().add(loadGameButton);
		mainPane.getChildren().add(exitButton);
		
		// Implement Event Listeners
		exitButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				ViewManager.this.getStage().close();
			}
		});
	}
	
	private void setBackgroundImage(String url) {
		bgImg = new Image(url);
		bg = new ImageView(bgImg);
		bg.setFitHeight(HEIGHT);
		bg.setFitWidth(WIDTH);
		mainPane.getChildren().add(bg);
	}
	private void createLogo() {
		ImageView logo = new ImageView("/Logo.png");
		logo.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				logo.setEffect(new DropShadow());
			}
		});
		logo.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				logo.setEffect(null);
			}
		});
		mainPane.getChildren().add(logo);
	}
	private void createInfoButton() {
		double initialHeight = 20;
		// About Us
		info = new MainButton("About Us");
		info.setLayoutX(WIDTH-initialHeight-info.getPrefWidth());
		info.setLayoutY(HEIGHT-initialHeight-info.getPrefHeight());
		mainPane.getChildren().add(info);
		this.aboutUs = new AjarnRunSubScene("/button/aboutUsPicture.png", "infoButton", 350, 560);
		this.mainPane.getChildren().add(aboutUs);
		setIsInfoPressed(false);
		info.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if (ViewManager.this.getIsInfoPressed()) {
					aboutUs.moveSubScene("infoButtonPressed");
					ViewManager.this.setIsInfoPressed(false);
				} else {
					aboutUs.moveSubScene("infoButtonUnpressed");
					ViewManager.this.setIsInfoPressed(true);
				}
			}
		});
	}
	public void setIsInfoPressed(boolean isPressed) {
		this.isInfoPressed = isPressed;
	}
	public boolean getIsInfoPressed() {
		return isInfoPressed;
	}
	public MainButton getNewGameButton() {
		return newGameButton;
	}
	public MainButton getLoadGameButton() {
		return loadGameButton;
	}
	public MainButton getExitButton() {
		return exitButton;
	}
	public MainButton getInfo() {
		return info;
	}

}