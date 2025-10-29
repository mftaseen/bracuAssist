import java.util.Scanner;
public class mainMenu {
    public void main(int loginType) throws Exception {
        switch (loginType) {
            case 1: {
                Scanner sc = new Scanner(System.in);
                System.out.println("\n======== Administrator Main Menu ========\n");
                System.out.println("1. Course Register");
                System.out.println("2. Section Register");
                System.out.println("3. User Configurarion");
                System.out.print("Input your Choice: ");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        courseRegister courseRegister = new courseRegister();
                        courseRegister.main();
                        break;
                    }
                    case 2: {
                        sectionRegister.main();
                        break;
                    }
                    case 3: {
                        userConfig.main();
                        break;
                    }
                }
                mainMenu mainMenu = new mainMenu();
                mainMenu.main(1);
            }
            case 2: {
                Scanner sc = new Scanner(System.in);
                System.out.println("\n======== Main Menu ========\n");
                System.out.print("Input your Choice: ");
                int choice = sc.nextInt();
                switch (choice) {

                }
                mainMenu mainMenu = new mainMenu();
                mainMenu.main(2);
            }
        }
    }
}
