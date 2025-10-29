import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        mainMenu mainMenu = new mainMenu();
        System.out.println("BRACU Assist v1.0.1");
        System.out.print("Type of login:\n A. Administrator Login\n B. General User Login \nInput your choice (A/B): ");
        char in=sc.next().charAt(0);
        if (in=='A') {
            authAdmin authAdmin = new authAdmin();
            boolean auth=authAdmin.main();
            if (!auth) {
                System.err.println("Invalid login. The Program Will Shut Down.");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Program interrupted while waiting.");
                }
                System.exit(0);
            }
            else {
                System.out.println("Administration Authentication Successful!");
                mainMenu.main(1);
            }
        }
        else if (in=='B') {
            boolean auth=authGen.main();
            if (!auth) {
                System.err.println("Invalid login. The Program Will Shut Down.");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.err.println("Program interrupted while waiting.");
                }
                System.exit(0);
            }
            else {
                System.out.println("Authentication Successful!");
                mainMenu.main(2);
            }
        }
    }
}
