package Project5;


import java.util.Scanner;

public class Store {
    private static Scanner scanner = new Scanner(System.in);
    private static final int MIN_CHARS_IN_PASSWORD = 6;
    private Client[] clients;
    private Product[] products;


    public Store() {
        this.clients = new Client[0];
        this.products = new Product[0];
//this.clients[0]=new Client("yossi","sibo","yossis","1212345",false);
    }

    public void createNewAccount() {
        int secondChoose;
        String choose;
        String client = null;
        String worker = null;
        String firstName;
        String lastName;
        String username;
        String password;

        do {
            System.out.println("Enter your firstName");
            //firstName = "yossi";
            firstName = scanner.nextLine();
        } while (!checkCharacter(firstName));

        do {
            System.out.println("Enter your LastName");
            //lastName = "sibo";
            lastName = scanner.nextLine();
        } while (!checkCharacter(lastName));

        do {
            System.out.println("Enter your username");
            // username="fdghfdh";
            username = scanner.nextLine();
        } while (isUsernameExist(username));

        do {
            System.out.println("Enter your password");
            //password = "898789";
            password = scanner.nextLine();
        } while (!isStrongPassword(password));

        System.out.println("Choose 1 for Client 2 for worker");
        secondChoose = scanner.nextInt();
        //secondChoose = 2;
        if (secondChoose == 1) {
            System.out.println("Are you club member? Enter Yes/No");
            boolean isClubMember;
            //    String chooseMember = "yes";
            String chooseMember = scanner.next();
            if (chooseMember.toLowerCase().equals("yes"))
                isClubMember = true;
            else
                isClubMember = false;
            Client cl = new Client(firstName, lastName, username, password, isClubMember);
            this.addClient(cl);
        } else if (secondChoose == 2) {
            int chooseRank ;

            do {
                System.out.println("What is your rank?");

                chooseRank = scanner.nextInt();
            } while (!(chooseRank < 4 && chooseRank > 0));
            if (chooseRank == 1) {
                System.out.println("Is regular worker");
            } else if (chooseRank == 2) {
                System.out.println("Is director");
            } else {
                System.out.println("Is Member of the management team");
            }


            Worker w = new Worker(firstName, lastName, username, password, false, chooseRank);
            this.addWorker(w);

        }
    }


    public void LoginToExistingAccount() {//account
        boolean isUserExist;
        boolean isPasswordExist;
        System.out.println("Log in to your account");
        System.out.println("Enter username and password");
        // String username = "yossis";
        //String password = "1212345";

        String username = scanner.nextLine();
        String password = scanner.nextLine();
        Client c = null;
        for (int i = 0; i < this.clients.length; i++) {
            if (clients[i].getUsername().equals(username) && clients[i].getPassword().equals(password)) {
                c = clients[i];
            }
        }

        if (c != null) {
            if (c instanceof Worker) {
                System.out.println("Hello " + c.getFirstName() + " " + c.getLastName()
                        + " (" + ((Worker) c).getRank() + ")!");

                System.out.println("2.Print list of customer members of the club only");
                System.out.println("3.Print a list of customers who have made at least one purchase");
                System.out.println("4.Print the customer with the highest amount of sensitivity");
                System.out.println("5.Adding a new product to the store");
                System.out.println("6.Change inventory status for product");
                System.out.println("7.Making a purchase");
                System.out.println("8.Logout");
                int choose = scanner.nextInt();
                while (choose != 8) {
                    if (choose == 1) {
                        for (int i = 0; i < clients.length; i++) {
                            System.out.println(clients[i]);
                        }
                    } else if (choose == 2) {
                        for (int i = 0; i < clients.length; i++) {
                            if (clients[i].isClubMember())
                                System.out.println(clients[i]);
                        }
                    } else if (choose == 3) {
                        for (int i = 0; i < clients.length; i++) {
                            int minimumPurchase = 1;
                            if (!clients[i].getCart().equals(minimumPurchase)) {
                                System.out.println(clients[i]);
                            }
                        }
                    } else if (choose == 4) {
                        for (int i = 0; i < clients.length; i++) {
                            // ShoppingCart current=clients[i].getCart();
                            if (clients[i].getCart().equals(clients[i+1].getCart())){

                            }


                        }
                    }


                }
            }
        } else {
            if (!c.isClubMember())
                System.out.println("Hello " + c.getFirstName() + " " + c.getLastName());
        }
        System.out.println("Hello " + c.getFirstName() + " " + c.getLastName()
                + " vip" + c.isClubMember());
        String nameProduct = scanner.nextLine();
        boolean productExist;
        for (int i = 0; i < products.length; i++) {
            if (products[i].getNameProduct().equals(nameProduct)) {
                productExist = true;
                System.out.println(products[i]);
            }
            productExist = false;
        }


        System.out.println("Enter number of product or enter 1  to end");
        int currentChoose = scanner.nextInt();
        if (currentChoose != 1) {


            for (int i = 0; i < products.length; i++) {
                Product product = this.products[i];
                if (product.getNumberProduct() == currentChoose) {
                    int amountOfProduct;
                    do {
                        System.out.println("How many items from the same product do you want to insert");
                        amountOfProduct = scanner.nextInt();
                    } while (amountOfProduct >= 0);
                    System.out.println(products[i]);
                    currentChoose = scanner.nextInt();
                    if (currentChoose == -1) {
                        System.out.println(product.getPrice());
                        break;

                    }
                }
            }
        }
    }

    private boolean checkCharacter(String name) {
        //Boolean properFirstName = false;
        for (int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            if (Character.isDigit(currentChar)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUsernameExist(String usernameToCheck) {
        for (int i = 0; i < this.clients.length; i++) {
            Client currentClient = this.clients[i];
            if (currentClient.getUsername().equals(usernameToCheck)) {
                return true;
            }
        }
        return false;
    }

    private boolean isStrongPassword(String passwordToCheck) {
        boolean validLength;
        if (passwordToCheck.length() >= MIN_CHARS_IN_PASSWORD) {
            validLength = true;
        } else {
            validLength = false;
        }
        return validLength;
    }


    private void addWorker(Worker worker) {
        Worker[] addWorker = new Worker[clients.length + 1];
        for (int i = 0; i < this.clients.length; i++) {
            addWorker[i] = worker;

        }
    }

    private void addClient(Client client) {
        Client[] addClient = new Client[clients.length + 1];
        for (int i = 0; i < this.clients.length; i++) {
            addClient[i] = client;
        }
    }
 
}






