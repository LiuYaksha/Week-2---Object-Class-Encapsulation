package id.ac.polban.employee.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import id.ac.polban.employee.model.*;

public class EmployeeService {
    private Map<Integer, Employee> employees = new HashMap<>();

    public void addEmployee(Employee emp) {
        employees.put(emp.getId(), emp);
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void raiseSalary(int id, double percent) {
        Employee emp = employees.get(id);
        if (emp != null) {
            emp.setSalary(emp.getSalary() * (1 + percent / 100));
        }
    }

    // contoh static method untuk menampilkan jumlah employee
    public static void printTotalEmployees() {
        System.out.println("Total Employees: " + Employee.getEmployeeCount());
    }
    public Collection<Employee> getAllEmployees() {
    return employees.values();
}
    // Static method untuk menghitung pajak (contoh sederhana)
    public static double calculateTax(double salary) {
        return salary * 0.1; // 10% tax
    }

    // Static method untuk menghitung gaji bersih
    public static double calculateNetSalary(double salary) {
        return salary - calculateTax(salary);
    }
}
