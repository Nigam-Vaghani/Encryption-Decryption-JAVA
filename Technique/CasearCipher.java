import java.io.*;
import java.util.Scanner;
public class CasearCipher {
    public static void main(String[] args) throws IOException{
        int key = 3;
        Scanner sc = new Scanner(System.in);
        
        // read input from an file
        FileReader r = new FileReader("input.txt");
        int i;
        String s = "";
        while((i = r.read())!= -1){
            s += (char) i;
        }
        r.close();
        char arr[] = s.toCharArray();

        System.out.print("ORIGINAL MESSAGE: ");
        for(char c : arr){
            System.out.print(c);
        }
        // setting up an ceaser cipher
        for(int z = 0; z<arr.length; z++){
            if(Character.isLetter(arr[z])){
                if(Character.isUpperCase(arr[z])){
                    arr[z] = (char) ('A' + (arr[z] - 'A' + key)%26);
                }
                else if(Character.isLowerCase(arr[z])){
                    arr[z] = (char) ('a' + (arr[z] - 'a' + key)%26);
                }
            }else if(Character.isDigit(arr[z])){
                arr[z] = (char) ('0' + (arr[z] - '0' + key)%10);
            }
        }
        System.out.print("\n--------------------------------------\nENCRYPT MESSAGE: ");
        for(char c : arr){
            System.out.print(c);
        }

        // set in a file
            FileWriter w = new FileWriter("outputCasear.txt");
            w.write(arr);
            w.close();  
        
    }
    
}