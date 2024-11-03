
import java.io.IOException;
import technique.CasearCipher;
import technique.RailFence;

public class Main {
    public static void main(String[] args) throws IOException {
        CasearCipher casear = new CasearCipher();
        RailFence rail = new RailFence();

        casear.encrypt("inputOutput/input.txt", "inputOutput/outputCasear.txt", 3);
        casear.decrypt("inputOutput/outputCasear.txt", "inputOutput/decryptedCaesar.txt", 3);
        System.out.println("\n[Casear Cipher DONE]");
        System.out.println("-------------------------------------");

        // Rail Fence Encryption

        rail.encrypt("inputOutput/input.txt", "inputOutput/outputRail.txt", 3);
        System.out.println("[RailFence DONE]");

    }
}
