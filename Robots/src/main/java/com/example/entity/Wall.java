package com.example.entity;

import com.example.exceptions.IllegalMovementException;
import com.example.exceptions.InvalidSizeException;
import lombok.Getter;

@Getter
public class Wall {

    private Grid[][] grid;
    private int sizeM;
    private int sizeN;


    public Wall(int sizeM, int sizeN) throws InvalidSizeException {
        validateWallSize(sizeM);
        validateWallSize(sizeN);
        this.grid=new Grid[sizeM][sizeN];
        this.sizeM=sizeM;
        this.sizeN=sizeN;
        this.init();
    }

    private void validateWallSize(int size) throws InvalidSizeException {
        if(size<1){
            throw new InvalidSizeException();
        }
    }

    private void init() {
        for(int i=0;i<sizeM;i++){
            for(int j=0;j<sizeN;j++){
                grid[i][j]=new Grid();
            }
        }
    }

    public void deployRobot(int posX, int posY, char direction,char paintingColor, String movements) throws Exception {
        Robot robot =  new Robot(posX,posY,direction,paintingColor);
        for(char m: movements.toCharArray()){
            switch (m){
                case 'F':
                    robot.moveRobot();
                    break;
                case 'I':
                    robot.paint(getGrid()[robot.getPosX()][robot.getPosY()]);
                    break;
                case 'N':
                case 'L':
                case 'R':
                    robot.setDirection(m);
                    break;
                default:
                    throw new IllegalMovementException("Instruction not identified");
            }
        }
    }

    // TODO: 05/01/19  Make use of Logger
    public void printGrid(){
        for(int i=sizeM-1;i>=0;i--){
            for(int j=0;j<sizeN;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
