package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class IOrganizationComponent {
    String b;
    int salary;

    int GetCountEmployes() {
        return 0;
    }

    int GetCountSalary() {
        return 0;
    }
}

class Department extends IOrganizationComponent {
    String name;
    List<IOrganizationComponent> employes;

    public Department() {
        employes = new ArrayList<>();
    }

    public Department(List<IOrganizationComponent> list) {
        employes = new ArrayList<>(list);
    }

    @Override
    public int GetCountEmployes() {
        return employes.size();
    }

    @Override
    public int GetCountSalary() {
        return employes.stream().mapToInt(employee -> employee.GetCountSalary()).sum();
    }
}

class Employee extends IOrganizationComponent {
    String name;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    @Override
    public int GetCountSalary() {
        return salary;
    }

    @Override
    public int GetCountEmployes() {
        return 1;
    }
}

class Main2 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Assiya", 250000);
        Employee employee2 = new Employee("Aisha", 350000);
        Employee employee3 = new Employee("Abdulla", 150000);

        Department department = new Department(Arrays.asList(employee1, employee2, employee3));

        System.out.println("Total Employees: " + department.GetCountEmployes());
        System.out.println("Total Salary: " + department.GetCountSalary());
    }
}
