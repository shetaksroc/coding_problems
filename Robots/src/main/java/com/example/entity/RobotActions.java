package com.example.entity;

import lombok.Getter;

import static com.example.constants.Constants.COLORS.*;

@Getter
public abstract class RobotActions {

    private char paintingColor;

    protected RobotActions(char paintingColor) {
        this.paintingColor = paintingColor;
    }

    public void paint(Grid grid){
        if(EMPTY.getColorCode() == grid.getCurrentColour()){
            grid.setCurrentColour(getPaintingColor());
        }else{
            grid.setCurrentColour(getMixedColor(grid.getCurrentColour(),getPaintingColor()));;
        }
    }


    private char getMixedColor(char currentColour, char newColor ){
        if((currentColour==RED.getColorCode() && newColor==GREEN.getColorCode()) || (currentColour==GREEN.getColorCode() && newColor==RED.getColorCode())){
            return YELLOW.getColorCode();
        }
        return newColor;
    }
}
