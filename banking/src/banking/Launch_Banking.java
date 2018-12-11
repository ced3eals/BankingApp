package banking;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Launch_Banking{


    public static void main(String[] args){
    
        System.out.printf("Welcome to your bank account management");
        String choice;
        String name = null;
        int age = 0;
        double withdrawAmount = 0;
        double amount = 0;
        double credit = 0;
        int creditDuration = 0;
        Date withdrawTime = null;
        Date depositTime = null;
        Date creditTime = null;
        Bank_Account bank = new Bank_Account();

        do{
            System.out.println("\nWhat do you want to do? [h for help]");
            Scanner scan = new Scanner(System.in);
            choice = scan.next();
                if(choice.length()> 0){
                    switch(choice.charAt(0)){
                        case 'q' : System.out.println("q: quit the program"); 
                                   System.out.println("Bye bye !"); 
                                   return;
                    
                        case 'h' : System.out.println("c: Create a user account");
                                   System.out.println("d: Deposit an amount");
                                   System.out.println("w: Withdraw an amount");
                                   System.out.println("b: Check balance");
                                   System.out.println("a: Ask for a credit");
                                   System.out.println("h: Print this help screen"); 
                                   System.out.println("q: Quit the program"); 
                                   break;
                        
                        case 'c' : System.out.println("Please enter your name");
                                   scan.nextLine();
                                   name = scan.nextLine();
                                   System.out.println("Please enter your age");
                                   age = scan.nextInt();
                                   break;

                        case 'd' : System.out.println("Please deposit an amount"); 
                                   amount = scan.nextFloat();
                                   bank.deposit(amount);
                                   System.out.println("You have deposited " + amount + "$");
                                   depositTime = new Date(System.currentTimeMillis());
                                   break;

                        case 'w' : System.out.println("Please enter your withdraw amount");
                                   withdrawAmount = scan.nextFloat();
                                   bank.withdraw(withdrawAmount);
                                   System.out.println("You have withdrawn " + bank.getWithdraw(withdrawAmount)+ "$");
                                   withdrawTime = new Date(System.currentTimeMillis());

                                   break;
                                   
                        case 'b' : System.out.println("Name\t Age\t Historic\t ");
                                   System.out.print("\n" + bank.getName(name));
                                   System.out.print("\t" + bank.getAge(age) + "Yo");
                                   System.out.println("\tLast deposit : " + "+" + bank.getDeposit(amount) + "$" + "\t" + depositTime);
                                   System.out.println("\t\tLast withdraw : " + "-" + bank.getWithdraw(withdrawAmount) + "$" + "\t" + withdrawTime);
                                   if(bank.getCreditAge(creditDuration, age) >70 ){
                                        credit = 0;
                                   }
                                   System.out.println("\t\tCredit = + " + credit + "$" + "\t" + creditTime);
                                   if(credit !=0){
                                        System.err.printf("\t\tWarning amount due : %.1f$/months!\n", bank.getRate(credit, creditDuration, age));
                                   }
                                   System.out.println("\t\tBalance = " + bank.getBalance(credit) + "$");
                                  
                                   break;
                        
                        case 'a' : System.out.println("Please enter the credit amount");
                                   credit = scan.nextFloat();
                                   System.out.println("Please enter the amount duration (in years)");
                                   creditDuration = scan.nextInt();
                                   if(age < 70){     
                                        bank.getRate(credit, creditDuration, age);
                                        System.out.printf("You will have to pay %.1f$/months\n", bank.getRate(credit, creditDuration, age));
                                        creditTime = new Date(System.currentTimeMillis());
                                   }
 
                                   break;
                                   
                        default :  System.out.println("Unknown command. Type h for help"); break;
                                    } 
                }
       
       }while(choice.charAt(0) != 'q');
    
    }  
    
}
