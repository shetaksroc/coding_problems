package com.example.tests;

import com.example.entity.Robot;
import org.junit.Assert;
import org.junit.Test;

public class TestRobot {

    @Test
    public void testRobotCreation(){
        Robot robot=new Robot(0,0,'N', 'G');
        Assert.assertEquals(0, robot.getPosX());
        Assert.assertEquals(0, robot.getPosY());
        Assert.assertEquals('N', robot.getDirection());
    }

    @Test
    public void testRobotMovements1() throws Exception {
        Robot robot=new Robot(0,0,'N', 'G');
        robot.moveRobot();
        Assert.assertEquals(1, robot.getPosX());
        Assert.assertEquals(0, robot.getPosY());
    }

    @Test
    public void testRobotMovements2() throws Exception {
        Robot robot=new Robot(0,0,'R', 'G');
        robot.moveRobot();
        Assert.assertEquals(0, robot.getPosX());
        Assert.assertEquals(1, robot.getPosY());
    }

    @Test
    public void testRobotMovements3() throws Exception {
        Robot robot=new Robot(1,0,'L', 'G');
        robot.moveRobot();
        Assert.assertEquals(0, robot.getPosX());
        Assert.assertEquals(0, robot.getPosY());
    }

    @Test
    public void testRobotMovements4() throws Exception {
        Robot robot=new Robot(4,0,'N', 'G');
        robot.moveRobot();
        robot.moveRobot();
        robot.setDirection('L');
        robot.moveRobot();
        robot.setDirection('R');
        robot.moveRobot();
        Assert.assertEquals(3, robot.getPosX());
        Assert.assertEquals(3, robot.getPosY());
    }
}
