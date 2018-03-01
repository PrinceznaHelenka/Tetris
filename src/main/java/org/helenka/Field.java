package org.helenka;

import java.awt.*;

public class Field {

    int x;
    int y;
    Color color = null;

    public Field(int i, int j) {
        this.x = i;
        this.y = j;

    }

    public boolean isAvaiable(){

        if (color == null){
            return true;
        }
        else {
            return false;
        } //return (color == null);
    }

    public Color getColorOfField() {
        return color;

    }
}
//public boolean getAvailability(){return isAvaiable();}
