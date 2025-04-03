import java.util.Scanner;
import java.util.HashSet;

public class Go {
    static String[][] goBoard = new String[9][9];
    static int blackScore = 0, whiteScore = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean player1 = true;
        initializeBoard();

        while (true) {
            printBoard();
            System.out.println("Score - White: " + whiteScore + " -- Black: " + blackScore);
            // Dependent on which player's turn it is.
            System.out.println(player1 ? "It is White (o)'s turn." : "It is Black (x)'s turn.");

            int moveX, moveY;
            while (true){
                System.out.print("Enter X coordinate (0-8): ");
                moveX = scanner.nextInt();
                System.out.print("Enter Y coordinate (0-8): ");
                moveY = scanner.nextInt();

                if (isValidMove(moveX, moveY)){
                    break;
                } else {
                    System.out.println("Out of bounds/Invalid move. Try again.");
                }
            }

            // Place stone
            String currentStone = player1 ? "o" : "x";
            goBoard[moveY][moveX] = currentStone;

            // Check for opponent captures
            String opponentStone = player1 ? "x" : "o";

            // Switch turns
            player1 = !player1;
        }
    }

    private static void initializeBoard(){
        // Initialize the board with empty spaces
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                goBoard[i][j] = " ";
            }
        }
    }

    private static void printBoard(){
        // Print Go Board
        System.out.println("  0 1 2 3 4 5 6 7 8");
        for (int i = 0; i < 9; i++){
            System.out.print(i + " ");
            for (int j = 0; j < 9; j++){
                System.out.print(goBoard[i][j]);
                if (j < 8){
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 8){
                System.out.println("  -----------------");
            }
        }
    }

    private static boolean isValidMove(int x, int y) {
        // Check if the move is within the bounds of the board
        if (x >= 0) {
            if (x < 9) {
                if (y >= 0) {
                    if (y < 9) {
                        if (goBoard[y][x] == " "){ // Check if the position is empty
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    

    
}
