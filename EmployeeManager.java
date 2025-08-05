import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeManager {
	private Map<Integer, Employee> employeeData;
	
	EmployeeManager(){
		employeeData = new HashMap<>();
	}
	
	public void addEmployee(Employee e) {
		employeeData.put(e.getId(), e);
	}
	
	public Optional<Employee> getEmployeeById(int id){
		return Optional.ofNullable(employeeData.get(id));
	}
	
	public List<Employee> getAllEmployees(){
		return new ArrayList<>(employeeData.values());
	}
	
	public List<Employee> filterEmployeesBySalary(Double minSalary){
		return employeeData.values().stream()
				.filter(e -> e.getSalary().orElse(0.0) >= minSalary).collect(Collectors.toList());
	}
	
	public List<Employee> sortEmployeesBySalary(){
		return employeeData.values().stream()
				.sorted(Comparator.comparingDouble(e -> e.getSalary().orElse(0.0))).collect(Collectors.toList());
	}
	
}
