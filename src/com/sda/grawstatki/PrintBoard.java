package com.sda.grawstatki;

/* Created by Artur Rózgowski on 3/15/17 */
public class PrintBoard extends Ship {

    private final int x = 10;
    private final int y = 10;
    Ship ship = new Ship();

    int [][] test = ship.getTopSecret();

    public PrintBoard() {
        super();
    }

    public void printMark () {

    }

    public void printEmpty () {
        printHeader();

        for (int row=0; row<x; row++) {
            // zeby dobrze wyswietlic linie z '10'
            if (row==x-1) System.out.print(row+1);
            else System.out.print(row+1 + " ");
            for (int col=0; col<y; col++) {
                System.out.print(ConColors.ANSI_BLUE + " 0" + ConColors.ANSI_RESET);
            }
            System.out.println();
        }
    }
    public void printGame (int r, int c) {
        printHeader();

        for (int row=0; row<x; row++) {
            if (row==x-1) System.out.print(row+1);
            else System.out.print(row+1 + " ");
            for (int col=0; col<y; col++) {
                if (col == c && row == r)
                    System.out.print(ConColors.ANSI_RED + " 1" + ConColors.ANSI_RESET);
                else
                    System.out.print(ConColors.ANSI_BLUE + " 0" + ConColors.ANSI_RESET);
            }
            System.out.println();
        }
    }

    public void printFull () {
        printHeader();

        for (int row=0; row<x; row++) {
            if (row==x-1) System.out.print(row+1);
            else System.out.print(row+1 + " ");
            for (int col=0; col<y; col++) {
                if (1 == test[row][col])
                    System.out.print(ConColors.ANSI_PURPLE
                            + " 1" + ConColors.ANSI_RESET);
                else if (0 == test[row][col])
                    System.out.print(ConColors.ANSI_BLUE
                            + " 0" + ConColors.ANSI_RESET);
                else if (2 == test[row][col])
                    System.out.print(ConColors.ANSI_GREEN
                            + " 2" + ConColors.ANSI_RESET);
            }
            System.out.println();
        }
    }

    public void printHeader () {
        System.out.printf("   ");
        for (int i=0; i<x; i++) System.out.printf(i+1 + " ");
        System.out.println();
    }

}
