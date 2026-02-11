import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'matrixRotation' function below.
     *
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY matrix
     *  2. INTEGER r
     */

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
    // Write your code here
    int m = matrix.size();
        int n = matrix.get(0).size();
        
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = matrix.get(i).get(j);
            }
        }
        
        int layers = Math.min(m, n) / 2;
        
        for (int layer = 0; layer < layers; layer++) {
            List<Integer> currentLayer = new ArrayList<>();
            
            for (int j = layer; j < n - layer; j++) {
                currentLayer.add(arr[layer][j]);
            }
            
            for (int i = layer + 1; i < m - layer; i++) {
                currentLayer.add(arr[i][n - 1 - layer]);
            }
            
            for (int j = n - 2 - layer; j >= layer; j--) {
                currentLayer.add(arr[m - 1 - layer][j]);
            }
            
            for (int i = m - 2 - layer; i > layer; i--) {
                currentLayer.add(arr[i][layer]);
            }
            
            int layerSize = currentLayer.size();
            int effectiveRotation = r % layerSize;
            
            if (effectiveRotation > 0) {
                List<Integer> rotated = new ArrayList<>();
                for (int i = effectiveRotation; i < layerSize; i++) {
                    rotated.add(currentLayer.get(i));
                }
                for (int i = 0; i < effectiveRotation; i++) {
                    rotated.add(currentLayer.get(i));
                }
                currentLayer = rotated;
            }
            
            int index = 0;
            
            for (int j = layer; j < n - layer; j++) {
                arr[layer][j] = currentLayer.get(index++);
            }
            
            for (int i = layer + 1; i < m - layer; i++) {
                arr[i][n - 1 - layer] = currentLayer.get(index++);
            }
            
            for (int j = n - 2 - layer; j >= layer; j--) {
                arr[m - 1 - layer][j] = currentLayer.get(index++);
            }
            
            for (int i = m - 2 - layer; i > layer; i--) {
                arr[i][layer] = currentLayer.get(index++);
            }
        }
        
        printMatrix(arr);
    }
    
    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                if (j < matrix[0].length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(firstMultipleInput[0]);

        int n = Integer.parseInt(firstMultipleInput[1]);

        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        Result.matrixRotation(matrix, r);

        bufferedReader.close();
    }
}
