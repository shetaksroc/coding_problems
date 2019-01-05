package com.example.tests;

import com.example.constants.Constants;
import com.example.entity.Grid;
import org.junit.Assert;
import org.junit.Test;

public class TestGrid {

    @Test
    public void testDefaultColor(){
        Grid grid=new Grid();
        Assert.assertNotNull(grid.getCurrentColour());
        Assert.assertEquals(Constants.COLORS.EMPTY.getColorCode(),grid.getCurrentColour());
    }
}
