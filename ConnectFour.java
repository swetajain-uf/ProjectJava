import java.util.Scanner;

public class ConnectFour {
    public static void main(String[] args) {
        boolean answer= false;
        Scanner input = new Scanner(System.in);
        System.out.print("What would you like the height of the board to be? ");
        int height = input.nextInt();
        System.out.print("What would you like the length of the board to be? ");
        int length = input.nextInt();
        int b = 0;
        // one of the assumptions is that it has to be greater than 4x4
        //countFourCard(height, length);
        char[][] array = new char[height][length];
        initializeBoard(array);
       // fillboard(array);
        printBoard(array);
        //two strings below not needed
        //String x = "x";
        //String o = "";
        System.out.println();
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");
        for (int i = 0; i < 20; i++) {
            System.out.println();
            System.out.print("Player 1: Which column would you like to choose? ");
            int column = input.nextInt();
            insertChip(array, column, 'x');
            printBoard(array);
            System.out.println();
            answer = checkIfWinner(array, column, height, 'x');
            //new added method to check if this player added the last chip to get connect four (win)
            if (answer == true) {
                System.out.println("Player 1 won the game!");
                System.out.println();
                break;
            }
            //if all cells are filled in, this is the method will return false and print
            System.out.print("Player 2: Which column would you like to choose? ");
            column = input.nextInt();
            insertChip(array, column, 'o');
            printBoard(array);
            boolean answero = checkIfWinner(array, column, height, 'o');
            if (answero == true) {
                System.out.println("Player 2 won the game!");
                break;
            }
            //this only needed for one player, the one who would play the last chip on the board
            answer = checkmate(array, column, height, 'o');
            if (answer==false) {
                System.out.println("Draw. Nobody wins.");
                break;
            }
        }
    }
//used to test - test 8 (insert test), if a chip got "stuck" in array[1][0], and i put a chip in col 0, the chip would go above that array[0][0] would = 'x'.
   /* public static void fillboard(char[][] array){
    array[1][0] = 'x';*/

    public static void printBoard(char[][] array) {
        //needed to initialize it so that row 0 is at the bottom and it counts up
        //printing the board based on the row and columns inputted
        int col = 0;

        for (int row = 0; row < array.length; row++) {
            System.out.println();
            //System.out.print(dashv);
            for (col = 0; col < array[row].length; col++) {
                //array[row][col] = dashv;
                System.out.print(array[row][col] + " ");
            }
        }
        System.out.println();
    }

    public static void initializeBoard(char[][] array) {
        //setting all elements in the row equal to -
        char dashv = '-';

        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                array[row][col] = dashv;
            }
        }
    }

    public static int insertChip(char[][] array, int col, char chipType) {
        // System.out.println(chipType);
        //how to add x or o on top of row 2; ensure that they choose the same column not different
        //possible switch statement for the number of times you enter the method (under the same column), but how to keep track, cant bring in another int
        int numRows = array.length;
        //not sure why this method is not passing through zybooks
        // i have the chip going in based on if the chip below it has a chip or not, then when you get to the row that does have a chip (this is after 1st round) the chip is put in the row above
        int j = 0;
        for (j=0;j<numRows;j++) {
            if(array[j][col] != '-' ) {
                if (j==0) {
                    break;
                }
                array[j-1][col] = chipType;
                break;
            }
        }
        if (j==numRows) {
            array[j-1][col] = chipType;
        }
        return j-1;
    }

    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType) {
        boolean win = false;
        boolean flag = false;
        int keepcount = 1;

        //this is for every column, check all rows
        //named the for loop to be able to do specific things
        outerloop1:
        for (int j = 0; j < array[0].length; j++) {
            keepcount=1;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i][j] == array[i + 1][j] && array[i][j] != '-') {
                    keepcount++;
                    if (keepcount == 4) {
                        win = true;
                        break outerloop1;
                    }
                }
            }
        }
        //this is for every rows, check all columns
        if (win ==false){
            //name the for loop to be able to distinguish which loop to break out of
    outerforloop2:
            for (int r = 0; r < array.length; r++) {
                keepcount = 1;
                for (int j = 0; j < array[r].length - 1; j++) {
                    if (array[r][j] == array[r][j + 1] && array[r][j] != '-') {
                        keepcount++;
                        if (keepcount == 4) {
                            win = true;
                            break outerforloop2;
                        }
                    }
                }
            }
        }

        return win;
    }

    public static boolean checkmate(char[][] array, int col, int row, char chipType) {
        //added this new method, so when the board is full and no one has won, it states Draw. Nobody wins.
        boolean flag = false;

        for (int r = 0; r < array.length; r++) {
            //keepcount = 1;
            for (int j = 0; j < array[0].length; j++) {
                if (array[r][j] == '-') {
                    flag = true;
                }
            }
        }
        //if (flag==false) System.out.println("Draw. Nobody wins.");
        return flag;
    }
}





