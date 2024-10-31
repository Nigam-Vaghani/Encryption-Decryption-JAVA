package technique;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RailFence implements cipher {
    public RailFence() {
        System.out.println("-------------------------------------");
    }

    public void encrypt(String inputfile, String outputfile, int key) throws IOException {
        String input = "";
        FileReader r = new FileReader(inputfile);
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

            // Change col and row
            if (flag)
                row++;
            else
                row--;
        }

        // Fetch encrypted message
        StringBuilder output = new StringBuilder();
        for (int k = 0; k < output_arr.length; k++) {
            for (int j = 0; j < output_arr[k].length; j++) {
                if (output_arr[k][j] != '\u0000') {
                    output.append(output_arr[k][j]);
                }
            }
        }

        // Write encrypted message to a file
        FileWriter w = new FileWriter(outputfile);
        w.write(output.toString());
        w.close();
    }

    public void decrypt(String inputFile, String outputFile, int key) throws IOException {
        
    }
}
