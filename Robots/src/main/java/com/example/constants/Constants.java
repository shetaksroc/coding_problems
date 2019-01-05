package com.example.constants;

public class Constants {

    public enum COLORS{

        EMPTY('E'),
        RED('R'),
        GREEN('G'),
        YELLOW('Y');

        private char colorCode;

        COLORS(char colorCode) {
            this.colorCode=colorCode;
        }

        public char getColorCode() {
            return colorCode;
        }
    }
}
