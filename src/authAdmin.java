import java.util.Scanner;

public class authAdmin {
    public boolean main() throws Exception {
        Scanner sc=new Scanner(System.in);
        System.out.println("\n======== Administrator Authentication ========\n");
        System.out.print("Input your student ID: ");
        int id=sc.nextInt();
        System.out.print("Input your password: ");
        String pass=sc.next();
        boolean auth=EncryptedDataChecker.main(id, pass, "admUserSrc.tdf");
        return auth;
    }
}
