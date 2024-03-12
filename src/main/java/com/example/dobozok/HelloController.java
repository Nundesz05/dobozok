package com.example.dobozok;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Label closedDb;
    @FXML private Label openDb;
    @FXML private Pane Panel;
    @FXML private ImageView Arrow;

    Label[][] lt= new Label[10][15];
    int[][] t = new int[10][15];

    AnimationTimer timer = null;
    int fok=0;
    int x=1;
    int doboz=0;
    int opendoboz=0;

    @FXML
    protected void initialize() {
        for (int s=0;s<10;s++) {
            for (int o=0;o<15;o++) {
                t[s][o]= 0;
                int ss=s,oo=o;
                lt[s][o]= new Label("");
                lt[s][o].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("null.png"))));
                lt[s][o].setTranslateX(10+o*64);
                lt[s][o].setTranslateY(10+s*64);
                lt[s][o].setOnMouseEntered(e -> lt[ss][oo].setStyle("-fx-background-color: lightgreen;"));
                lt[s][o].setOnMouseExited(e -> lt[ss][oo].setStyle("-fx-background-color: white;"));
                lt[s][o].setOnMouseClicked(e -> click(ss,oo));
                Panel.getChildren().add(lt[s][o]);

            }
        }
       timer= new AnimationTimer() {
           @Override
           public void handle(long now) {
                   Arrow.setRotate(fok);
                   fok++;
               }
       };
    timer.start();

        for (int s=0;s<15;s++) {
            random();
            for (int o=9;o>x;o--) {
                lt[o][s].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("box.png"))));
                t[o][s]=1;
            }
        }
        szamol();
    }
    int a = 1000000;
    private void click(int ss,int oo){
                if(ss>0) {
                    if (t[ss][oo] == 1 && t[ss - 1][oo] == 0) {
                        lt[ss][oo].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("boxopen.png"))));
                        t[ss][oo] = 2;
                        opendoboz++;
                    }


                } else{
                    if(ss==0 && t[ss + 1][oo] == 1 && t[ss][oo] == 1 ) {
                        lt[ss][oo].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("boxopen.png"))));
                        t[ss][oo] = 2;
                        opendoboz++;
                    }
            }
            if (t[ss][oo] == 0 && t[ss + 1][oo] == 1) {
            lt[ss][oo].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("box.png"))));
            t[ss][oo] = 1;
            doboz++;
        }
        szamol();
    }

    private void random() {
        x = (int)(Math.random()*8);

    }

    public void onRandomClick() {
        for (int s=0;s<10;s++) {
            for (int o = 0; o < 15; o++) {
                lt[s][o].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("null.png"))));
                t[s][o] = 0;
            }
        }
        for (int o=0;o<15;o++) {
            random();
            for (int s=9;s>x;s--) {
                lt[s][o].setGraphic(new ImageView(new Image(getClass().getResourceAsStream("box.png"))));
                t[s][o]=1;
            }
        }
        szamol();
    }

    private void szamol() {
        closedDb.setText(doboz+" db");
        openDb.setText(opendoboz+" db");
    }
}