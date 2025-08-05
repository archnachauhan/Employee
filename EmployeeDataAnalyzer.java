import java.util.List;

public class EmployeeDataAnalyzer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeManager empMgr = new EmployeeManager();
		empMgr.addEmployee(new Employee(1, "Archna", "Engineering", 110000.0));
        empMgr.addEmployee(new Employee(2, "Geek2", "Marketing", 68000.0));
        empMgr.addEmployee(new Employee(3, "Geek3", "Engineering", 80000.0));
        empMgr.addEmployee(new Employee(4, "Geek4", "HR", 55000.0));

        Thread p1 = new EmployeeProcessor(empMgr, 1);
        Thread p2 = new EmployeeProcessor(empMgr, 2);
        Thread p3 = new EmployeeProcessor(empMgr, 5);
        
        p1.start();
        p2.start();
        p3.start();
        
        try {
        	p1.join();
        	p2.join();
        	p3.join();
        }
        catch(InterruptedException e) {
        	System.out.println("Error waiting for thread: "+e.getMessage());
        }
        System.out.println("\n Employees with salary >= 70000");
        List<Employee> highEarners = empMgr.filterEmployeesBySalary(70000.0);
        highEarners.forEach(System.out::println);
        
        System.out.println("\n Employees sorted by salary: ");
        List<Employee> sortedEmployees = empMgr.sortEmployeesBySalary();
        sortedEmployees.forEach(System.out::println);
	}

}
