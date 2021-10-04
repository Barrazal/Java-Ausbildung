import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class RunDB {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter DB Name: ");
        String dbName = myScanner.nextLine();
        DBManager dbManager = new DBManager(dbName);
        System.out.println("Connection Established!");
        String sql = "";
        while(!sql.equals("exit")) {
            System.out.println("Enter SQL Statement:");
            sql = myScanner.nextLine();
            if (!sql.equals("exit"))
                System.out.println(dbManager.executeStatement(sql));
        }
    }
}
