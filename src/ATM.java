import java.util.Scanner;
import java.util.*;
public class ATM {
    private User user;
    private Scanner sc = new Scanner(System.in);
    private List<Transaction>  transactions = new ArrayList<>();

    public ATM() {
        user = new User(1028,999,15000.0);
    }
    public void start(){
        if(login()){
            showMenu();
        }
        else{
            System.out.println("Invalid credentials. Exiting..");
        }
    }
    private boolean login(){
        System.out.println("Enter user ID:");
        int id=sc.nextInt();

        System.out.println("Enter PIN:");
        int pin=sc.nextInt();

        return id == user.getUserId() && pin == user.getPin();
    }

    private void showMenu(){
        int choice;
        do{
            System.out.println("\n-- ATM Menu --");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Transfer");
            System.out.println("4. Transaction History");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");

            System.out.println("Choose option:");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    transfer();
                    break;
                case 4:
                    showTransactionHistory();
                    break;
                case 5:
                    checkBalance();
                    break;
                case 6:
                    System.out.println("Thanks for using the ATM");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice !=6);
    }

    private void withdraw(){
        System.out.println("Enter amount to withdraw:");
        double amount = sc.nextDouble();

        if(amount>0 && user.getBalance()>=amount){
            user.setBalance(user.getBalance()-amount);
            transactions.add(new Transaction("Withdraw", amount));
        }
        else{
            System.out.println("Balance is Insufficient to withdraw or the amount inputted is invalid");
        }
    }

    private void deposit(){
        System.out.println("enter amount to deposit:");
        double amount = sc.nextDouble();

        if(amount>0){
            user.setBalance(user.getBalance()+amount);
            transactions.add(new Transaction("Deposit",amount));
            System.out.println("Deposit Successful!");
        }
    }

    private void transfer(){
        System.out.println("Enter reciever account number :");
        int acc = sc.nextInt();

        System.out.println("Enter amount to transfer:");
        double amount = sc.nextDouble();

        if(amount>0 && user.getBalance()>=amount){
            user.setBalance(user.getBalance()-amount);
            transactions.add(new Transaction("Transfer to account_number"+acc,amount));
            System.out.println("Transaction successful");
        }
        else{
            System.out.println("Transfer failed (invalid or insufficient balance)");
        }
    }

    private void showTransactionHistory(){
        if(transactions.isEmpty()){
            System.out.println("No transactions done yet");
            return;
        }
        System.out.println("\n-- Transaction History ---");
        for(Transaction t:transactions){
            System.out.println(t);
        }
    }

    private void checkBalance(){
        System.out.println("the current balance in the account is:"+user.getBalance());
    }
}
