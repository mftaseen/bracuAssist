import java.io.File;
import java.io.IOException;

public class fileCreator {
    public static void createFile(String filename) throws IOException {
        File file = new File(filename);
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}