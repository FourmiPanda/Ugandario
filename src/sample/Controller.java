package sample;

import Game.Player;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    Pane menu,lvl_1;

    @FXML
    ImageView play,options,level,title;

    @FXML
    Player knuckle;

    int mouvement;
    MediaPlayer sound;

    @FXML
    protected void handleOnMouseClicked(MouseEvent event) {
        System.out.println("You clicked on "+event.toString());
        if(event.getSource() instanceof ImageView){
            switch (((ImageView) event.getSource()).getId()){
                case "play":
                    menu.setVisible(false);
                    lvl_1.setVisible(true);
                    break;
                case "options":
                    break;
                case "level":
                    break;
                default:
                    break;
            }
        }
    }

    @FXML
    public void keyPressed(KeyEvent event) {
        if(lvl_1.isVisible()){
            switch (event.getCode()) {
                case UP:
                case KP_UP:

                    break;
                case DOWN:
                case KP_DOWN:

                    break;
                case RIGHT:
                case KP_RIGHT:
                    knuckle.setIsMovingLeft(false);
                    knuckle.setIsMovingRight(true);
                    break;
                case LEFT:
                case KP_LEFT:
                    knuckle.setIsMovingRight(false);
                    knuckle.setIsMovingLeft(true);
                    break;
                default:
                    break;
            }

        }


    }





    @Override
    public void initialize(URL location, ResourceBundle resources){
        System.out.println("Initialisation");

        //Set Background
        BackgroundImage myBI= new BackgroundImage(new Image("img/bg/background_game.gif",500,750,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        menu.setBackground(new Background(myBI));

        BackgroundImage myBI2= new BackgroundImage(new Image("img/bg/background_game3.gif",500,750,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        lvl_1.setBackground(new Background(myBI2));

        //Set Button
        play.setImage(new Image("img/tool/button_play.png"));
        options.setImage(new Image("img/tool/button_options.png"));
        level.setImage(new Image("img/tool/button_level.png"));
        title.setImage(new Image("img/tool/UgandarioTitle.png"));

        //Set player
//        knuckle.setImage(new Image("img/sprites/54.png"));

        //Set focus
        lvl_1.setFocusTraversable(true);

        //Set sound
        this.sound =  new MediaPlayer( new Media(new File("src/sound/click.mp3").toURI().toString()));

        //Set anim
        this.mouvement = 0;

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(50),
                        new EventHandler<ActionEvent>() {
                            @Override
                            public void handle(ActionEvent actionEvent) {
                                update();
                            }
                        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    public void update(){
        System.out.println(knuckle.getIsMovingLeft()+" - "+knuckle.getIsMovingRight());
        if(!knuckle.getIsMovingLeft() && !knuckle.getIsMovingRight()){
            this.sound.stop();
        }


        if(knuckle.getIsMovingRight()){
            this.sound.play();
            if(knuckle.getLayoutX()+36+1 < 500){

                    knuckle.setLayoutX(knuckle.getLayoutX()+1);
                    knuckle.setImage(knuckle.getSprite().get(this.mouvement%knuckle.getSprite().size()));

                this.mouvement++;

            }else{
                this.mouvement=0;
                knuckle.setIsMovingRight(false);
            }
            if(this.mouvement>=10){
                this.mouvement=0;
                knuckle.setIsMovingRight(false);
            }

        }
        if(knuckle.getIsMovingLeft()){
            this.sound.play();
            if(knuckle.getLayoutX()-1 > 0){

                knuckle.setLayoutX(knuckle.getLayoutX()-1);
                knuckle.setImage(knuckle.getSprite().get(this.mouvement%knuckle.getSprite().size()));

                this.mouvement++;

            }else{
                this.mouvement=0;
                knuckle.setIsMovingLeft(false);
            }
            if(this.mouvement>=10){
                this.mouvement=0;
                knuckle.setIsMovingLeft(false);
            }
        }

    }
}
