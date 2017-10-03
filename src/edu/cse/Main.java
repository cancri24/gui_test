package edu.cse;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class Main extends Application {

    @Override
    public void start(Stage theStage) throws Exception {
        Label warning = new Label("Please don't click this button");
        Button dangerous = new Button("ENTER DEATH ZONE");
        Label reprimand = new Label("HOW COULD YOU");

        VBox pleaseNo = new VBox(10, warning, dangerous);

        Scene firstScene = new Scene(pleaseNo, 200, 75);
        Scene wrongMove = new Scene(reprimand, 200, 55);

        dangerous.setOnAction(e-> {
            theStage.setScene(wrongMove);
            theStage.setTitle("DEATH ZONE");
        });

        theStage.setScene(firstScene);
        theStage.setTitle("DANGER ZONE");
        theStage.show();

    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
