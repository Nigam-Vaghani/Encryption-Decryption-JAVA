package technique;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RailFence implements cipher {
    public RailFence() {
        System.out.println("-------------------------------------");
    }

    public char[][] setupRailFence(int key, int len, char arr[]) {
        char data[][] = new char[key][len];
        boolean flag = false;
        int row = 0;
        int col = 0;
        for (int k = 0; k < arr.length; k++) {
            if (row == 0 || row == key - 1)
                flag = !flag;
            data[row][col++] = arr[k];

            // Change col and row
            if (flag)
                row++;
            else
                row--;
        }

        return data;
    }

    public String readFileData(String inputFile) throws IOException {
        String str = "";
        FileReader r = new FileReader(inputFile);
        int i;
        while ((i = r.read()) != -1) {
            str += (char) i;
        }
        r.close();
        return str;
    }

    public void encrypt(String inputfile, String outputfile, int key) throws IOException {
        String input = readFileData(inputfile);
        char arr[] = input.toCharArray();
        // char output_arr[][] = new char[key][arr.length];
        char output_arr[][] = setupRailFence(key, arr.length, arr);

        // Fetch encrypted message
        String output = "";
        for (int k = 0; k < output_arr.length; k++) {
            for (int j = 0; j < output_arr[k].length; j++) {
                if (output_arr[k][j] != '\u0000') {
                    output += output_arr[k][j];
                }
            }
        }

        // Write encrypted message to a file
        FileWriter w = new FileWriter(outputfile);
        w.write(output);
        w.close();
    }

    public void decrypt(String inputFile, String outputFile, int key) throws IOException {
        String data = readFileData(inputFile);
        char arr[] = data.toCharArray();
        char rail[][] = new char[key][arr.length];

        // set * at each fence position
        int row = 0;
        int col = 0;
        boolean flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (row == 0) {
                flag = true;
            }
            if (row == key - 1) {
                flag = false;
            }
            rail[row][i] = '*';
            if (flag) {
                row++;
            } else {
                row--;
            }
        }

        // fill the * with encypted data
        int index = 0;
        for (int i = 0; i < key; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (rail[i][j] == '*' && index < arr.length) {
                    rail[i][j] = arr[index];
                    index++;
                }
            }
        }

        // read the encrypted data from rail or fetch it
        String ans = "";
        row = col = 0;
        flag = false;
        for (int i = 0; i < arr.length; i++) {
            if (row == 0)
                flag = true;
            if (row == key - 1)
                flag = false;
            if (rail[row][i] != '\u0000') {
                ans += rail[row][i];
            }

            if (flag) {
                row++;
            } else {
                row--;
            }
        }

        FileWriter w = new FileWriter(outputFile);
        w.write(ans);
        w.close();
    }
}