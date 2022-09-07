package bankApp;

import java.util.ArrayList;
import java.util.List;

public class Bank {
	List<Customer> customerList = new ArrayList<>();

	public long createPersonalCustomer(String firstName, String lastName, String address, double balance, String homePhone, String workPhone){
		PersonalCustomer personalCustomer = new PersonalCustomer(firstName, lastName, address, balance, homePhone, workPhone);
		customerList.add(personalCustomer);

		return personalCustomer.getCustomerId();
	}

	public long createCommercialCustomer(String firstName, String lastName, String address, double balance, String contactPersonName, String contactPersonPhone){
		CommercialCustomer commercialCustomer = new CommercialCustomer(firstName, lastName, address, balance, contactPersonName, contactPersonPhone);
		customerList.add(commercialCustomer);

		return commercialCustomer.getCustomerId();
	}

	public String deposit(long customerId, double amount){
		Customer customer = getCustomerDetails(customerId);

		if(customer != null){
			customer.setBalance(customer.getBalance() + amount);
			return "Amount Successfully Deposited: " + customer.getBalance();
		}
		return "Customer Not Found";
	}

	public String withdraw(long customerId, double amount) {
		Customer customer = getCustomerDetails(customerId);

		if(customer != null){
			if(customer.getBalance() - 1000 >= amount){
				customer.setBalance(customer.getBalance() - amount);
				return "Amount Successfully Withdrawn\nNew Balance: " + customer.getBalance();
			} else
				try {
					throw new InsufficientBalanceException("Current Balance : " + customer.getBalance());
				} catch (InsufficientBalanceException e) {
					e.printStackTrace();
					return "";
				}

		}
		return "Customer Not Found";
	}

	public String fundTransfer(long customerIdSender, long customerIdReceiver, double amount){
		String withdrawMessageFromSender = withdraw(customerIdSender, amount);

		if(withdrawMessageFromSender != "Insufficient Balance" && withdrawMessageFromSender != "Customer Not Found"){
			String depositMessageFromReceiver = deposit(customerIdReceiver, amount);
			if(depositMessageFromReceiver == "Customer Not Found"){
				deposit(customerIdSender, amount);
				return "Invalid Receiver Id Not Found";
			}
			else
				return "Transfer Successfull";
		}
		else 
			return withdrawMessageFromSender;
	}

	public Customer getCustomerDetails(long customerId){

		for(Customer customer : customerList)
			if(customer.getCustomerId() == customerId)
				return customer;
		return null;
	}

	public double totalValue(){
		double totalvalue = 0;

		for(Customer customer : customerList)
			totalvalue += customer.getBalance();
		return totalvalue;
	}

	public double getIntrest(long customerId){
		Customer customer = getCustomerDetails(customerId);

		if (customer == null)
			return 0;
		return customer.calculateIntrest();
	}

	public void showCustomerDetails(long customerId){
		Customer customer = getCustomerDetails(customerId);
		if(customer != null)
			System.out.println(customer);
		else 
			System.out.println("Customer Not Found");
	}

}

