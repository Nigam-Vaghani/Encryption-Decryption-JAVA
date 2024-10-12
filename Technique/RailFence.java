import java.io.*;
import java.util.Scanner;
public class RailFence {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int key = 3;

        String input = "";
        FileReader r = new FileReader("input.txt");
        int i;
        while ((i = r.read()) != -1) {
            input += (char) i;
        }
        r.close();
        char arr[] = input.toCharArray();
        char output_arr[][] = new char[key][arr.length];
        boolean flag = false;
        int row = 0;
        int col = 0;
        for (int k = 0; k < arr.length; k++) {
            if (row == 0 || row == key - 1)
                flag = !flag;
            output_arr[row][col++] = arr[k];

            // change col and row
            if (flag)
                row++;
            else
                row--;
        }

        // printing MATRIX text
        for (int k = 0; k < output_arr.length; k++) {
            for (int j = 0; j < output_arr[k].length; j++) {
                System.out.print(output_arr[k][j] + "\t");
            }
            System.out.println();
        }

        System.out.println();
        // fetch Encrypted message
        String output = "";
        for (int k = 0; k < output_arr.length; k++) {
            for (int j = 0; j < output_arr[k].length; j++) {
                if (output_arr[k][j] != '\u0000') {
                    output += output_arr[k][j];
                }
            }
        }
        FileWriter w = new FileWriter("outputRail.txt");
        w.write(output);
        w.close();
    }
}