package employeemanagemantpublisher;

public class Employee {
 private int employeeId;
 private String employeeName;
 private int Age;
 private String phoneNumber;
 private String NIC;
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}
public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getNIC() {
	return NIC;
}
public void setNIC(String nIC) {
	NIC = nIC;
}

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int employeeId, String employeeName, int age, String phoneNumber, String nIC) {
	super();
	this.employeeId = employeeId;
	this.employeeName = employeeName;
	Age = age;
	this.phoneNumber = phoneNumber;
	NIC = nIC;
}
}
