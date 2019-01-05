package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import static com.example.constants.Constants.COLORS.*;

@Getter
@Setter
public class Grid {

    private char currentColour;

    public Grid() {
        this.currentColour = EMPTY.getColorCode();
    }


    public void paint(char color){
        if(EMPTY.getColorCode() == currentColour){
            currentColour=color;
        }else{
            currentColour=getMixedColor(currentColour,color);
        }
    }


    private char getMixedColor(char currentColour, char newColor ){
        if((currentColour==RED.getColorCode() && newColor==GREEN.getColorCode()) || (currentColour==GREEN.getColorCode() && newColor==RED.getColorCode())){
            return YELLOW.getColorCode();
        }
        return currentColour;
    }

    @Override
    public String toString() {
        return String.valueOf(currentColour);
    }
}
