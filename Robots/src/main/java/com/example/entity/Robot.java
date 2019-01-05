package com.example.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Robot {

    private int posX;
    private int posY;
    private char direction;
    private char movement;

    public void setDirection(char direction) {
        if(this.direction=='N' && direction=='L'){
            this.movement='L';
            this.direction='L';
        }
        else if(this.direction=='N' && direction=='R'){
            this.movement='R';
            this.direction='R';
        }
        else if(this.direction=='L' && direction=='R'){
            movement='N';
            this.direction='N';
        }
        else if(this.direction=='L' && direction=='L'){
            movement='D';
            this.direction='D';
        }
        else if(this.direction=='R' && direction=='R'){
            movement='D';
            this.direction='D';
        }
        else if(this.direction=='R' && direction=='L'){
            movement='N';
            this.direction='N';
        }
    }

    private char paintingColor;

    public Robot(int posX, int posY, char direction,char paintingColor) {
        this.posX = posY;
        this.posY = posX;
        this.direction=direction;
        this.movement=direction;
        this.paintingColor=paintingColor;
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

    public void moveRobot() {
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
        }
    }
}
