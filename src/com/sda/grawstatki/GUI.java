package com.sda.grawstatki;

/* Created by Artur Rózgowski on 3/15/17 */
public class GUI {

    static PrintBoard board = new PrintBoard();

    public static void showMenu () {

        System.out.printf(ConColors.ANSI_GREEN
                + "The battleship begin...!!!\n\n"
                + ConColors.ANSI_RESET);
        board.printEmpty();
        System.out.println(ConColors.ANSI_YELLOW
                + "\nMake a bloody shoot you bastard!"
                + ConColors.ANSI_RESET);

    }
}
