package TicTacToe;

import java.util.Scanner;

public class TicTacToeMain {
    static int[][] grid = new int[3][3];
    static Scanner input = new Scanner(System.in);
    static final int ROW = 0, COL = 1;
    static boolean player1Turn = true;


    public static void main(String[] args) {
        initiateBoard();
        System.out.println("START!");
        while (true){
            printBoard();
            getUserInput();
            if(checkWin()){
                printBoard();
                break;
            }
        }
    }

    private static boolean checkWin(){
        if((grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2] && grid[0][0] == 1) ||
                (grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2] && grid[1][0] == 1) ||
                (grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2] && grid[2][0] == 1) ||
                (grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2] && grid[0][2] == 1) ||
                (grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2] && grid[1][2] == 1) ||
                (grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2] && grid[2][2] == 1) ||
                (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] == 1) ||
                (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] == 1)){
            System.out.println("Player1 Won!");
            return true;
        }if((grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2] && grid[0][0] == 2) ||
                (grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2] && grid[1][0] == 2) ||
                (grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2] && grid[2][0] == 2) ||
                (grid[0][0] == grid[0][1] && grid[0][1] == grid[0][2] && grid[0][2] == 2) ||
                (grid[1][0] == grid[1][1] && grid[1][1] == grid[1][2] && grid[1][2] == 2) ||
                (grid[2][0] == grid[2][1] && grid[2][1] == grid[2][2] && grid[2][2] == 2) ||
                (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] == 2) ||
                (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] == 2)){
            System.out.println("Player2 Won!");
            return true;
        }
        return false;
    }
    private static void guide(){
        System.out.println("Guide:");
        System.out.print("1");
        System.out.print("  |  ");
        System.out.print("2");
        System.out.print("  |  ");
        System.out.println("3");
        System.out.println("-------------");
        System.out.print("4");
        System.out.print("  |  ");
        System.out.print("5");
        System.out.print("  |  ");
        System.out.println("6");
        System.out.println("-------------");
        System.out.print("7");
        System.out.print("  |  ");
        System.out.print("8");
        System.out.print("  |  ");
        System.out.println("9");
    }

    private static void getUserInput() {
        if(player1Turn){
            System.out.println("Where do you want to place your marker, P1?");
        }else{
            System.out.println("Where do you want to place your marker, P2?");
        }
        String answer = input.nextLine();
        int ans = parseIntPlus(answer);
        if(ans == 1){
            answer = "0,0";
        }else if(ans == 2){
            answer = "0,1";
        }else if(ans == 3){
            answer = "0,2";
        }else if(ans == 4){
            answer = "1,0";
        }else if(ans == 5){
            answer = "1,1";
        }else if(ans == 6){
            answer = "1,2";
        }else if(ans == 7){
            answer = "2,0";
        }else if(ans == 8){
            answer = "2,1";
        }else if(ans == 9) {
            answer = "2,2";
        }
        if(ans % 10 == ans && ans != 0){
            int[] loc = parseInput(answer);
            placingMarker(loc);
        }
    }

    private static void placingMarker(int[] loc) {
        if(grid[loc[ROW]][loc[COL]] == 0 && isValid(loc)){
            if (player1Turn) {
                grid[loc[ROW]][loc[COL]] = 1;
            }else{
                grid[loc[ROW]][loc[COL]] = 2;
            }
            player1Turn = !player1Turn;
        }else{
            System.out.println("Cannot play there.");
            if(player1Turn)
                System.out.println("Player 1 try again");
            else
                System.out.println("Player 2 try again");
        }
    }

    private static boolean isValid(int[] loc){
        return loc[ROW] >= 0 && loc[ROW] < grid.length &&
                loc[COL] >= 0 && loc[COL] < grid[0].length;
    }

    private static int[] parseInput(String answer) {
        int[] loc = new int[2];
        answer = answer.replace(",","");
        int x = Integer.parseInt(answer.trim());
        loc[0] = x/10;
        loc[1] = x%10;
        return loc;
    }
    private static int parseIntPlus(String s){
        int n = 0;
        if(!s.equals("help")){
            n = Integer.parseInt(s);
        }else if(s.equals("help")){
            guide();
       }
        return n;
    }
    public static void initiateBoard(){
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                grid[i][j] = 0;
            }
        }
    }

    private static void printBoard() {
        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j != grid[0].length - 1) {
                    if(grid[i][j] == 0){
                        System.out.print("⬜");
                        System.out.print("  |  ");
                    }else if(grid[i][j] == 1){
                        System.out.print("❌");
                        System.out.print("  |  ");
                    }else if(grid[i][j] == 2){
                        System.out.print("⚫");
                        System.out.print("  |  ");
                    }
                }else{
                    if(grid[i][j] == 0){
                        System.out.print("⬜");
                    }else if(grid[i][j] == 1){
                        System.out.print("❌");
                    }else if(grid[i][j] == 2){
                        System.out.print("⚫");
                    }
                }
            }
            System.out.println();
            if(i != grid.length-1){
                System.out.println("---------------");
            }
        }
    }
}
