package vtp2022.day2.workshop;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.time.LocalDateTime;


public class BankAcct {
    //bank acc name
    private String name ="";

    //gen acc ID from Java util UUID class
    private String acctId = UUID.randomUUID()
                                    .toString()
                                    .substring(0,8);

    //hold acc bal
    private float balance = 0f;

    //events within
    private List<String> transaction = new LinkedList<>();

    private boolean isClosed = false;
    private LocalDateTime accountCreationDate;
    private LocalDateTime accountClosingDate;

    //constructor w bank acc name
    public BankAcct(String name){
        this.name = name;
    }

    //2nd constructor w bank acc name & init bal
    public BankAcct(String name, Float initialBal){
        this.name = name;
        this.balance = initialBal;
    }
    
    ///
    // get and set 
    public String getName() {
        return name;
    }

    public String getAcctId() {
        return acctId;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<String> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<String> transaction) {
        this.transaction = transaction;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }

    public LocalDateTime getAccountCreationDate() {
        return accountCreationDate;
    }

    public void setAccountCreationDate(LocalDateTime accountCreationDate) {
        this.accountCreationDate = accountCreationDate;
    }

    public LocalDateTime getAccountClosingDate() {
        return accountClosingDate;
    }

    public void setAccountClosingDate(LocalDateTime accountClosingDate) {
        this.accountClosingDate = accountClosingDate;
    }

    public float withdraw(String withdrawAmt){
        Float withdrawAmtFloat = null;
        try{
            withdrawAmtFloat = Float.parseFloat(withdrawAmt);
            if (withdrawAmtFloat.floatValue() <= 0){
                throw new IllegalArgumentException("Amount cannot be $0.00!");
            }

            if(this.isClosed){
                throw new IllegalArgumentException("Account is closed!");
            }

            if(withdrawAmtFloat.floatValue() > this.balance){
                throw new IllegalArgumentException("Over the limit!");
            }

            //update class var of dept amt
            this.balance = this.balance - withdrawAmtFloat.floatValue();
            //construct tx history evnt log
            StringBuilder txnStringBuilder = new StringBuilder();
            txnStringBuilder.append("Withdraw $");
            txnStringBuilder.append(withdrawAmtFloat.floatValue());
            txnStringBuilder.append(" at ");
            txnStringBuilder.append(LocalDateTime.now());
            System.out.println(txnStringBuilder.toString());
            //save event log into tx linkedList
            transaction.add(txnStringBuilder.toString());

        }catch(NumberFormatException e){
            System.err.print(e);
            throw new IllegalArgumentException("Invalid withdraw amount");
        }
        return this.balance;
    }
        
            
    public void deposit(String depositAmt){
        try{
            Float depositAmtFloat = Float.parseFloat(depositAmt);
            if (depositAmtFloat.floatValue() <= 0){
                throw new IllegalArgumentException("Amount cannot be $0.00!");
            }

            if(this.isClosed){
                throw new IllegalArgumentException("Account is closed!");
            }

            //update class var of dept amt
            this.balance = this.balance + depositAmtFloat.floatValue();
            //construct tx history evnt log
            StringBuilder txnStringBuilder = new StringBuilder();
            txnStringBuilder.append("Deposit $");
            txnStringBuilder.append(depositAmtFloat.floatValue());
            txnStringBuilder.append(" at ");
            txnStringBuilder.append(LocalDateTime.now());
            System.out.println(txnStringBuilder.toString());
            //save event log into tx linkedList
            transaction.add(txnStringBuilder.toString());

        }catch(NumberFormatException e){
            System.err.print(e);
            throw new IllegalArgumentException("Error 404");

        }
        
    }
}
