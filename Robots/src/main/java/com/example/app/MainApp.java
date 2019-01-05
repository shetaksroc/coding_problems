package com.example.app;

import com.example.entity.Wall;
import com.example.entity.Robot;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args){
        System.out.println("Lets paint these glasses");
        Scanner in = new Scanner(System.in);
//        String[] gridSize = in.nextLine().split(" ");
        String[] gridSize = "5 5".split(" ");
        Wall wall =  new Wall(Integer.parseInt(gridSize[0]),Integer.parseInt(gridSize[1]));

        System.out.println("How many are you deploying?");
//        String numRobots = in.nextLine();
        String numRobots = "2";
        for(int i=1;i<=Integer.parseInt(numRobots);i++){
            String[] robotDetails = in.nextLine().split(" ");
            int posX=Integer.parseInt(robotDetails[0]);
            int posY=Integer.parseInt(robotDetails[1]);
            char direction=robotDetails[2].charAt(0);
            char color=robotDetails[3].charAt(0);
            Robot robot =  new Robot(posX,posY,direction,color);
            String movements = in.nextLine();
            wall.printGrid();
            wall.deployRobot(robot, movements);
            wall.printGrid();
        }
    }
}
