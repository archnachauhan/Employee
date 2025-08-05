import java.util.Optional;

public class EmployeeProcessor extends Thread{
	private EmployeeManager employeeManager;
	private int employeeId;
	public EmployeeProcessor(EmployeeManager employeeManager, int employeeId) {
		super();
		this.employeeManager = employeeManager;
		this.employeeId = employeeId;
	}
	
	public void run() {
		try {
			Optional<Employee> e = employeeManager.getEmployeeById(employeeId);
			e.ifPresentOrElse( emp -> System.out.println("Processing: "+emp),
					() -> System.out.println("Employee not present") );
		}
		catch(Exception e) {
			System.out.println("Error processing employee data: "+e.getMessage());
		}
	}

}
