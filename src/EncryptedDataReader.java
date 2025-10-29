import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.util.*;

public class EncryptedDataReader {
    private static final byte[] KEY = "1234567890123456".getBytes();
    private static final byte[] IV = "abcdefghijklmnop".getBytes();
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public static void main(String FILE_NAME) throws Exception {
        try {
            List<String[]> dataList = readEncryptedData(FILE_NAME);
            System.out.println("Registered Administrator User: ");
            for (String[] entry : dataList) {
                if (entry.length > 0) {
                    System.out.println(entry[0]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static List<String[]> readEncryptedData(String FILE_NAME) throws Exception {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKeySpec keySpec = new SecretKeySpec(KEY, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(IV);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);

        try (CipherInputStream cis = new CipherInputStream(new FileInputStream(file), cipher);
             ObjectInputStream ois = new ObjectInputStream(cis)) {
            return (List<String[]>) ois.readObject();
        } catch (EOFException e) {
            return new ArrayList<>();
        }
    }
}