package com.piyu;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by Priya on 3/31/2018.
 */
public class Board implements Serializable {
    static public int COUNT = 3;
    private Snake _snake;
    private final int MAX = 15;
    private final int[][] BOARD = new int[MAX][MAX];

    public void start(){
        LinkedList<Coordinate> coordinates = new LinkedList<>();
        coordinates.addFirst(new Coordinate(MAX/2, MAX/2));
        coordinates.addFirst(new Coordinate(MAX/2, MAX/2+1));
        coordinates.addFirst(new Coordinate(MAX/2, MAX/2+2));

        _snake = new Snake(coordinates, Direction.RIGHT);
        initialize();
        refresh();
    }

    public void resume(){
        initialize();
        refresh();
    }

    private void initialize(){
        for (int i=0; i<MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                BOARD[i][j] = 0;
            }
        }

        refreshSnake();
    }

    private boolean refreshSnake() {
        try {
            for (Coordinate coordinate : _snake.getCoordinateList()) {
                BOARD[coordinate.get_row()][coordinate.get_column()] = 1;
            }
        }catch (ArrayIndexOutOfBoundsException exception){
            System.out.println("\t\tGAME OVER");
            return false;
        }
        return true;
    }

    private void refresh(){
        COUNT--;
        printState();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Coordinate tail = _snake.move();
        BOARD[tail.get_row()][tail.get_column()] = 0;

        if(refreshSnake() && COUNT > 0) {
            if(COUNT == 2){
                _snake.increaseSize();
            }
            refresh();
        }
    }

    private void printState() {
        for (int i=0; i<MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                System.out.print(BOARD[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }
}
