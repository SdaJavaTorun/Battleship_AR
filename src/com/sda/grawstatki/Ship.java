package com.sda.grawstatki;

import java.util.Random;

/* Created by Artur Rózgowski on 3/15/17 */
public class Ship {

    private int x;
    private int y;
    private static int [][] topSecret = new int[10][10];

    Random random = new Random();

    public Ship(int x, int y) {
        this.x = x;
        this.y = y;

        for (int i = 0; i<x; i++) {
            for (int j = 0; j<y; j++) {
                this.topSecret [i][j] = 0;
            }
        }
    }
    public Ship () {}

    public int[][] getTopSecret() {
        return this.topSecret;
    }

    public void ifBCDiff1 (int b, int c) {
        if (topSecret[b][c] != 1) topSecret[b][c] = 2;
    }

    public int [][] appendTopSecret (int [][] t) {
        for (int r=0; r<10; r++) {
            for (int c=0; c<10; c++) {
                if (t[r][c] == 1 || t[r][c] == 2) topSecret[r][c] = t[r][c];
            }
        }
        return this.topSecret;
    }

    public int[][] setSize4 () {
        int l = random.nextInt(4);
        //System.out.println("l: " + l);

        switch (0) { // 4 masztowiec jest pierwszy wiec nie musimy szukac wystawien innych masztow
            case 0: // rysujemy w pioziomie od lewej zaczynamy
                x = random.nextInt(10);
                y = random.nextInt(7);  // 7 jest wylaczone z losowania

                // rysowanie masztów
                for (int i=0; i<4; i++) topSecret[x][y+i] = 1;
                // rysowanie granic
                if (x==0 || y==0 || x==9 || y==6) {
                    if (x == 0 && y == 0) {
                        for (int b = x; b <= x + 1; b++) {
                            for (int c = y; c <= y + 4; c++) ifBCDiff1(b, c);
                        }
                    } else if (x == 0 && y == 6) {
                        for (int b = x; b <= x + 1; b++) {
                            for (int c = y - 1; c <= y + 3; c++) ifBCDiff1(b, c);
                        }
                    } else if (x == 0) {
                        for (int b = x; b <= x+1; b++) {
                            for (int c = y - 1; c <= y + 4; c++) ifBCDiff1(b, c);
                        }
                    } else if (x == 9 && y == 0) {
                        for (int b = x - 1; b <= x; b++) {
                            for (int c = y; c <= y + 4; c++) ifBCDiff1(b, c);
                        }
                    } else if (x == 9 && y == 6) {
                        for (int b = x - 1; b <= x; b++) {
                            for (int c = y - 1; c <= y + 3; c++) ifBCDiff1(b, c);
                        }
                    } else if (x == 9) {
                        for (int b = x - 1; b <= x; b++) {
                            for (int c = y - 1; c <= y + 4; c++) ifBCDiff1(b, c);
                        }
                    } else if (y == 6) {
                        for (int b = x - 1; b <= x + 1; b++) {
                            for (int c = y - 1; c <= y + 3; c++) ifBCDiff1(b, c);
                        }
                    } else if (y == 0) {
                        for (int b = x - 1; b <= x + 1; b++) {
                            for (int c = y; c <= y + 4; c++) ifBCDiff1(b, c);
                        }
                    }
                }
                else {
                    for (int b = x - 1; b <= x + 1; b++) {
                        for (int c = y - 1; c <= y + 4; c++) ifBCDiff1(b, c);
                    }
                }
            break;
        }
        return this.topSecret;
    }

    public int[][] setSize1 (int count) {
        for (int i=0; i<count; i++) {
            do {
                x = random.nextInt((10));
                y = random.nextInt((10));
            }
            // dopoki miejsce w tabeli zajete losuj dalej
            while (topSecret[x][y] == 1 ||
                   topSecret[x][y] == 2);

            topSecret[x][y] = 1;

            // drukowanie granic masztu
            if (x==0 || y==0 || x==9 || y==9) {
                if (x == 0 && y == 0) {
                    for (int b = x; b <= x + 1; b++) {
                        for (int c = y; c <= y + 1; c++) ifBCDiff1(b, c);
                    }
                } else if (x == 0 && y == 9) {
                    for (int b = x; b <= x + 1; b++) {
                        for (int c = y - 1; c <= y; c++) ifBCDiff1(b, c);
                    }
                } else if (x == 0) {
                    for (int b = x; b <= x+1; b++) {
                        for (int c = y - 1; c <= y + 1; c++) ifBCDiff1(b, c);
                    }
                } else if (x == 9 && y == 0) {
                    for (int b = x - 1; b <= x; b++) {
                        for (int c = y; c <= y + 1; c++) ifBCDiff1(b, c);
                    }
                } else if (x == 9 && y == 9) {
                    for (int b = x - 1; b <= x; b++) {
                        for (int c = y - 1; c <= y; c++) ifBCDiff1(b, c);
                    }
                } else if (x == 9) {
                    for (int b = x - 1; b <= x; b++) {
                        for (int c = y - 1; c <= y + 1; c++) ifBCDiff1(b, c);
                    }
                } else if (y == 9) {
                    for (int b = x - 1; b <= x + 1; b++) {
                        for (int c = y - 1; c <= y; c++) ifBCDiff1(b, c);
                    }
                } else if (y == 0) {
                    for (int b = x - 1; b <= x + 1; b++) {
                        for (int c = y; c <= y + 1; c++) ifBCDiff1(b, c);
                    }
                }
            }
            else {
                for (int b = x - 1; b <= x + 1; b++) {
                    for (int c = y - 1; c <= y + 1; c++) ifBCDiff1(b, c);
                }
            }
        }
        return appendTopSecret(topSecret);
    }

    public int[][] setSize3 (int count) {
        for (int z =0; z<count; z++) {  // rysujemy 2 trzymasztowce
            int l = random.nextInt(4);
            //System.out.println("l: " + l);

            switch (0) {
                case 0: // rysujemy w pionie od góry zaczynamy
                    do {
                        x = random.nextInt(8);
                        y = random.nextInt(10);  // 8 jest wylaczone z losowania
                    } while ( topSecret[x][y] == 1 || topSecret[x][y] == 2 ||
                                topSecret[x+1][y] == 1 || topSecret[x+1][y] == 2 ||
                                topSecret[x+2][y] == 1 || topSecret[x+2][y] == 2);
                    // rysowanie masztów
                    for (int i = 0; i < 3; i++)
                        topSecret[x+i][y] = 1;
                    System.out.println("x= " + x + " y= " + y);
                    // rysowanie granic
                    if (x == 0 || y == 0 || x == 7 || y == 9) {
                        if (x == 0 && y == 0) {
                            for (int b = x; b <= x + 3; b++) {
                                for (int c = y; c <= y + 1; c++) ifBCDiff1(b, c);
                            }
                        } else if (x == 0 && y == 9) {
                            for (int b = x; b <= x + 3; b++) {
                                for (int c = y - 1; c <= y; c++) ifBCDiff1(b, c);
                            }
                        } else if (x == 0) {
                            for (int b = x; b <= x + 3; b++) {
                                for (int c = y - 1; c <= y + 1; c++) ifBCDiff1(b, c);
                            }
                        } else if (x == 7 && y == 0) {
                            for (int b = x - 1; b <= x + 3; b++) {
                                for (int c = y; c <= y + 1; c++) ifBCDiff1(b, c);
                            }
                        } else if (x == 7 && y == 9) {
                            for (int b = x - 1; b <= x + 3; b++) {
                                for (int c = y - 1; c <= y; c++) ifBCDiff1(b, c);
                            }
                        } else if (x == 7) {
                            for (int b = x - 1; b <= x + 3; b++) {
                                for (int c = y - 1; c <= y + 1; c++) ifBCDiff1(b, c);
                            }
                        } else if (y == 9) {
                            for (int b = x - 1; b <= x + 3; b++) {
                                for (int c = y - 1; c <= y; c++) ifBCDiff1(b, c);
                            }
                        } else if (y == 0) {
                            for (int b = x - 1; b <= x + 3; b++) {
                                for (int c = y; c <= y + 1; c++) ifBCDiff1(b, c);
                            }
                        }
                    } else {
                        for (int b = x - 1; b <= x + 3; b++) {
                            for (int c = y - 1; c <= y + 1; c++) ifBCDiff1(b, c);
                        }
                    }
                    break;
            }
        }
        return appendTopSecret(topSecret);
    }

    public int[][] setSize2 (int count) {
        int [][] ship = new int[10][10];
        ship[5][5] = 1;
        return ship;
    }


}
