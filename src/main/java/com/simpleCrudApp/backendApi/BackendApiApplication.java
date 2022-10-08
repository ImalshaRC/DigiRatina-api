package com.simpleCrudApp.backendApi;

import com.simpleCrudApp.backendApi.model.Employee;
import com.simpleCrudApp.backendApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BackendApiApplication.class, args);
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	@Override
	public void run(String... args) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("Kamal");
		employee.setLastName("priyashan");
		employee.setEmailID("kamalpriyashan@gmail.com");
		employeeRepository.save(employee);

		Employee employee1 = new Employee();
		employee1.setFirstName("chamindu");
		employee1.setLastName("imalsha");
		employee1.setEmailID("chaminduimalsha@gmail.com");
		employeeRepository.save(employee1);
	}
}
