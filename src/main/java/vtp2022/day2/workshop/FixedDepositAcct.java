package vtp2022.day2.workshop;


public class FixedDepositAcct extends BankAcct {
    private float interest = 3;
    private int duration = 6;
    private int durationInterestCounter = 0;

    public FixedDepositAcct(String name, float initAmt){
        super(name, initAmt);
        this.durationInterestCounter = 0;
    }
    public FixedDepositAcct(String name, float initAmt, float interest){
        super(name, initAmt);
        this.interest = interest;
        this.durationInterestCounter = 0;
    }
    public FixedDepositAcct(String name, float initAmt, float interest, int duration){
        super(name, initAmt);
        this.interest = interest;
        this.duration = duration;
        this.durationInterestCounter = 0;
    }

    public int getDuration(){
        return duration;
    }

    public void setDuration(int duration){
        if(duration < 0){
            throw new IllegalArgumentException("Nope");
        }
        this.duration = duration;
    }

    public void setInterest(float interest){
        if(interest < 0){
            throw new IllegalArgumentException("Nope");
        }
        this.interest = interest;
    }

    public void setDurationAndInterest(float interest, int duration){
        if(durationInterestCounter == 1){
            throw new IllegalArgumentException("Only set duration " + "and interest once");
        }
        setInterest(interest);
        setDuration(duration);
        durationInterestCounter++;
    }

    @Override
    public float withdraw(String withdrawAmt){
        //NOP
        return 0;
    }

    @Override
    public void deposit(String depositAmt){
        //NOP
    }

    @Override
    public float getBalance(){
        return super.getBalance() + interest;
    }
}
