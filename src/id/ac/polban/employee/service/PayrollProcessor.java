package id.ac.polban.employee.service;

import id.ac.polban.employee.model.Employee;

public class PayrollProcessor {

    private EmployeeService employeeService;

    // Constructor injection (lebih rapi secara desain)
    public PayrollProcessor(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Memproses payroll untuk satu employee berdasarkan ID
     */
    public void processPayroll(int employeeId) {

        Employee emp = employeeService.getEmployee(employeeId);

        if (emp == null) {
            System.out.println("Employee dengan ID " + employeeId + " tidak ditemukan.");
            return;
        }

        double salary = emp.getSalary();
        double tax = EmployeeService.calculateTax(salary);
        double netSalary = EmployeeService.calculateNetSalary(salary);

        System.out.println("=== Payroll Slip ===");
        System.out.println("Nama        : " + emp.getName());
        System.out.println("Department  : " + emp.getDepartment().getName());
        System.out.println("Gaji Bruto  : " + salary);
        System.out.println("Pajak       : " + tax);
        System.out.println("Gaji Bersih : " + netSalary);
        System.out.println("====================");
    }

    /**
     * Memproses seluruh payroll karyawan
     */
    public void processAllPayroll() {

        System.out.println("=== PROCESSING ALL PAYROLL ===");

        for (Employee emp : employeeService.getAllEmployees()) {

            double salary = emp.getSalary();
            double tax = EmployeeService.calculateTax(salary);
            double netSalary = EmployeeService.calculateNetSalary(salary);

            System.out.println(emp.getName() + 
                " | Gross: " + salary +
                " | Tax: " + tax +
                " | Net: " + netSalary);
        }
    }
}
