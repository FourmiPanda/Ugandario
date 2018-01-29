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
    Pane menu,lvl_1,level_choice,lvl_2,lvl_3;

    @FXML
    ImageView play,options,level,title,lvl1,lvl2,lvl3,level_ch,sound_off,sound_on;


    @FXML
    Player knuckle;

    int mouvement,jump;
    MediaPlayer sound,ost;



    @FXML
    protected void handleOnMouseClicked(MouseEvent event) {
        System.out.println("You clicked on "+event.toString());
        if(event.getSource() instanceof ImageView){
            switch (((ImageView) event.getSource()).getId()){
                case "play":
                    menu.setVisible(false);
                    level_choice.setVisible(false);
                    lvl_1.setVisible(true);
                    this.ost.stop();
                    break;
                case "options":
                    break;
                case "level":
                    menu.setVisible(false);
                    lvl_1.setVisible(false);
                    lvl_3.setVisible(false);
                    lvl_2.setVisible(false);
                    level_choice.setVisible(true);
                    this.ost.stop();
                    break;
                case "lvl1":
                    if(!lvl_1.getChildren().contains(knuckle)){
                        if(lvl_2.getChildren().contains(knuckle)){
                            lvl_2.getChildren().remove(knuckle);
                            lvl_1.getChildren().add(knuckle);
                        }else if(lvl_3.getChildren().contains(knuckle)){
                            lvl_3.getChildren().remove(knuckle);
                            lvl_1.getChildren().add(knuckle);
                        }
                    }
                    menu.setVisible(false);
                    level_choice.setVisible(false);
                    lvl_3.setVisible(false);
                    lvl_2.setVisible(false);
                    lvl_1.setVisible(true);
                    this.ost.stop();
                    break;
                case "lvl2":
                    if(!lvl_2.getChildren().contains(knuckle)){
                        if(lvl_1.getChildren().contains(knuckle)){
                            lvl_1.getChildren().remove(knuckle);
                            lvl_2.getChildren().add(knuckle);
                        }else if(lvl_3.getChildren().contains(knuckle)){
                            lvl_3.getChildren().remove(knuckle);
                            lvl_2.getChildren().add(knuckle);
                        }
                    }
                    menu.setVisible(false);
                    level_choice.setVisible(false);
                    lvl_3.setVisible(false);
                    lvl_1.setVisible(false);
                    lvl_2.setVisible(true);

                    this.ost.stop();
                    break;
                case "lvl3":
                    if(!lvl_3.getChildren().contains(knuckle)){
                        if(lvl_2.getChildren().contains(knuckle)){
                            lvl_2.getChildren().remove(knuckle);
                            lvl_3.getChildren().add(knuckle);
                        }else if(lvl_1.getChildren().contains(knuckle)){
                            lvl_1.getChildren().remove(knuckle);
                            lvl_3.getChildren().add(knuckle);
                        }
                    }
                    menu.setVisible(false);
                    level_choice.setVisible(false);
                    lvl_3.setVisible(true);
                    lvl_2.setVisible(false);
                    lvl_1.setVisible(false);
                    this.ost.stop();
                    break;
                case "sound_on":
                case "sound_off":
                    if(sound_on.isVisible()){
                        sound_on.setVisible(false);
                       sound_off.setVisible(true);
                       this.ost.pause();
                    }else{
                        sound_on.setVisible(true);
                        sound_off.setVisible(false);
                        this.ost.play();
                    }

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
                    knuckle.setIsJumping(true);
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

        BackgroundImage myBI3= new BackgroundImage(new Image("img/bg/background_game2.gif",500,750,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        BackgroundImage myBI4= new BackgroundImage(new Image("img/bg/level-1.gif",500,750,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        lvl_1.setBackground(new Background(myBI2));
        lvl_2.setBackground(new Background(myBI3));
        lvl_3.setBackground(new Background(myBI4));

        level_choice.setBackground(new Background(myBI));


        //Set Button
        play.setImage(new Image("img/tool/button_play.png"));
        options.setImage(new Image("img/tool/button_options.png"));
        level.setImage(new Image("img/tool/button_level.png"));
        title.setImage(new Image("img/tool/UgandarioTitle.png"));
        lvl1.setImage(new Image("img/tool/level_1.png"));
        lvl2.setImage(new Image("img/tool/level_2.png"));
        lvl3.setImage(new Image("img/tool/level_3.png"));
        level_ch.setImage(new Image("img/tool/button_level.png"));

        sound_off.setImage(new Image("img/tool/sound_mute.png"));
        sound_on.setImage(new Image("img/tool/sound.png"));
        //Set focus
        lvl_1.setFocusTraversable(true);
        lvl_2.setFocusTraversable(true);
        lvl_3.setFocusTraversable(true);

        //Set sound

        this.ost = new MediaPlayer(new Media(new File("src/sound/ost.mp3").toURI().toString()));
        this.sound =  new MediaPlayer(new Media(new File("src/sound/click.mp3").toURI().toString()));
        this.ost.play();

        //Set anim
        this.mouvement = 0;
        this.jump = 0;

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
        if(!knuckle.getIsMovingLeft() && !knuckle.getIsMovingRight()){
            this.sound.stop();
        }

        if(knuckle.getIsJumping()){
            if(knuckle.getLayoutY()-1 > 0){
                if(jump>=10){
                    knuckle.setLayoutY(knuckle.getLayoutY()+5);
                    knuckle.setImage(new Image("img/sprites/55.png"));
                }else{
                    knuckle.setLayoutY(knuckle.getLayoutY()-5);
                    knuckle.setImage(new Image("img/sprites/55.png"));
                }

                this.jump++;

            }else{
                this.jump=0;
                knuckle.setImage(knuckle.getNoMove());
                knuckle.setIsJumping(false);
            }
            if(this.jump>=20){
                this.jump=0;
                knuckle.setImage(knuckle.getNoMove());
                knuckle.setIsJumping(false);
            }
        }

        if(knuckle.getIsMovingRight()){
            this.sound.play();
            if(knuckle.getLayoutX()+36+1 < 500){

                    knuckle.setLayoutX(knuckle.getLayoutX()+5);
                    knuckle.setImage(knuckle.getSprite().get(this.mouvement%knuckle.getSprite().size()));
                    knuckle.setScaleX(1);
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

                knuckle.setLayoutX(knuckle.getLayoutX()-5);
                knuckle.setImage(knuckle.getSprite().get(this.mouvement%knuckle.getSprite().size()));
                knuckle.setScaleX(-1);
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
