package Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Player extends ImageView{

    private ArrayList<Image> sprite = new ArrayList<>();
    private ArrayList<Image> spriteJump = new ArrayList<>();
    private Image noMove;
    private boolean isMovingRight,isMovingLeft,isJumping;


    public Player(){
        super();
        isMovingRight = false;
        isMovingLeft = false;
        isJumping = false;
        noMove = new Image("img/sprites/54.png");
        sprite.add(new Image("img/sprites/0.png"));
        sprite.add(new Image("img/sprites/1.png"));
        sprite.add(new Image("img/sprites/2.png"));
        sprite.add(new Image("img/sprites/3.png"));
        sprite.add(new Image("img/sprites/4.png"));

        this.setImage(noMove);
    }


    public boolean getIsMovingRight(){
        return this.isMovingRight;
    }
    public boolean getIsJumping(){ return this.isJumping; }
    public boolean getIsMovingLeft(){
        return this.isMovingLeft;
    }

    public void setIsMovingRight(boolean b){
        this.isMovingRight = b;
    }
    public void setIsMovingLeft(boolean b){
        this.isMovingLeft= b;
    }
    public void setIsJumping(boolean b){
        this.isJumping= b;
    }

    public ArrayList<Image> getSprite() {
        return sprite;
    }
    public ArrayList<Image> getSpriteJump() {
        return spriteJump;
    }
    public Image getNoMove() {
        return noMove;
    }



}
