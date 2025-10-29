import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.util.*;

public class EncryptedDataWriter {
    private static final String AES_TRANSFORMATION = "AES/CBC/PKCS5Padding";
    private static final byte[] KEY = "1234567890123456".getBytes(); // 16-byte key
    private static final byte[] IV = "abcdefghijklmnop".getBytes(); // 16-byte IV

    public static void main(String FILE_NAME) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        int id=0;
        for (;!flag;) {
            System.out.print("Enter Student ID: ");
            id = scanner.nextInt();
            if ((((id / 10000000) > 9) && ((id / 100000000) == 0)) || ((0< (id / 1000000000)) && ((id / 1000000000) <10))) {
                flag = true;
            }
            else {
                System.out.println("Invalid Student ID");
            }
        }


        scanner.nextLine();
        System.out.print("Enter Password: ");
        String pass = scanner.nextLine();
        if(FILE_NAME.equals("genUserSrc.tdf")) {
            indUserProfile.profileCreator(id);
        }

        String[] newEntry = {String.valueOf(id), pass};
        List<String[]> dataList = readData(FILE_NAME);

        dataList.add(newEntry);
        writeData(dataList, FILE_NAME);
        System.out.println("New User Registration Successful\n");
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

    private static void writeData(List<String[]> dataList, String FILE_NAME) throws Exception {
        Cipher cipher = Cipher.getInstance(AES_TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(KEY, "AES"), new IvParameterSpec(IV));

        try (CipherOutputStream cos = new CipherOutputStream(new FileOutputStream(FILE_NAME), cipher);
             ObjectOutputStream oos = new ObjectOutputStream(cos)) {
            oos.writeObject(dataList);
        }
    }
}