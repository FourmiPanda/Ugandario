package Game;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Player extends ImageView{

    private ArrayList<Image> sprite = new ArrayList<>();
    private Image noMove;
    private boolean isMovingRight,isMovingLeft;


    public Player(){
        super();
        isMovingRight = false;
        isMovingLeft = false;
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
    public boolean getIsMovingLeft(){
        return this.isMovingLeft;
    }

    public void setIsMovingRight(boolean b){
        this.isMovingRight = b;
    }
    public void setIsMovingLeft(boolean b){
        this.isMovingLeft= b;
    }

    public ArrayList<Image> getSprite() {
        return sprite;
    }

    public Image getNoMove() {
        return noMove;
    }

    public void gauche(){
        if(this.getLayoutX()-1 > 0)
        this.setLayoutX(this.getLayoutX()-1);
    }
    public void droite(){
        if(this.getLayoutX()+36+1 < 500){
            isMovingRight = true;
            for (int i = 0 ; i<10; i++){
                System.out.println("Mouvement");
                this.setLayoutX(this.getLayoutX()+1);
                this.setImage(sprite.get(i%sprite.size()));

            }
            this.setImage(noMove);
        }
        isMovingRight = false;


    }

}
