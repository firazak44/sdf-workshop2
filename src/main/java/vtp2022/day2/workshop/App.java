package vtp2022.day2.workshop;

public class App 
{
    public static void main( String[] args ){
        System.out.println( "XYZ Bank" );

        //Withdrawing Process//
        BankAcct bkAcc = new BankAcct("Fir");
        bkAcc.deposit("1000");
        System.out.println("My new account balance > " + bkAcc.getBalance());
        //bkAcc.deposit("9999999999");
        //System.out.println("My new account balnace >" + bkAcc.getBalance());
        System.out.println("Withdraw 20 > " + bkAcc.withdraw("20"));
        //System.out.println("Withdraw 100 > " + bkAcc.withdraw("100"));

        //Fixed Deposit Process//
        FixedDepositAcct fdAcc = new FixedDepositAcct("My FD acc", 10000);
        System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());
        fdAcc.setDurationAndInterest(6, 12);
        System.out.println("2. Fixed Deposit Acc balance > " + fdAcc.getBalance());
        //fdAcc.setDurationAndInterest(3, 6);

    }
}
