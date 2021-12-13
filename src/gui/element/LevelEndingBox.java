package gui.element;

import gui.button.ImageButton;
import gui.button.ImageButtonType;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import sharedObject.FontLoader;
import sharedObject.FontType;
import sharedObject.RenderableHolder;

public class LevelEndingBox extends StackPane {

	private static StackPane mainPane;
	private static VBox infoBox;
	private static VBox controlBox;
	private static Label moneyPlusLabel;
	private static Label levelUpLabel;
	private static Image bg;
	private static ImageButton imgButton;
	private Rectangle rec = new Rectangle(280, 380);

	public LevelEndingBox(LevelEndingType type) {
		mainPane = new StackPane();
		initComponents(type);
		mainPane.setAlignment(Pos.CENTER);
		mainPane.getChildren().addAll(rec, controlBox);
		this.getChildren().addAll(mainPane);
	}

	private void initComponents(LevelEndingType type) {
		switch (type) {
		case COMPLETED:
			setLevelUpLabel();
			imgButton = new ImageButton(ImageButtonType.CONTINUE_LV);
			bg = RenderableHolder.level_passed_Image;
			this.setOpacity(0.85);
			break;
		case FAILED:
			setLevelLabel();
			imgButton = new ImageButton(ImageButtonType.SKIP_LV);
			bg = RenderableHolder.level_failed_Image;
			this.setOpacity(0.8);
			break;
		default:
			break;
		}
		rec.setFill(new ImagePattern(bg));
		this.setAlignment(Pos.CENTER);
		setMoneyPlusLabel();
		setupCenterBox();

	}

	// ====================== private static method(s) ============================

	private static void setupCenterBox() {
		infoBox = new VBox(28);
		infoBox.setAlignment(Pos.CENTER);
		infoBox.getChildren().addAll(moneyPlusLabel, levelUpLabel);
		imgButton.setLayoutX(50);
		controlBox = new VBox(50);
		controlBox.getChildren().addAll(infoBox,imgButton);
		controlBox.setPadding(new Insets(143));
		controlBox.setAlignment(Pos.BOTTOM_CENTER);
	}

	private static void setMoneyPlusLabel() {
		moneyPlusLabel = new Label("   $ " + "170");
		FontLoader.setFont(moneyPlusLabel, FontType.TELEGRAMA, 18);
		moneyPlusLabel.setTextFill(Color.WHITE);
	}

	private static void setLevelLabel() {
		levelUpLabel = new Label("   lv." + "10");
		FontLoader.setFont(levelUpLabel, FontType.TELEGRAMA, 19);
		levelUpLabel.setTextFill(Color.INDIANRED);
	}

	private static void setLevelUpLabel() {
		setLevelLabel();
		levelUpLabel.setTextFill(Color.PALEGREEN);
	}

	// ================== GETTERS - SETTERS ========================

	public Label getMoneyPlusLabel() {
		return moneyPlusLabel;
	}

	public void setMoneyPlusLabel(Label moneyPlusLabel) {
		LevelEndingBox.moneyPlusLabel = moneyPlusLabel;
	}

	public Label getLevelUpLabel() {
		return levelUpLabel;
	}

	public void setLevelUpLabel(Label levelUpLabel) {
		LevelEndingBox.levelUpLabel = levelUpLabel;
	}

	public Image getBg() {
		return bg;
	}

	public void setBg(Image bg) {
		LevelEndingBox.bg = bg;
	}

	public ImageButton getImgButton() {
		return imgButton;
	}

	public void setImgButton(ImageButton imgButton) {
		LevelEndingBox.imgButton = imgButton;
	}

	public Rectangle getRec() {
		return rec;
	}

	public void setRec(Rectangle rec) {
		this.rec = rec;
	}

	private void setUpMouseEnter() {

		setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				LevelEndingBox.this.rec.setEffect(new DropShadow());
			}
		});

		setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				LevelEndingBox.this.rec.setEffect(null);
			}
		});
	}

}
