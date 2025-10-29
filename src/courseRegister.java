import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class courseRegister {
    public static void main() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n======== Course Register Menu ========\n");
        System.out.println("1. Add New Course");
        System.out.println("2. Find Existing Course");
        System.out.println("0. Back to Main Menu");
        System.out.print("Input your Choice: ");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {
                courseRegister course = new courseRegister();
                addNewCourse();
                courseRegister.main();
            }
            case 2: {
                System.out.print("Enter Course Code: ");
                String courseCode = sc.next();
                String[] output= reader.findCourse("courseRegSrc.dat", courseCode);
                if (output==null) {
                    System.err.println("Course Not Found");
                } else {
                    System.out.println("Course Code: " + output[0] + "\nCourse Name: " + output[1] + "\nSemester: " + output[2] + "\nDepartment Code: " + output[3] + "\nCredit Hour: "+ output[4] + "\nLab Status: " + output[5]);
                }
                courseRegister.main();
            }
            case 0: {
                mainMenu mainMenu = new mainMenu();
                mainMenu.main(1);
            }
        }
    }
    public static void addNewCourse() throws IOException {
        Scanner input = new Scanner(System.in);
        String[] arr = new String[6];
        System.out.print("Course Code: ");
        arr[0] = input.nextLine();
        System.out.print("Course Name: ");
        arr[1]= input.nextLine();
        System.out.print("Semester: ");
        arr[2]= input.nextLine();
        System.out.print("Department: ");
        arr[3]= input.nextLine();
        System.out.print("Credit Hour: ");
        arr[4]= input.nextLine();
        System.out.print("Does this course has lab? (Y/N) ");
        arr[5]= input.nextLine();
        writer.writeArray1d("courseRegSrc.dat", arr);
    }
}

