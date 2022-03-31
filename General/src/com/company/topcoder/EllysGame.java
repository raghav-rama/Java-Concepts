package com.company.topcoder;

import java.util.Arrays;

public class EllysGame {
    private final char NULL = '\u0000';
    private int rows, columns;
    private final char UP='^',DOWN='v',RIGHT='>',LEFT='<', DOT='.';
    private char flowDirection;

    public static void main(String args[]) {
        EllysGame elly = new EllysGame();
//        String[] board = {">>>><<<<"};
        String[] board = {">>>><<<<"};
        System.out.println(elly.getMax(board));
    }
    int getMax(String[] board) {
        int counter=0;
        rows = board.length;
        columns = board[0].length();
        int[] totalSeconds = new int[rows * columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char ch = board[i].charAt(j);
                String[] boardDuplicate = board.clone();
                flowDirection = NULL;
                totalSeconds[counter++] = getMaxSeconds(boardDuplicate, i, j, ch);
            }
        }
        Arrays.sort(totalSeconds);
        return totalSeconds[rows * columns - 1];
    }

    private int getMaxSeconds(String[] board, int i, int j, char currentChar) {
        int counter = 0;
            while (iInRange(i) && jInRange(j)) {
                if (currentChar == RIGHT) {
                    char[] arr = board[i].toCharArray();
                    arr[j++] = '.';
                    board[i] = String.valueOf(arr);
                    flowDirection = currentChar;
                } else if (currentChar == LEFT) {
                    char[] arr = board[i].toCharArray();
                    arr[j--] = '.';
                    board[i] = String.valueOf(arr);
                    flowDirection = currentChar;
                } else if (currentChar == DOWN) {
                    char[] arr = board[i].toCharArray();
                    arr[j] = '.';
                    board[i++] = String.valueOf(arr);
                    flowDirection = currentChar;
                } else if (currentChar == UP) {
                    char[] arr = board[i].toCharArray();
                    arr[j] = '.';
                    board[i--] = String.valueOf(arr);
                    flowDirection = currentChar;
                } else if(currentChar == DOT) {
                    if(flowDirection == NULL)
                        return 0;
                    else
                        currentChar = flowDirection;
                    continue;
                }
                ++counter;
                if(iInRange(i) && jInRange(j))
                    currentChar = board[i].charAt(j);
            }
        return counter;
    }
    private boolean iInRange(int i){
        return 0<=i && i<rows;
    }
    private boolean jInRange(int j){
        return 0<=j && j<columns;
    }

}