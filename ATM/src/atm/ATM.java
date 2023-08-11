package atm;

import java.util.Scanner;
class BankAccount 
{
	String name;
	String username;
	String password;
	String accountNo;
	float balance = 1000f;
	int transactions = 0;
	String transactionHistory = "";
	
	public void register() 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Name :- \n");
		this.name = sc.nextLine();
		System.out.print("\nEnter Your Username :- \n");
		this.username = sc.nextLine();
		System.out.print("\nEnter Your Password :- \n");
		this.password = sc.nextLine();
		System.out.print("\nEnter Your Account Number :- \n ");
		this.accountNo = sc.nextLine();
		System.out.println("\nYou have Successfully Registered.\n");
		System.out.println("\n User can Login now \n");
	}
	public boolean login() 
	{
		boolean isLogin = false;
		Scanner sc = new Scanner(System.in);
		while ( !isLogin ) 
		{
			System.out.print("\nEnter Your Username : ");
			String Username = sc.nextLine();
			if ( Username.equals(username) ) 
			{
				while ( !isLogin ) 
				{
					System.out.print("\nEnter Your Password : ");
					String Password = sc.nextLine();
					if ( Password.equals(password) ) 
					{
						System.out.print("\nYou have Logged in Successfully.\n");
						isLogin = true;
					}
					else 
					{
						System.out.println("\nIncorrect Password.Try again\n");
					}
				}
			}
			else 
			{
				System.out.println("\nUsername not found\n");
			}
		}
		return isLogin;
	}
	public void withdraw() 
	{
		System.out.print("\nEnter amount to withdraw :  ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try 
		{
			if ( balance >= amount ) 
			{
				transactions++;
				balance -= amount;
				System.out.println("\nWithdraw Successful");
				String str = amount + " Rs Withdrawed\n";
				transactionHistory = transactionHistory.concat(str);
				
			}
			else 
			{
				System.out.println("\nInsufficient Balance");
			}
			
		}
		catch ( Exception exc) 
		{
                    System.out.println(exc);
		}
	}
	public void deposit() 
	{	
		System.out.print("\nEnter amount to deposit : ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();	
		try 
		{
			if ( amount <= 1000000f ) 
			{
				transactions++;
				balance += amount;
				System.out.println("\nSuccessfully Deposited");
				String str = amount + " Rs deposited\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else 
			{
				System.out.println("\nSorry. The Maximum Limit is Rs 100000.00/-");
			}	
		}
		catch ( Exception exc) 
		{
                       System.out.println(exc);
		}
	}
	public void transfer() 
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Recipient's Name : ");
		String receipent = sc.nextLine();
		System.out.print("\nEnter amount to transfer : ");
		float amount = sc.nextFloat();
		try 
		{
			if ( balance >= amount ) 
			{
				if ( amount <= 40000f ) 
				{
					transactions++;
					balance -= amount;
					System.out.println("\nSuccessfully Transferred to " + receipent);
					String str = " Rs"+ amount + "/- transferred to " + receipent + "\n";
					transactionHistory = transactionHistory.concat(str);
				}
				else 
				{
					System.out.println("\n Denied. The Maximum Limit is Rs.40000.00 per Transaction");
				}
			}
			else 
			{
				System.out.println("\nInsufficient Balance");
			}
		}
		catch ( Exception exc) 
		{
                     System.out.println(exc);
		}
	}
	public void checkBalance() 
	{
                System.out.println("\n Default Balance is Rs 1000/-");
		System.out.println("\n Rs" + balance + " /-");
	}
	public void transHistory() 
	{
		if ( transactions == 0 ) 
		{
			System.out.println("\n You have no previous transactions. ");
		}
		else 
		{
			System.out.println("\n" + transactionHistory);
		}
	}
}
public class ATM
{
	public static int takeIntegerInput(int limit) 
	{
		int input = 0;
		boolean flag = false;
		while ( !flag ) 
		{
			try 
			{
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if ( flag && input > limit || input < 1 ) 
				{
					System.out.println("Choose the number between 1 to " + limit);
					flag = false;
				}
			}
			catch ( Exception exc ) 
			{
		 		System.out.println("Enter only integer value");
				flag = false;
			}
		};
		return input;
	}
	public static void main(String[] args) 
	{
		System.out.println("\n----------<<< WELCOME TO ATM SYSTEM >>>----------\n");
		System.out.println("1.Register \n2.Exit");
		System.out.print("Enter Your Choice :- ");
		int choice = takeIntegerInput(2);
		if ( choice == 1 ) 
		{
			BankAccount ba = new BankAccount();
			ba.register();
			while(true) 
			{
				System.out.println("\n1.Login \n2.Exit");
				System.out.print("Enter Your Choice :- ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 ) 
				{
					if (ba.login()) 
					{
						System.out.println("\n\n----------<<< WELCOME BACK " + ba.name + " >>>----------\n");
						boolean isFinished = false;
						while (!isFinished) 
						{
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice - ");
							int a = takeIntegerInput(6);
							switch(a) 
							{
								case 1:
								ba.withdraw();
								break;
								case 2:
								ba.deposit();
								break;
								case 3:
								ba.transfer();
								break;
								case 4:
								ba.checkBalance();
								break;
								case 5:
								ba.transHistory();
								break;
								case 6:
								isFinished = true;
								break;
							}
						}
					}
				}
				else 
				{
					System.exit(0);
				}
			}
		}
		else 
		{
			System.exit(0);
		}
}
}
