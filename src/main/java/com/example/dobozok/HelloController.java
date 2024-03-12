package com.example.dobozok;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Label closedDb;
    @FXML private Label openDb;
    @FXML private Pane Panel;

    Label[][] lt= new Label[10][15];
    int[][] t = new int[10][15];
    @FXML
    protected void initialize() {
        for (int s=0;s<10;s++) {
            for (int o=0;o<15;o++) {
                int ss=s,oo=o;
                lt[s][o]= new Label("");
                lt[s][o].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("null.png"))));
                lt[s][o].setTranslateX(10+o*64);
                lt[s][o].setTranslateY(10+s*64);
                lt[s][o].setOnMouseEntered(e -> lt[ss][oo].setStyle("-fx-background-color: lightgreen;"));
                lt[s][o].setOnMouseExited(e -> lt[ss][oo].setStyle("-fx-background-color: white;"));
                Panel.getChildren().add(lt[s][o]);
            }
        }

    }
}