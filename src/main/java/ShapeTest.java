package main.java;

import org.junit.jupiter.api.Test;

class ShapeTest {

    //nastavit kostičkám nějakou polohu  ✓
    //zavolat nějakou metodu
    //zkontrolovat, že je to ok

    @Test
    void move() {
        Field fieldcoord[];
        fieldcoord = new Field[4];

        fieldcoord[0] = new Field(4, 14);
        fieldcoord[1] = new Field(5, 14);
        fieldcoord[2] = new Field(6, 14);
        fieldcoord[3] = new Field(7, 14);

        for (int j = 0; j < 4; j++) {
            fieldcoord[j].y++;
            System.out.println(fieldcoord[j].y);
        }

        for (int j = 0; j < 4; j++) {
            if (fieldcoord[j].y == 14 + 1){

                System.out.println(fieldcoord[j].y + " je to správně\n");
            }
        }
    }

    @Test
    void moveRight() {
        Field fieldcoord[];
        fieldcoord = new Field[4];

        fieldcoord[0] = new Field(4, 14);
        fieldcoord[1] = new Field(5, 14);
        fieldcoord[2] = new Field(6, 14);
        fieldcoord[3] = new Field(7, 14);

        for (int j=0; j < 4; j++){
            if (fieldcoord[j].x<9){
                fieldcoord[j].x++;
            }
        }

        for (int j = 0; j < 4; j++) {
            if (fieldcoord[j].x == 4 + j + 1){

                System.out.println(fieldcoord[j].x + " je to správně\n");
            }
        }
    }
}