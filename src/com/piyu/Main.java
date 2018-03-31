package com.piyu;

import java.io.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Board board = new Board();
        board.start();
        System.out.println("User got a call... pausing game");

        try {
            System.out.println("Saving current board state...");

            FileOutputStream outputStream = new FileOutputStream("Snake.ser");
            ObjectOutputStream os = new ObjectOutputStream(outputStream);
            os.writeObject(board);
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(5000);

        try {
            System.out.println("\n\nUser is back... resuming game");
            FileInputStream inputStream = new FileInputStream("Snake.ser");
            ObjectInputStream is = new ObjectInputStream(inputStream);

            board = (Board) is.readObject();
            Board.COUNT = 3;
            board.resume();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
