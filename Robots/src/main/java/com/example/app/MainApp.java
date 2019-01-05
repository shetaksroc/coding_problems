package com.example.app;

import com.example.entity.Wall;
import com.example.entity.Robot;
import com.example.exceptions.IllegalMovementException;
import com.example.exceptions.InvalidSizeException;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws Exception {
        System.out.println("Lets paint these glasses");
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the grid");
        String[] gridSize = in.nextLine().split(" ");
        Wall wall =  new Wall(Integer.parseInt(gridSize[0]),Integer.parseInt(gridSize[1]));
        System.out.println("How many robots are you deploying?");
        String numRobots = in.nextLine();
        for(int i=1;i<=Integer.parseInt(numRobots);i++){
            System.out.println("Enter details for robot-"+i);
            String[] robotDetails = in.nextLine().split(" ");
            int posX=Integer.parseInt(robotDetails[0]);
            int posY=Integer.parseInt(robotDetails[1]);
            char direction=robotDetails[2].charAt(0);
            char color=robotDetails[3].charAt(0);
            System.out.println("Enter movements for robot-"+i);
            String movements = in.nextLine();
            wall.deployRobot(posX,posY,direction,color,movements);
        }
        wall.printGrid();
    }
}
