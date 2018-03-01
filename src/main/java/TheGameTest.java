package main.java;

import org.junit.jupiter.api.Assertions;

class TheGameTest {
    @org.junit.jupiter.api.Test
    void main() {

    //nastavit kostičkám nějakou polohu

        Field fieldcoord [];
        fieldcoord = new Field[4];

        fieldcoord[0] = new Field(6, 14);
        fieldcoord[1] = new Field(5, 14);
        fieldcoord[2] = new Field(5, 15);
        fieldcoord[3] = new Field(6, 15);

    // zavolat nějakou metodu



    //zkontrolovat, že je to ok

        Assertions.assertEquals( 2, 1+1);

        System.out.println("běží to");


    }

}