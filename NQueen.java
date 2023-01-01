import java.util.Arrays;
import java.util.Scanner;

public class NQueen
{
    // Function to check if two queens threaten each other or not
    private static boolean isSafe(char[][] chess, int row, int col)
    {
        // return false if two queens share the same column
        for (int i = 0; i < row; i++)
        {
            if (chess[i][col] == 'Q') {
                return false;
            }
        }

        // return false if two queens share the same `\` diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
        {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        // return false if two queens share the same `/` diagonal
        for (int i = row, j = col; i >= 0 && j < chess.length; i--, j++)
        {
            if (chess[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    private static void printSolution(char[][] chess)
    {
        for (char[] chars: chess) {
            System.out.println(Arrays.toString(chars).replaceAll(",", " "));
        }
        System.out.println();
    }

    private static void nQueen(char[][] chess, int row)
    {
        // if `N` queens are placed successfully, print the solution
        if (row == chess.length)
        {
            printSolution(chess);
            return;
        }

        // place queen at every square in the current row `r`
        // and recur for each valid movement
        for (int i = 0; i < chess.length; i++)
        {
            // if no two queens threaten each other
            if (isSafe(chess, row, i))
            {
                // place queen on the current square
                chess[row][i] = 'Q';

                // recur for the next row
                nQueen(chess, row + 1);

                // backtrack and remove the queen from the current square
                chess[row][i] = '–';
            }
        }
    }

    public static void main(String[] args)
    {
        // `N × N` chessboard
        Scanner sc=new Scanner(System.in);
        int N = sc.nextInt();

        // `mat[][]` keeps track of the position of queens in
        // the current configuration
        char[][] chess = new char[N][N];

        // initialize `mat[][]` by `-`
        for (int i = 0; i < N; i++) {
            Arrays.fill(chess[i], '–');
        }

        nQueen(chess, 0);
    }
}