package Project5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        System.out.println("1.Create new account");
        System.out.println("2.Login to exist account");
        System.out.println("3.logout");
        int select=1;
        //  int select = scanner.nextInt();
        while (select == 1 || select == 2 || select == 3) {
            if (select == 1) {
                store.createNewAccount();
            }
            // select=2;
            if (select == 2) {
                store.LoginToExistingAccount();
            } else {
                break;
            }

        }
    }
}

