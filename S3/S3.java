// CCC Promblem S3: Palindromic Poster
// Lucas Dunn 

package S3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class S3 {
    public static void main(String[] args) {
        Scanner fileReader;
        File file;
        String fileName = "/Users/clubby/Desktop/Canadian Computing Competition/S3/S3data.dat";

        int N, M, R, C;

        try {
            file = new File(fileName);
            fileReader = new Scanner(file);

            N = fileReader.nextInt();
            M = fileReader.nextInt();
            R = fileReader.nextInt();
            C = fileReader.nextInt();

        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " not found");

            // Default Data 4 5 1 2
            N = 4; M = 5; R = 1; C = 2;

            System.out.println("Using default data: " + N + " " + M + " " + R + " " + C);
        }

        System.out.println(N + " " + M + " " + R + " " + C);

        if (R >= N || C >= M) {
            System.out.println("IMPOSSIBLE");
        } else {
            System.out.println("POSSIBLE");

            char[][] poster = new char[N][M];

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < M / 2; j++) {
                    poster[i][j] = poster[i][M - 1 - j] = 'a';
                }
            }

            for (int j = 0; j < C; j++) {
                for (int i = 0; i < N / 2; i++) {
                    poster[i][j] = poster[N - 1 - i][j] = 'a';
                }
            }

            char filler = 'b';

            if (R == 2) {
                for (int j = 0; j < M / 2; j++) {
                    poster[1][j] = poster[1][M - 1 - j] = 'a';
                }
            }

            for (int i = R; i < N; i++) {
                for (int j = C; j < M; j++) {
                    poster[i][j] = filler;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    System.out.print(poster[i][j]);
                }
                System.out.println();
            }
        }
    }
}
