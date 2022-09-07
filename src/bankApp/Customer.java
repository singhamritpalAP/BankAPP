package bankApp;

public abstract class Customer {

	private long customerId;
	private String firstName;
	private String lastName;
	private String address;
	private double balance;
	static long counter = 1000;

	public Customer(){
		this.customerId = counter++;
	}

	public Customer(String firstName, String lastName, String address, double balance) {
		this.customerId = counter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.balance = balance;
	}

	abstract public double calculateIntrest();
	public abstract Customer showCustomerDetails();

	public long getCustomerId() {
		return customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer Id = " + customerId + "\nFirst Name = " + firstName + "\nLast Name = " + lastName
				+ "\nAddress = " + address + "\nBalance = " + balance;
	}
}