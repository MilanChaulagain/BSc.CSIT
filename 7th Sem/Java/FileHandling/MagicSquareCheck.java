package FileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MagicSquareCheck {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];

        // Step 1: Read from file
        try (Scanner sc = new Scanner(new File("magic.txt"))) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (sc.hasNextInt()) {
                        matrix[i][j] = sc.nextInt();
                    } else {
                        System.out.println("Invalid file format!");
                        return;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: magic.txt");
            return;
        }

        // Step 2: Check magic square property
        int sum = 0;
        for (int j = 0; j < 3; j++) {
            sum += matrix[0][j]; // sum of first row
        }

        boolean isMagic = true;

        // Check rows
        for (int i = 1; i < 3; i++) {
            int rowSum = 0;
            for (int j = 0; j < 3; j++) {
                rowSum += matrix[i][j];
            }
            if (rowSum != sum) {
                isMagic = false;
                break;
            }
        }

        // Check columns
        if (isMagic) {
            for (int j = 0; j < 3; j++) {
                int colSum = 0;
                for (int i = 0; i < 3; i++) {
                    colSum += matrix[i][j];
                }
                if (colSum != sum) {
                    isMagic = false;
                    break;
                }
            }
        }

        // Check diagonals
        if (isMagic) {
            int diag1 = matrix[0][0] + matrix[1][1] + matrix[2][2];
            int diag2 = matrix[0][2] + matrix[1][1] + matrix[2][0];
            if (diag1 != sum || diag2 != sum) {
                isMagic = false;
            }
        }

        // Step 3: Output result
        if (isMagic) {
            System.out.println("The matrix is a magic square with constant sum: " + sum);
        } else {
            System.out.println("The matrix is NOT a magic square.");
        }
    }
}

