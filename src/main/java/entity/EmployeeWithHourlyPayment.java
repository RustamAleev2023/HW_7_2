package entity;

public class EmployeeWithHourlyPayment extends Employee{

    public int salary;
    public int bonus;
    public EmployeeWithHourlyPayment(String name, String salaryType, int salaryPerHour, int hours) {
        super(name, salaryType);
        this.salary = salaryPerHour * hours;
        if(hours > 200){
            bonus = 20;
        }
    }

    @Override
    public int getSalary() {
        return salary;
    }
}
