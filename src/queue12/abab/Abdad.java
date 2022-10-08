package queue12.abab;

import java.util.Scanner;

public class Abdad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int arr[][] = new int[n][m];
        int res[][] = new int[n + 2][m + 2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; i++) {
                arr[i][j] = scan.nextInt();
                if(arr[i][j] == 1)
                    res[i + 1][j + 1] = 9;
            }
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(res[i + 1][j + 1] == 0) {
                    for(int k = i; k < i + 3; k++) {
                        for(int r = j; r < j + 3; r++) {
                            res[i + 1][j + 1] += res[k][r] / 9;
                        }
                    }
                }
            }
        }
        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; i++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        scan.close();
    }
}
