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

    @Override
    public String toString() {
        return String.valueOf(currentColour);
    }
}
