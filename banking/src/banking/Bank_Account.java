package banking;

public class Bank_Account extends Customer{

    private double balance = 0.0;
    private double rate = 0.045;
    private int yearRate = 0;
    private double credit = 0;
    
    
	public void deposit(double amount){
        balance = balance + amount;
	}

	public void withdraw(double amount){
        if(balance>=amount){
            balance = balance - amount;
        }
        else{
            System.err.println("Transaction cancelled due to insufficient funds");
        }
	}
	
	public double getBalance(double credit){
        return balance + credit;
	}
	
	public double getWithdraw(double amount){
        return amount;
	}
	
	public double getDeposit(double amount){
        return amount;
	}
	
	public int getCreditAge(int yearRate, int customerAge){
        return customerAge + yearRate; 
	}
	
	public double getRate(double credit, int yearRate, int customerAge){
        
        double value = (credit * (rate/12))/( 1 - Math.pow( 1 + (rate/12), -yearRate*12));
        
        if(getCreditAge(yearRate, customerAge) > 70 || rate < 0){
            System.err.println("You can not make this transaction"); 
            return(0);
        }
        
        else{      
        
        return value;
        }
	}

}
