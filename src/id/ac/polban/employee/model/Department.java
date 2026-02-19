package id.ac.polban.employee.model;

public class Department {
    private String name;

    // static field untuk menghitung jumlah department
    private static int departmentCount = 0;

    public Department(String name) {
        this.name = name;
        departmentCount++;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // static method
    public static int getDepartmentCount() {
        return departmentCount;
    }
}

