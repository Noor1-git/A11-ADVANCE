package edu.jsp.employee.view;

import java.util.Collections;
import java.util.Scanner;

import edu.jsp.employee.controller.Controller;
import edu.jsp.employee.model.Employee;
import edu.jsp.employee.model.SortByContact;
import edu.jsp.employee.model.SortById;
import edu.jsp.employee.model.SortByName;
import edu.jsp.employee.model.SortBySalary;

public class View {

	Scanner scanner = new Scanner(System.in);
	Controller controller = new Controller();

	boolean loop = true;

	public static void main(String[] args) {

		View view = new View();

		while (view.loop) {
			view.mainView();
		}

	}

	public void mainView() {

		System.out.println("---------------WELCOME----------------\n" + "SELECT OPERATION TO PERFORM \n"
				+ "1.SAVE EMPLOYEE \n" + "2.GET EMPLOYEE \n" + "3.GET ALL EMPLOYEES \n" + "4.DELETE EMPLOYEE \n"
				+ "5.UPDATE EMPLOYEE \n" + "6.EXIT\n");

		int choice = scanner.nextInt();

		switch (choice) {
		case 1: {
			saveEmployee();
			break;
		}
		case 2: {
			getEmployee();
			break;
		}
		case 3: {
			getAllEmployees();
			break;
		}
		case 4: {
			deleteEmployee();
			break;
		}
		case 5: {
			updateEmployee();
			break;
		}
		case 6: {

			this.loop = false;
			System.out.println("THANK YOU");
			break;
		}
		default:
			System.out.println("INVALID CHOICE PLEASE TRY AGAIN");
		}
	}

	public void saveEmployee() {

		System.out.println("Enter Employee ID : \n");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter Employee Name : \n");
		String name = scanner.nextLine();

		System.out.println("Enter Employee Salary : \n");
		double sal = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Enter Employee Contact : \n");
		long contact = scanner.nextLong();
		scanner.nextLine();

		Employee employee = new Employee(id, name, sal, contact);

		if (controller.saveEmployee(employee) != null) {
			System.out.println("Employee Saved\n");
		} else {
			System.out.println("Something Went Wrong\n");
		}
	}

	public void getEmployee() {
		System.out.println("Enter User ID : \n");
		int id = scanner.nextInt();

		Employee employee;

		if ((employee = controller.getEmployee(id)) != null) {

			System.out.println("Employee ID : " + employee.getId());
			System.out.println("Employee Name : " + employee.getName());
			System.out.println("Employee Salary : " + employee.getSal());
			System.out.println("Employee Contact : " + employee.getContact() + "\n");

		} else {
			System.out.println("EMPLOYEE NOT FOUND \n");
		}
	}

	public void getAllEmployees() {

		if (controller.getAllEmployee().isEmpty()) {
			System.out.println("No Employees Are Present\n");
			return;
		}

		sortEmployees();

		for (Employee employee : controller.getAllEmployee()) {

			System.out.println("Employee ID : " + employee.getId());
			System.out.println("Employee Name : " + employee.getName());
			System.out.println("Employee Salary : " + employee.getSal());
			System.out.println("Employee Contact : " + employee.getContact());

			System.out.println("\n-----------------------------------------\n");

		}

	}

	public void deleteEmployee() {

		getAllEmployees();

		System.out.println("Enter Employee ID : \n");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.println("Enter Employee Name : \n");
		String name = scanner.nextLine();

		System.out.println("Enter Employee Salary : \n");
		double sal = scanner.nextDouble();
		scanner.nextLine();

		System.out.println("Enter Employee Contact : \n");
		long contact = scanner.nextLong();
		scanner.nextLine();

		Employee employee = new Employee(id, name, sal, contact);

		for (Employee employee1 : controller.getAllEmployee()) {

			if (employee1.getId() == employee.getId()) {
				if (employee1.getName().equalsIgnoreCase(employee.getName())) {
					if (employee1.getSal() == employee.getSal()) {
						if (employee1.getContact() == employee.getContact()) {
							controller.deleteEmployee(employee);
							System.out.println("Employee Deleted\n");
							return;
						}
					}
				}
			}

		}

		System.out.println("Employee Not Found\n");

	}

	public void updateEmployee() {

		getAllEmployees();

		System.out.println("Enter Employee ID to Update\n");
		int id = scanner.nextInt();
		scanner.nextLine();

		for (Employee employee : controller.getAllEmployee()) {
			if (employee.getId() == id) {

				Employee employee1 = employee;

				System.out.println("Enter What to Update\n " + "1.ID\n" + "2.Name\n" + "3.Salary\n" + "4.Contact\n"
						+ "5.Update All");

				int choice = scanner.nextInt();
				scanner.nextLine();

				switch (choice) {

				case 1: {

					System.out.println("Enter Employee ID : \n");
					int id1 = scanner.nextInt();
					scanner.nextLine();

					employee1.setId(id1);
					System.out.println("EMPLOYEE ID UPDATED\n");
					break;
				}
				case 2: {

					System.out.println("Enter Employee Name : \n");
					String name = scanner.nextLine();

					employee1.setName(name);

					System.out.println("EMPLOYEE NAME UPDATED\n");
					break;
				}
				case 3: {

					System.out.println("Enter Employee Salary : \n");
					double sal = scanner.nextDouble();
					scanner.nextLine();

					employee1.setSal(sal);
					System.out.println("EMPLOYEE SALARY UPDATED\n");
					break;
				}
				case 4: {

					System.out.println("Enter Employee Contact : \n");
					long contact = scanner.nextLong();
					scanner.nextLine();

					employee1.setContact(contact);

					System.out.println("EMPLOYEE CONTACT UPDATED\n");
					break;
				}
				case 5: {

					System.out.println("Enter Employee ID : \n");
					int id1 = scanner.nextInt();
					scanner.nextLine();

					System.out.println("Enter Employee Name : \n");
					String name = scanner.nextLine();

					System.out.println("Enter Employee Salary : \n");
					double sal = scanner.nextDouble();
					scanner.nextLine();

					System.out.println("Enter Employee Contact : \n");
					long contact = scanner.nextLong();
					scanner.nextLine();

					employee1.setId(id1);
					employee1.setName(name);
					employee1.setSal(sal);
					employee1.setContact(contact);

					System.out.println("Employee Details Updated\n");

					break;
				}

				default:
					System.out.println("INVALID CHOICE PLEASE TRY AGAIN...");
					break;
				}

			}
		}

	}
	
	
	public void sortEmployees() {
		
		System.out.println("SELECT SORTING BASED ON\n" + "1. SORT BY ID.\n" + "2.SORT BY NAME\n" + "3.SORT BY SALARY\n"
				+ "4.SORT BY CONTACT\n" + "5.DONT SORT\n");

		int sortChoice = scanner.nextInt();
		scanner.nextLine();

		switch (sortChoice) {
		case 1: {
			
			controller.sortedEmployees(new SortById());
			break;
		}
		case 2: {
			controller.sortedEmployees(new SortByName());
			break;
		}
		case 3: {
			controller.sortedEmployees(new SortBySalary());
			break;
		}
		case 4: {
			controller.sortedEmployees(new SortByContact());
			break;
		}

		default:System.out.println("INVALID SORTING CHOICE\n");
			break;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}