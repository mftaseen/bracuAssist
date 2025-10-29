import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.File;

class writer {
    public static void writeArray2d(String filename, String[][] array) throws IOException {
        fileCreator.createFile(filename);
        File file = new File(filename);
        boolean append = file.exists() && file.length() > 0;
        try (FileOutputStream fos = new FileOutputStream(file, true);
             ObjectOutputStream oos = append ? new AppendableObjectOutputStream(fos) : new ObjectOutputStream(fos)) {
            oos.writeObject(array);
            System.out.println("New Section Registration Successful");
        }
    }

    public static void writeArray1d(String filename, String[] array) throws IOException {
        fileCreator.createFile(filename);
        File file = new File(filename);
        boolean append = file.exists() && file.length() > 0;
        try (FileOutputStream fos = new FileOutputStream(file, true);
             ObjectOutputStream oos = append ? new AppendableObjectOutputStream(fos) : new ObjectOutputStream(fos)) {
            oos.writeObject(array);
            System.out.println("New Course Registration Successful");
        }
    }

    static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset(); // Avoid writing a new header
        }
    }
}
