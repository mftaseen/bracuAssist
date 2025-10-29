import java.util.Scanner;
public class userConfig {
    public static void main() throws Exception {
        System.out.println("\n======== User Configuration ========\n");
        System.out.println("1. Administrator User Configuration");
        System.out.print("Input your choice:");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {
                adminUserConfig();
                break;
            }
        }
    }
    public static void adminUserConfig() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n======== Administrator User Configuration ========\n");
        System.out.println("1. New Administrator User Registration");
        System.out.println("2. See All Registered Administrator Users");
        System.out.println("3. See All General User Registration:");
        System.out.println("0. Back to Main Menu");
        System.out.print("Input your choice:");
        int choice = sc.nextInt();
        switch (choice) {
            case 1: {
                EncryptedDataWriter.main("admUserSrc.tdf");
                break;
            }
            case 2: {
                EncryptedDataReader.main("admUserSrc.tdf");
                break;
            }
            case 3: {
                EncryptedDataReader.main("genUserSrc.tdf");
                break;
            }
            case 0: {
                mainMenu mainMenu = new mainMenu();
                mainMenu.main(1);
            }
        }
    }
}
