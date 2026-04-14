public class User {
    int userId;
    int pin;
    double balance;

    public User(int userId,int pin,double balance){
        this.userId=userId;
        this.pin=pin;
        this.balance=balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }


    public int getUserId() {
        return userId;
    }

    public int getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

}
