
public class Employee {
	private String firstName;
	private String lastName;
	private double salary;
	private String department;
	public Employee(String string, String string2, double d, String string3) {
		// TODO Auto-generated constructor stub
		this.firstName=string;
		this.lastName=string2;
		this.salary=d;
		this.department=string3;
	}
	
	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary + ", department="
				+ department + "]";
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
	
}
