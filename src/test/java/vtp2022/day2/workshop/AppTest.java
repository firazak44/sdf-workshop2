package vtp2022.day2.workshop;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testBankAcct(){
        BankAcct bkAcc = new BankAcct("Fir");
        bkAcc.deposit("1000");
        float finalBal = bkAcc.withdraw("500");
        assertEquals(500, finalBal, .1);
    }

    @Test
    public void testFixedDepositAcctChnageInterestAndDuration(){
        try{
            FixedDepositAcct fdAcc = new FixedDepositAcct("My FD acc", 10000);
            System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());
            fdAcc.setDurationAndInterest(4, 12);
            System.out.println("2. Fixed Deposit Acc balance > " + fdAcc.getBalance());
            fdAcc.setDurationAndInterest(3, 6);
        }catch(IllegalArgumentException e){
            assertTrue(" Only set duration and interest once".contains(e.getMessage()));
        }
       
    }

    @Test
    public void testFixedDepositAccountchangeInterestAndDurationOnce(){
        FixedDepositAcct fdAcc = 
            new FixedDepositAcct("My FD acc", 10000);

        System.out.println("1. Fixed Deposit Acc balance > " + fdAcc.getBalance());
        fdAcc.setDurationAndInterest(4, 12);
        System.out.println("2. Fixed Deposit Acc balance > " + fdAcc.getBalance());
        assertEquals(12, fdAcc.getDuration(), .1);
    }
}
