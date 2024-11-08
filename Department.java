package practice;

interface IOrganizationComponent {
    String b=null;

    int salary=0;
    int GetCountEmployes();
    int GetCountSalary();
}
class Department implements IOrganizationComponent{
    String name;
    int salary;
    public int GetCountEmployes(){
        return 0;
    }
    public int GetCountSalary(){
        return salary;
    }
}

class Employee {}