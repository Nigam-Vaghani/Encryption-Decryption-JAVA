package technique;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CasearCipher implements cipher {
    public CasearCipher() {
        System.out.println("-------------------------------------");
    }

    public void encrypt(String inputfile, String outputfile, int key) throws IOException {
        // Read input from a file
        FileReader r = new FileReader(inputfile);
        int i;
        StringBuilder s = new StringBuilder();
        while ((i = r.read()) != -1) {
            s.append((char) i);
        }
        r.close();
        
        char arr[] = s.toString().toCharArray();
        System.out.print("ORIGINAL MESSAGE: ");
        for (char c : arr) {
            System.out.print(c);
        }

        // Caesar Cipher Encryption
        for (int z = 0; z < arr.length; z++) {
            if (Character.isLetter(arr[z])) {
                if (Character.isUpperCase(arr[z])) {
                    arr[z] = (char) ('A' + (arr[z] - 'A' + key) % 26);
                } else if (Character.isLowerCase(arr[z])) {
                    arr[z] = (char) ('a' + (arr[z] - 'a' + key) % 26);
                }
            } else if (Character.isDigit(arr[z])) {
                arr[z] = (char) ('0' + (arr[z] - '0' + key) % 10);
            }
        }

        // Write encrypted message to a file
        FileWriter w = new FileWriter(outputfile);
        w.write(arr);
        w.close();
    }

    public void decrypt(String inputFile, String outputFile, int key) throws IOException {
        // Add decryption logic for Caesar cipher if needed
    }
}
