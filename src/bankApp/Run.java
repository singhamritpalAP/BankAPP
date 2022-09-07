package bankApp;

import java.util.Scanner;

public class Run {

	public static void main(String[] args) throws InsufficientBalanceException {
		Bank bank = new Bank();
		long customerId;

		while(true){
			
			System.out.println();
			System.out.println("1. Create  Personal Customer");
			System.out.println("2. Create  Commercial Customer");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Display Details");
			System.out.println("6. Total Value");
			System.out.println("7. Fund Transfer");
			System.out.println("8. Calculate Intrest");
			System.out.println("9. Exit");
			System.out.println();
			
			System.out.print("Enter your choice ");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			int option = scanner.nextInt();
			scanner.nextLine();
			System.out.println();

			switch(option){
			case 1:
				System.out.println("Enter FirstName, LastName, Address, Balance, homePhone & workPhone");
				customerId = bank.createPersonalCustomer(scanner.nextLine(), scanner.nextLine(),  
						scanner.nextLine(), scanner.nextDouble(), scanner.next(), scanner.next());

				System.out.println("Personal Customer created successfully with customer Id: " + customerId);
				break;

			case 2:
				System.out.println("Enter FirstName, LastName, Address, Balance, contactPersonName & contactPersonPhone");
				customerId = bank.createCommercialCustomer(scanner.nextLine(), scanner.nextLine(),  
						scanner.nextLine(), scanner.nextDouble(), scanner.next(), scanner.next());				
				System.out.println("Commercial Customer created successfully with customer Id: " + customerId);
				break;

			case 3: 
				System.out.println("Enter CustomerId & Deposit Amount"); 
				String depositMessage = bank.deposit(scanner.nextLong(), scanner.nextDouble()); 
				System.out.println(depositMessage);
				break; 

			case 4:
				System.out.println("Enter CustomerId & Withdraw Amount"); 
				String withdrawMessage = bank.withdraw(scanner.nextLong(), scanner.nextDouble()); 
				System.out.println(withdrawMessage);
				break; 

			case 5: 
				System.out.println("Enter Customer Id"); 
				bank.showCustomerDetails(scanner.nextLong());
				break; 

			case 6: 
				System.out.println("Total Value : " + bank.totalValue());
				break;
				
			case 7:
				System.out.println("Enter Sender Id, Receiver Id, amount");
				String transferMessage = bank.fundTransfer(scanner.nextLong(), scanner.nextLong(), scanner.nextDouble());
				System.out.println(transferMessage);
				break;

			case 8:
				System.out.println("Enter Customer Id: ");
				System.out.println(bank.getIntrest(scanner.nextLong()));
				break;

			case 9: System.exit(0);
			break;

			default: 
				System.out.println("Invalid Option!!!");
				break;
			}
			System.out.println();
		}
	}
}
