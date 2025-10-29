import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.util.*;

public class EncryptedDataChecker {
    private static final String AES_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final byte[] KEY = "1234567890123456".getBytes();
    private static final byte[] IV = "abcdefghijklmnop".getBytes();

    public static boolean main(int id, String pass, String FILE_NAME) throws Exception {
        String[] target = {String.valueOf(id), pass};
        List<String[]> dataList = readData(FILE_NAME);

        boolean found = dataList.stream().anyMatch(entry ->
                entry[0].equals(target[0]) && entry[1].equals(target[1])
        );
        return found;
    }

    private static List<String[]> readData(String FILE_NAME) throws Exception {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(KEY, "AES"), new IvParameterSpec(IV));

        try (CipherInputStream cis = new CipherInputStream(new FileInputStream(file), cipher);
             ObjectInputStream ois = new ObjectInputStream(cis)) {
            return (List<String[]>) ois.readObject();
        } catch (EOFException e) {
            return new ArrayList<>();
        }
    }
}