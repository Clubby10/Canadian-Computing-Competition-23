// CCC Promblem S2: Symmetric Mountains
// Lucas Dunn

package S2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S2 {
    public static void main(String[] args) {
        Scanner fileReader;
        File file;
        String fileName = "/Users/clubby/Desktop/Canadian Computing Competition/S2/S2data.dat";

        int mnts;
        int[] mntsHeight;

        try {
            file = new File(fileName);
            fileReader = new Scanner(file);

            mnts = fileReader.nextInt();
            mntsHeight = new int[mnts];

            for (int i = 0; i < mnts; i++) {
                mntsHeight[i] = fileReader.nextInt();
            }

        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found");

            // Default Data
            mnts = 4;
            mntsHeight = new int[]{5, 6, 7, 8};

            System.out.println("Using default data: " + mnts);
        }

        System.out.println(mnts);

        int[][] memo = new int[mnts][mnts];
        for (int i = 0; i < mnts; i++) {
            for (int j = 0; j < mnts; j++) {
                memo[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < mnts; i++) {
            memo[i][i] = 0;

            if (i < mnts - 1) {
                memo[i][i + 1] = Math.abs(mntsHeight[i] - mntsHeight[i + 1]);
            }
        }

        for (int k = 2; k < mnts; k++) {
            for (int i = 0; i + k < mnts; i++) {
                memo[i][i + k] = memo[i + 1][i + k - 1] + Math.abs(mntsHeight[i] - mntsHeight[i + k]);
            }
        }

        int[] res = new int[mnts];
        for (int i = 0; i < mnts; i++) {
            res[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < mnts; i++) {
            for (int j = i; j < mnts; j++) {
                res[j - i] = Math.min(memo[i][j], res[j - i]);
            }
        }

        for (int x : res) {
            System.out.print(x + " ");
        }

        System.out.println();
    }
}
