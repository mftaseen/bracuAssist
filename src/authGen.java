import java.util.Scanner;

public class authGen {
    public static boolean main() throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n======== General User Authentication ========\n");
        System.out.println("1. New User Registration\n2. Existing User Login");
        System.out.print("Enter your choice: ");
        int choice=sc.nextInt();
        switch (choice) {
            case 1: {
                EncryptedDataWriter.main("genUserSrc.tdf");
                return authGen.main();
            }
            case 2: {
                System.out.print("Input your student ID: ");
                int id = sc.nextInt();
                System.out.print("Input your password: ");
                String pass = sc.next();
                return EncryptedDataChecker.main(id, pass, "genUserSrc.tdf");
            }
            default: {
                System.out.println("Wrong choice");
                return false;
            }
        }
    }
}
