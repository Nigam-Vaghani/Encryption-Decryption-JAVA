package technique;

public interface cipher {
    void encrypt(String inputFile, String outputFile, int key) throws Exception;
    void decrypt(String inputFile, String outputFile, int key) throws Exception;
}
