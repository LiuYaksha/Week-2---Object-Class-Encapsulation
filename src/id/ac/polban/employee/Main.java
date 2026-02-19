package id.ac.polban.employee;

import id.ac.polban.employee.model.*;
import id.ac.polban.employee.service.*;

public class Main {
    public static void main(String[] args) {

        // Buat department
        Department deptIT = new Department("IT");
        Department deptHR = new Department("HR");

        // Buat employee
        Employee emp1 = new Employee(1, "Elang", deptIT, 
                new EmploymentType(EmploymentType.FULL_TIME), 5000000);
        Employee emp2 = new Employee(2, "Sari", deptHR, 
                new EmploymentType(EmploymentType.PART_TIME), 3000000);

        // Buat service
        EmployeeService service = new EmployeeService();
        service.addEmployee(emp1);
        service.addEmployee(emp2);

        // TAMBAHAN: PayrollProcessor

        PayrollProcessor payroll = new PayrollProcessor(service);

        // Proses payroll 1 employee
        payroll.processPayroll(1);

        // Proses semua payroll
        payroll.processAllPayroll();

        // ==============================

        // Cetak jumlah employee dan department
        EmployeeService.printTotalEmployees();
        System.out.println("Total Departments: " + Department.getDepartmentCount());

        // Ambil employee dan tampilkan data
        Employee e = service.getEmployee(1);
        System.out.println("Employee: " + e.getName() 
                + ", Dept: " + e.getDepartment().getName() 
                + ", Salary: " + e.getSalary());

        // Naikkan gaji
        service.raiseSalary(1, 10);
        System.out.println("After raise, Salary: " + e.getSalary());
    }
}

