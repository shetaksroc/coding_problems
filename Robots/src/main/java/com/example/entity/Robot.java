package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import static com.example.constants.Constants.COLORS.*;

@Getter
@Setter
public class Robot extends RobotActions {

    private int posX;
    private int posY;
    private char direction;
    private char movement;

    // TODO: 05/01/19  Validating colors and directions
    public Robot(int posX, int posY, char direction,char paintingColor) {
        super(paintingColor);
        this.posX = posY;
        this.posY = posX;
        this.direction=direction;
        this.movement=direction;
    }

    public void setDirection(char direction) {
        if(this.direction=='N' && direction=='L'){
            setMovementAndDirection('L');
        }
        else if(this.direction=='N' && direction=='R'){
            setMovementAndDirection('R');
        }
        else if(this.direction=='L' && direction=='R'){
            setMovementAndDirection('N');
        }
        else if(this.direction=='L' && direction=='L'){
            setMovementAndDirection('D');
        }
        else if(this.direction=='R' && direction=='R'){
            setMovementAndDirection('D');
        }
        else if(this.direction=='R' && direction=='L'){
            setMovementAndDirection('N');
        }
    }

    private void setMovementAndDirection(char d) {
        this.movement = d;
        this.direction = d;
    }

    private void upMovement() {
        this.posX+=1;
    }

    private void leftMovement() {
        this.posY-=1;
    }

    private void rightMovement() {
        this.posY+=1;
    }

    private void downMovement() {
        this.posX-=1;
    }

    public void moveRobot() throws Exception {
        switch(this.getMovement()){
            case 'N':
                upMovement();
                break;
            case 'R':
                rightMovement();
                break;
            case 'L':
                leftMovement();
                break;
            case 'D':
                downMovement();
                break;
            default:
                throw new Exception("Invalid movement");
        }
    }
}
