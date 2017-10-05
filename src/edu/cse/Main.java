package edu.cse;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Main extends Application {

    @Override
    public void start(Stage theStage) throws Exception {
        Image i1 = new Image("hazard.jpg");
        ImageView hazard = new ImageView(i1);
        Image i2 = new Image("death.jpg");
        ImageView death = new ImageView(i2);

        Label warning = new Label("Please don't click this button");
        warning.setTextFill(Color.DARKRED);
        Button dangerous = new Button("ENTER DEATH ZONE");
        Label madsad = new Label("HOW COULD YOU");
        madsad.setTextFill(Color.BLACK);
        madsad.setScaleX(3);
        madsad.setScaleY(0.75);

        CheckBox fun = new CheckBox("Because I wanted to see what would happen.");
        fun.setTextFill(Color.BLACK);
        CheckBox bad = new CheckBox("Because I hate you.");
        bad.setTextFill(Color.BLACK);

        VBox angery = new VBox();
        angery.getChildren().add(madsad);
        angery.getChildren().add(fun);
        angery.getChildren().add(bad);
        angery.setAlignment(Pos.BOTTOM_CENTER);

        VBox theBox = new VBox(10, warning, dangerous);
        theBox.setAlignment(Pos.CENTER);

        StackPane pleaseNo = new StackPane();
        pleaseNo.getChildren().add(hazard);
        pleaseNo.getChildren().add(theBox);

        StackPane reprimand = new StackPane();
        reprimand.getChildren().add(death);
        reprimand.getChildren().add(angery);

        Scene firstScene = new Scene(pleaseNo, 500, 500);
        Scene wrongMove = new Scene(reprimand, 500, 500);

        dangerous.setOnAction(e-> {
            theStage.setScene(wrongMove);
            theStage.setTitle("DEATH ZONE");
        });

        theStage.setScene(firstScene);
        theStage.setTitle("DANGER ZONE");

        new AnimationTimer() {
            public void handle(long time) {
                if(fun.isSelected()) {
                    theStage.setScene(firstScene);
                    theStage.setTitle("DANGER ZONE");
                    fun.fire();
                }
                else if(bad.isSelected()) {
                    theStage.setScene(firstScene);
                    theStage.setTitle("DANGER ZONE");
                    bad.fire();
                }
            }
        }.start();

        theStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}