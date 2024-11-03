package technique;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CasearCipher implements cipher {
    public CasearCipher() {
        System.out.println("-------------------------------------");
    }

    public String readFileData(String Filename) throws IOException{
        FileReader r = new FileReader(Filename);
        int i = 0;
        String s = "";
        while((i = r.read()) != -1){
            s += (char)i;
        }
        r.close();
        return s;
    }

    public void writeFileData(String outputFile, String s) throws IOException{
        FileWriter w = new FileWriter(outputFile);
        w.write(s);
        w.close();
    }

    public void encrypt(String inputfile, String outputfile, int key) throws IOException {
        String s = readFileData(inputfile);
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
        String data = new String(arr);
        writeFileData(outputfile, data);
    }

    public void decrypt(String inputFile, String outputFile, int key) throws IOException {
        char en_data[] = readFileData(inputFile).toString().toCharArray();
        // System.out.println("\n" +en_data);
        for(int i = 0; i<en_data.length; i++){
            if(Character.isLetter(en_data[i])){
                if(Character.isUpperCase(en_data[i])){
                    en_data[i] = (char)('A' +  (en_data[i] - 'A' - key + 26) %26 );
                }
                else if(Character.isLowerCase(en_data[i])){
                    en_data[i] = (char) ( 'a' + (en_data[i]- 'a' - key + 26) %26);
                }
            }
            else if(Character.isDigit(en_data[i])){
                en_data[i] = (char) ('0' + (en_data[i] - '0' - key + 10) % 10);
            }
        }
        String data = new String(en_data);
        writeFileData(outputFile, data);
    }
}
