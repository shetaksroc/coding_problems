package com.example.entity;

public class Wall {

    private Grid[][] grid;
    private int sizeM;
    private int sizeN;


    public Wall(int sizeM, int sizeN) {
        this.grid=new Grid[sizeM][sizeN];
        this.sizeM=sizeM;
        this.sizeN=sizeN;
        this.init();
    }

    private void init() {
        for(int i=0;i<sizeM;i++){
            for(int j=0;j<sizeN;j++){
                grid[i][j]=new Grid();
            }
        }
    }

    public void deployRobot(Robot robot, String movements){
        for(char m: movements.toCharArray()){
            switch (m){
                case 'F':
                    robot.moveRobot();
                    break;
                case 'I':
                    grid[robot.getPosX()][robot.getPosY()].paint(robot.getPaintingColor());
                    break;
                default:
                    robot.setDirection(m);
                    break;
            }
        }
    }

//    0 0 N R
//    FFRFIFIRFIF
//

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
