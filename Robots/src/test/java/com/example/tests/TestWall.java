package com.example.tests;

import com.example.constants.Constants;
import com.example.entity.Grid;
import com.example.entity.Robot;
import com.example.entity.Wall;
import com.example.exceptions.InvalidSizeException;
import org.junit.Assert;
import org.junit.Test;

public class TestWall {

    @Test
    public void testWallObjectCreation() throws InvalidSizeException {
        Wall wall =  new Wall(1,3);
        Assert.assertNotNull(wall);
    }

    @Test
    public void testWallSize() throws InvalidSizeException {
        Wall wall =  new Wall(4,5);
        Assert.assertEquals(wall.getSizeM(),4);
        Assert.assertEquals(wall.getSizeN(),5);
    }

    @Test
    public void testIfAnyGridIsNull() throws InvalidSizeException {
        int x=4,y =5;
        Wall wall =  new Wall(x,y);
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                Assert.assertNotNull(wall.getGrid()[i][j]);
            }
        }
    }

    @Test(expected = InvalidSizeException.class)
    public void testEmptyWall() throws InvalidSizeException {
        int x=0,y =0;
        Wall wall =  new Wall(x,y);
    }


    @Test(expected = Exception.class)
    public void testInvalidMovements() throws Exception {
        int x=4,y =5;
        Wall wall =  new Wall(x,y);
        wall.deployRobot(0,0,'N', Constants.COLORS.GREEN.getColorCode(),"FHGS");
    }


    @Test
    public void testGridColoring() throws Exception {
        int x=4,y =5;
        Wall wall =  new Wall(x,y);
        wall.deployRobot(0,0,'N', Constants.COLORS.GREEN.getColorCode(),"FI");
        Assert.assertTrue(wall.getGrid()[1][0].getCurrentColour()==Constants.COLORS.GREEN.getColorCode());
    }
}
