package bankApp;

public class CommercialCustomer extends Customer{
	private String contactPesonName;
	private String contactPersonPhone;
	public CommercialCustomer() {
		super();
	}
	public CommercialCustomer(String firstName, String lastName, String address, double balance, String contactPesonName, String contactPersonPhone) {
		super(firstName, lastName, address, balance);
		this.contactPesonName = contactPesonName;
		this.contactPersonPhone = contactPersonPhone;
	}
	public String getContactPesonName() {
		return contactPesonName;
	}
	public void setContactPesonName(String contactPesonName) {
		this.contactPesonName = contactPesonName;
	}
	public String getContactPersonPhone() {
		return contactPersonPhone;
	}
	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}
	@Override
	public double calculateIntrest() {
		return (getBalance() * 2.5 / 100);
	}
	@Override
	public CommercialCustomer showCustomerDetails() {
		CommercialCustomer commercialCustomer = new CommercialCustomer();
		commercialCustomer.setFirstName(getFirstName());
		commercialCustomer.setLastName(getLastName());
		commercialCustomer.setAddress(getAddress());
		commercialCustomer.setBalance(getBalance());
		commercialCustomer.setContactPesonName(getContactPesonName());
		commercialCustomer.setContactPersonPhone(getContactPersonPhone());

		return commercialCustomer;
	}
	@Override
	public String toString() {
		return super.toString() + "\nContactPeson Name = " + contactPesonName + "\nContactPerson Phone = " + contactPersonPhone;
	}
}
