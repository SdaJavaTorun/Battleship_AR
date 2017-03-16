package com.sda.grawstatki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PrintBoard board = new PrintBoard();
        Ship ship1 = new Ship(10, 10);

        boolean endGame = false;

        while (!endGame) {

            //GUI.showMenu();
            Ship ship = new Ship(10, 10);
            /*
            int column = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Give me a column\n");
            System.out.println(column);
            int row = Integer.parseInt(bufferedReader.readLine());
            System.out.println("Give me a row\n");
            System.out.println(row);
            */
            //int [][] tmp = ship.setSize1(4);
            ship.setSize4();
            board.printFull();
            ship.setSize3(2);
            ship.setSize1(4);
            board.printFull();
            //System.out.println(tmp[5][5]);
            //System.out.println(tmp[row][column]);
            //if (1 == tmp[row][column]) {
              //  board.print(row-1, column-1);
                //System.out.println("Trafienie");
            //}
            //else System.out.println("Pudło");


            endGame = true;
        }
    }
}
