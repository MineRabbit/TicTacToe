import java.util.Scanner;

public class TicTacToe {

    public static void PrintBoard(char[][] board) {
        for (int i = 0; i < 2; i++) {
            System.out.println(" " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " ");
            System.out.println("-----------");
        }
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2] + " ");
    }

    public static boolean update(char[][] board, String input, char player) {
        int row;
        int column;
        try {
            row = (int) input.charAt(0) - 48 - 1;
            column = (int) input.charAt(2) - 48 - 1;
        } catch (Exception e) {
            return false;
        }

        if (row < 0 || row > 2 || column < 0 || column > 2 || board[row][column] != ' ') {
            return false;
        } else {
            board[row][column] = player;
            return true;
        }

    }

    public static boolean CheckForWin(char[][] board, char player) {
        if (board[0][0] == player && board[0][1] == player && board[0][2] == player) {
            // Lign 0
            PrintBoard(board);
            System.out.println(player + " wins !");
            return true;
        }
        if (board[1][0] == player && board[1][1] == player && board[1][2] == player) {
            // Lign 1
            PrintBoard(board);
            System.out.println(player + " wins !");
            return true;
        }
        if (board[2][0] == player && board[2][1] == player && board[2][2] == player) {
            // Lign 2
            PrintBoard(board);
            System.out.println(player + " wins !");
            return true;
        }
        if (board[0][0] == player && board[1][0] == player && board[2][0] == player) {
            // Column 0
            PrintBoard(board);
            System.out.println(player + " wins !");
            return true;
        }
        if (board[0][1] == player && board[1][1] == player && board[2][1] == player) {
            // Column 1
            PrintBoard(board);
            System.out.println(player + " wins !");
            return true;
        }
        if (board[0][2] == player && board[1][2] == player && board[2][2] == player) {
            // Column 2
            PrintBoard(board);
            System.out.println(player + " wins !");
            return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            // Diagonal 1
            PrintBoard(board);
            System.out.println(player + " wins !");
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            // Diagonal 2
            PrintBoard(board);
            System.out.println(player + " wins !");
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] playboard = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
        boolean playing = true;
        char player;
        Scanner scan = new Scanner(System.in);

        for (int turn = 0; turn < 9 && playing; turn++) {
            if (turn % 2 == 0) {
                player = 'X';
            } else {
                player = 'O';
            }
            PrintBoard(playboard);
            System.out.println(player + " turn (row:column) from 1 to 3 : ");
            String input = scan.nextLine();
            while (!update(playboard, input, player)) {
                System.out.println("Invalid input");
                System.out.println(player + " turn (row:column) from 1 to 3 : ");
                input = scan.nextLine();
            }
            playing = !CheckForWin(playboard, player);
        }
        scan.close();
    }
}