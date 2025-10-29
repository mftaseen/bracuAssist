import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class reader {
    public static String[] findCourse(String filename, String target) throws IOException, ClassNotFoundException {
        List<String[]> arrays = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    String[] array = (String[]) ois.readObject();
                    arrays.add(array);
                } catch (EOFException e) {
                    break;
                }
            }
        }

        for (String[] array : arrays) {
            if (array.length > 0 && Objects.equals(array[0], target)) {
                return array;
            }
        }

        return null; // Not found
    }

    public static String[][] findSection(String filename, String course, String section) throws IOException, ClassNotFoundException {
        List<String[][]> arrays = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            while (true) {
                try {
                    String[][] array = (String[][]) ois.readObject();
                    arrays.add(array);
                } catch (EOFException e) {
                    break;
                }
            }
        }
        for (String[][] array : arrays) {
            if (array.length > 0 && array[0].length > 0 && Objects.equals(array[0][0], course) && Objects.equals(array[1][0], section)) {
                return array;
            }
        }

        return null;
    }
}
