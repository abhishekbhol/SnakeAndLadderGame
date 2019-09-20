package com.abhishek;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static int BOARD_SIZE = 30;
    private static int[] board;
    private static List<Player> players;

    public static void main(String[] args) {

        initializeBoard();
        initializeSnakes();
        initializeLadders();
        initializePlayers();

        boolean winner = false;
        Player champion = null;
        int turn = 0;

        champion = getWinner(winner, champion, turn);

        System.out.println("Winner is : " + champion.getName());
    }

    private static Player getWinner(boolean winner, Player champion, int turn) {
        while(!winner)
        {
            System.out.println(players.get(turn).getName() +  " turn");

            int num = GetRandomNumber();
            System.out.println(players.get(turn).getName() +  " rolled dice and got : "+ num);

            int newPosition = players.get(turn).getCurrentPosition() + num;

            if(newPosition >= BOARD_SIZE)
            {
                winner = true;
                champion =  players.get(turn);
                break;
            }

            if(board[newPosition] != -1)
            {
                if(board[newPosition] > newPosition)
                {
                    //ladder
                    System.out.println("Congrats !! "+players.get(turn).getName() +  " you got ladder and reached " +  board[newPosition]);
                }
                else
                {
                    //Snake
                    System.out.println("Oh no , "+players.get(turn).getName() +  " you got snake and dropped to " +  board[newPosition]);
                }
                newPosition = board[newPosition];

            }
            else
            {
                System.out.println(players.get(turn).getName() +  " new position : "+ newPosition);
            }

            players.get(turn).setCurrentPosition(newPosition);
            turn = (turn + 1) % players.size();
        }
        return champion;
    }

    private static void initializePlayers()
    {
        players = new ArrayList<Player>();

        players.add(new Player("Abhi", 0));
        players.add(new Player("Mona", 0));
    }

    private static int GetRandomNumber()
    {
        Random random = new Random();
        return random.ints(1,7).findFirst().getAsInt();
    }

    private static void initializeBoard() {
        board = new int[BOARD_SIZE];
        for(int i=0; i < BOARD_SIZE; i++)
        {
            board[i] = -1;
        }
    }

    private static void initializeSnakes() {
        board[17] = 4;
        board[21] = 9;
        board[19] = 7;
        board[27] = 1;
    }

    private static void initializeLadders() {
        board[3] = 22;
        board[5] = 8;
        board[20] = 29;
        board[11] = 26;
    }
}
