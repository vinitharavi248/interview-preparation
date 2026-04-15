import java.util.*;

class Transaction {
    String type;
    double amount;
    Date date;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }
}

class Account {
    String accountId;
    String holderName;
    double balance;
    List<Transaction> transactions = new ArrayList<>();

    public Account(String id, String name) {
        this.accountId = id;
        this.holderName = name;
        this.balance = 0.0;

    }
    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
        System.out.println("Amount Deposited Successfully");
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance");
            return;
        }

        balance -= amount;
        transactions.add(new Transaction("Withdraw", amount));
        System.out.println(" Withdrawal Successful");
    }

    public void printTransactions() {
        System.out.println("\nTransaction History:");
        for (Transaction t : transactions) {
            System.out.println(t.type + " - ₹" + t.amount + " on " + t.date);
        }
    }
}

public class BankingSystem {
    private static Map<String, Account> accounts = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void createAccount() {
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine();

        if (accounts.containsKey(id)) {
            System.out.println(" Account already exists");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        accounts.put(id, new Account(id, name));
        System.out.println(" Account Created Successfully");
    }

    public static void deposit() {
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine();

        Account acc = accounts.get(id);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter Amount: ");
        double amt = Double.parseDouble(sc.nextLine());

        acc.deposit(amt);
    }

    public static void withdraw() {
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine();

        Account acc = accounts.get(id);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }

        System.out.print("Enter Amount: ");
        double amt = Double.parseDouble(sc.nextLine());

        acc.withdraw(amt);
    }

    public static void transfer() {
        System.out.print("From Account ID: ");
        String fromId = sc.nextLine();

        System.out.print("To Account ID: ");
        String toId = sc.nextLine();

        Account from = accounts.get(fromId);
        Account to = accounts.get(toId);

        if (from == null || to == null) {
            System.out.println("Invalid Account");
            return;
        }

        System.out.print("Enter Amount: ");
        double amt = Double.parseDouble(sc.nextLine());

        if (amt > from.balance) {
            System.out.println("Insufficient Balance");
            return;
        }

        from.withdraw(amt);
        to.deposit(amt);
        System.out.println("Transfer Successful");
    }

    public static void checkBalance() {
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine();

        Account acc = accounts.get(id);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }
        System.out.println("Balance: ₹" + acc.balance);
    }

    public static void showTransactions() {
        System.out.print("Enter Account ID: ");
        String id = sc.nextLine();
        Account acc = accounts.get(id);
        if (acc == null) {
            System.out.println("Account not found");
            return;
        }
        acc.printTransactions();
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== BANKING SYSTEM ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. Check Balance");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");
            System.out.print("Choose: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: transfer(); break;
                case 5: checkBalance(); break;
                case 6: showTransactions(); break;
                case 7: System.exit(0);
                default: System.out.println("Invalid Choice");
            }
        }
    }
}