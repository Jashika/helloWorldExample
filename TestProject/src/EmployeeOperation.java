import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeOperation {
	//first task
	public static List<Employee> getEmployees() {
		List<Employee> employees = Arrays.asList(new Employee("Jiya", "Brein", 32500.0, "HR"),
				new Employee("Paul", "Niksui", 10500.0, "Sales And Marketing"),
				new Employee("Martin", "Theron", 27000.0, "Account And Finance"),
				new Employee("Murali", "Gowda", 34500.0, "Product Development"),
				new Employee("Nima", "Roy", 22700.0, "HR"),
				new Employee("Iqbal", "Hussain", 11500.0, "Security And Transport"),
				new Employee("Manu", "Sharma", 12000.0, "Account And Finance"),
				new Employee("Wang", "Liu", 1800.0, "Product Development"),
				new Employee("Amelia", "Zoe", 20000.0, "Sales And Marketing"),
				new Employee("Jaden", "Dough", 11000.5, "Security And Transport"),
				new Employee("Jasna", "Kaur", 15700.0, "Account And Finance"),
				new Employee("Nitin", "Joshi", 28200.0, "Product Development"),
				new Employee("Jyothi", "Reddy", 21300.0, "Account And Finance"),
				new Employee("Nicolus", "Den", 10700.5, "Sales And Marketing"),
				new Employee("Ali", "Baig", 12700.0, "Account And Finance"),
				new Employee("Sanvi", "Pandey", 28900.0, "Product Development"),
				new Employee("Anuj", "Chettiar", 35700.0, "Product Development"),
				new Employee("Jashika", "Vasu", 10000.0, "Computer Science"),
				new Employee("Yashika", "Vasu", 30000.0, "Account And Finance"),
				new Employee("Janaki", "Poonacha", 40000.0, "Education"),
				new Employee("Vasu", "Madappa", 500000.0, "Police"),
				new Employee("Gagana", "Gouramma", 60000.0, "Education"),
				new Employee("Laukya", "Gopal", 70000.0, "Education"),
				new Employee("Unnathi", "Ajay", 80000.0, "Education"), new Employee("Gopal", "Gopal", 90000.0, "Civil"),
				new Employee("Ajay", "Poonacha", 100000.0, "Account And Finance"),
				new Employee("Poorvika", "Gowda", 20000.0, "Account And Finance"));
		return employees;

	}
	
	public static List<Employee> getEmployeeOnDepartment(String department) {
		return EmployeeOperation.getEmployees().stream().filter(x -> x.getDepartment().contains(department)).collect(Collectors.toList());
	}
	
	public static double getTotalSalary() {
		DoubleSummaryStatistics empSalary = EmployeeOperation.getEmployees().stream()
				.collect(Collectors.summarizingDouble(Employee::getSalary));
		return empSalary.getSum();
	}
	
	public static Optional<Employee> getEmployeeWithHighestSalary() {
		Optional<Employee> maxEmpSalary = EmployeeOperation.getEmployees().stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		return maxEmpSalary;
	}
	
	public static List<Employee> getEmployeesSortedOnDepartmentAndSalary() {
		return EmployeeOperation.getEmployees().stream()
				.sorted(Comparator.comparing(Employee::getDepartment)
						.thenComparing(Comparator.comparing(Employee::getSalary).reversed()))
				.collect(Collectors.toList());

	}
	
	//Second task
	public static Map<String, List<Employee>> getEmployeesInDifferentForm() {
		return EmployeeOperation.getEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment));
	}

	public static Map<String, Long> countTotalEmployeesPerDepartment() {
		return EmployeeOperation.getEmployees().stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
	}
	
	public static Map<String, Double> averageSalariesPerDepartment() {
		return EmployeeOperation.getEmployees().stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
	}
	
	public static List<Employee> getFirstFiveEmployees() {
		return EmployeeOperation.getEmployees().stream().limit(5).collect(Collectors.toList());
	}
	
	public static List<Employee> getSecondToFifthIndexEmployees() {
		return EmployeeOperation.getEmployees().stream().skip(2).limit(4).collect(Collectors.toList());
	}
	
	

	public static void main(String[] args) {
		System.out.println("List of Employees" + EmployeeOperation.getEmployees());
		System.out.println("List of Employees based on department"
				+ EmployeeOperation.getEmployeeOnDepartment(Constants.FINANCE_DEPARTMENT));
		System.out.println("Total salary " + EmployeeOperation.getTotalSalary());
		System.out.println("Employee with max salary is " + EmployeeOperation.getEmployeeWithHighestSalary());
		System.out.println("Employees after sorting by department and decreasing order of salary"
				+ EmployeeOperation.getEmployeesSortedOnDepartmentAndSalary());
		System.out.println("List of employees based on department in map structure"
				+ EmployeeOperation.getEmployeesInDifferentForm());
		System.out
				.println("Count total employees per department" + EmployeeOperation.countTotalEmployeesPerDepartment());
		System.out.println(
				"Average salaries of employees per department" + EmployeeOperation.averageSalariesPerDepartment());
		System.out.println("Get first five employees" + EmployeeOperation.getFirstFiveEmployees());
		System.out.println(
				"Get employess from 2nd index to fifth index" + EmployeeOperation.getSecondToFifthIndexEmployees());
	}
}
