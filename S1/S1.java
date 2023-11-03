// CCC Promblem S1: Trianglane
// Lucas Dunn

package S1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S1 {
    public static void main(String[] args) {
        Scanner fileReader;
        File file;
        String fileName = "/Users/clubby/Desktop/Canadian Computing Competition/S1/S1data.dat";

        int c;
        int[] row1;
        int[] row2;
        int totalTape = 0;

        try {
            file = new File(fileName);
            fileReader = new Scanner(file);

            c = fileReader.nextInt();
            row1 = new int[c];
            row2 = new int[c];

            for (int a = 0; a < c; a++) {
                row1[a] = fileReader.nextInt();

                if (row1[a] == 1) {
                    totalTape += 3;
                }
            }

            for (int a = 0; a < c; a++) {
                row2[a] = fileReader.nextInt();

                if (row2[a] == 1) {
                    totalTape += 3;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found");

            // Default Data
            c = 5;
            row1 = new int[]{1, 0, 1, 0, 1};
            row2 = new int[]{1, 1, 0, 0, 1};

            System.out.println("Using default data: " + c);
        }

        for (int a = 0; a < c - 1; a++) {
            if (row1[a] == 1 && row1[a + 1] == 1) {
                totalTape -= 2;
            }
            if (row2[a] == 1 && row2[a + 1] == 1) {
                totalTape -= 2;
            }
        }

        for (int a = 0; a < c; a += 2) {
            if (row1[a] == 1 && row2[a] == 1) {
                totalTape -= 2;
            }
        }

        System.out.println(totalTape);
    }
}
