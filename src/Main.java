// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Scanner;
class InsufficientFundException extends Exception{
    public InsufficientFundException (String error)
    {
        super(error);
    }
}
class InvaildAmountException extends Exception{
    public InvaildAmountException (String error1)
    {
        super(error1);
    }
}
class value
{
    public int getBalance() {
        return Balance;
    }

    public void setBalance(int balance) {
        Balance = balance;
    }

    private int Balance=2500;
}
class ATMMachine {

    public static void main(String[] args) {
        value val=new value();
        int Money=val.getBalance();
        int amount=0;
        Scanner scan=new Scanner(System.in);
        int option=0;
        do {
            System.out.println("Enter 1 for Deposit and 2 for Withdraw and 3 for view balance and 4 for Exit: ");
            option = scan.nextInt();
            switch (option) {
                case 1: {
                    System.out.println("Enter the amount to be deposited : ");
                    amount = scan.nextInt();
                    Money += amount;
                    val.setBalance(Money);
                    System.out.println("Current balance is : " + Money);
                    break;
                }
                case 2: {
                    System.out.println("enter the amount for WithDraw : ");
                    try {
                        amount = scan.nextInt();
                        if (amount > Money) {
                            throw new InsufficientFundException("Your balance is insufficient");
                        }
                    } catch (InsufficientFundException ErrorMessage) {
                        System.out.println(ErrorMessage);
                        break;
                    }
                    try {
                        if (amount <= 0) {
                            throw new InvaildAmountException("You entered negative");
                        }
                    } catch (InvaildAmountException invaildAmountException) {
                        System.out.println(invaildAmountException);
                        break;
                    }
                    if (amount < Money) {
                        Money -= amount;
                        val.setBalance(Money);
                        System.out.println("After Withdrawal your current balance is : " + Money);
                        break;
                    }
                }
                case 3:
                {
                    System.out.println("Your Balance is : " + Money);
                }
            }
        }
        while(option!=4);
    }
}