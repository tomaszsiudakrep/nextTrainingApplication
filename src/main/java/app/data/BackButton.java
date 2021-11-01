package app.data;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BackButton {

    public static Button backToPreviousScreen;
    public static HBox backHBox;

    public BackButton() {
        backHBox = new HBox();
        backHBox.setAlignment(Pos.BOTTOM_CENTER);
        backToPreviousScreen = new Button("Back");
        backToPreviousScreen.setPrefHeight(30);
        backToPreviousScreen.setPrefWidth(BackgroundSettings.width);
        backToPreviousScreen.setAlignment(Pos.BOTTOM_CENTER);
        backHBox.getChildren().add(backToPreviousScreen);
    }

}
