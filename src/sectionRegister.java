import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class sectionRegister {
    public static void main() throws Exception {
        Scanner input = new Scanner(System.in);
        mainMenu mainMenu = new mainMenu();
        System.out.println("\n======== Section Register Menu ========\n");
        System.out.println("1. Add New Section");
        System.out.println("2. Find Existing Section");
        System.out.println("0. Back to Main Menu");
        System.out.print("Input Your Choice: ");
        int choice = input.nextInt();
        switch (choice) {
            case 1: {
                newSection();
                sectionRegister.main();
            }
            case 2: {
                System.out.print("Enter Course Code: ");
                String course = input.next();
                System.out.print("Enter Section no.: ");
                String section = input.next();
                String[][] output = reader.findSection("secRegSrc.dat", course, section);
                System.out.println("Course Details: " + Arrays.toString(output[0]) + "\nSection Details: " + Arrays.toString(output[1]) + "\nClass 1 Details: " + Arrays.toString(output[2]) + "\nClass 2 Details: " + Arrays.toString(output[3]) + "\nClass 3 Details: " + Arrays.toString(output[4]) + "\nLab Details: " + Arrays.toString(output[5]));
                sectionRegister.main();
            }
            case 0: mainMenu.main(0);
        }
    }

    public static void newSection() throws IOException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        String[][] arr = new String[6][6];
        System.out.print("Course Code: ");
        String courseCode = input.nextLine();
        arr[0] = reader.findCourse("courseRegSrc.dat", courseCode);
        System.out.print("Section No: ");
        arr[1][0] = input.nextLine();
        System.out.print("Faculty Code: ");
        arr[1][1] = input.nextLine();
        System.out.print("Faculty Name: ");
        arr[1][2] = input.nextLine();
        System.out.print("Faculty Designation: ");
        arr[1][3] = input.nextLine();
        System.out.print("Faculty Email: ");
        arr[1][4] = input.nextLine();
        System.out.print("Number of classes per week (1/2/3): ");
        arr[1][5] = input.nextLine();
        for (int i = 1; i <= (arr[1][5].codePointAt(0) - 48); i++) {
            System.out.println("\nClass " + i + " Details out of " + (arr[1][5].codePointAt(0) - 48) + " Classes:\n");
            System.out.print("Day: ");
            arr[i + 1][0] = input.nextLine();
            System.out.print("Start Time: ");
            arr[i + 1][1] = input.nextLine();
            System.out.print("End  Time: ");
            arr[i + 1][2] = input.nextLine();
            System.out.print("Duration: ");
            arr[i + 1][3] = input.nextLine();
            System.out.print("Classroom no.: ");
            arr[i + 1][4] = input.nextLine();
        }
        if (arr[0][5].equals("Y")) {
            System.out.println("\n======== LAB Details ========\n");
            System.out.println("Lab Section: ");
            arr[5][0] = input.nextLine();
            System.out.println("Start Time: ");
            arr[5][1] = input.nextLine();
            System.out.println("End  Time: ");
            arr[5][2] = input.nextLine();
            System.out.println("Duration: ");
            arr[5][3] = input.nextLine();
            System.out.println("Classroom no.: ");
            arr[5][4] = input.nextLine();
        }
        writer.writeArray2d("secRegSrc.dat", arr);
    }
}