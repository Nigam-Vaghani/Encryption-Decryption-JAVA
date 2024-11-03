import java.io.IOException;
import technique.CasearCipher;
import technique.RailFence;

public class Main {
    static int key = 3;
    public static void main(String[] args) throws IOException {
        
        CasearCipher casear = new CasearCipher();
        RailFence rail = new RailFence();

        casear.encrypt("inputOutput/input.txt", "inputOutput/outputCasear.txt", key);
        casear.decrypt("inputOutput/outputCasear.txt", "inputOutput/decryptedCaesar.txt", key);
        System.out.println("\n[Casear Cipher DONE]");
        System.out.println("-------------------------------------");

        // Rail Fence Encryption

        rail.encrypt("inputOutput/input.txt", "inputOutput/outputRail.txt", 3);
        rail.decrypt("inputOutput/outputRail.txt", "inputOutput/decryptedRail.txt", key);
        System.out.println("[RailFence DONE]");
    }
}