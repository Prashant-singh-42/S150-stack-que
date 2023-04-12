import java.util.*;
public class Main {
    public static boolean checkCol(int[][] arr, int n, int col){
        for (int i = 0; i < n; i++) {
            if (i != col && arr[i][col] != 1) return false;
        }
        return true;
    }

    public static void checkRow(int[][] arr, int n){
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 1) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                if (checkCol(arr, n, i)) {System.out.println(i); return;}
            }
        }
        System.out.println( "No Celebrity");
    }

    public static void KBCeleb(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                System.out.println(i);
                return;
            }
        }
        System.out.println("No Celebrity");
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        // for (int i = 0; i < n; i++) {
        //     int temp = 0;
        //     for (int j = 0; j < n; j++) {
        //         temp += in.nextInt();
        //     }
        //     arr[i] = temp;
        // }
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }
        // KBCeleb(arr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        checkRow(arr, n);
    }
}
