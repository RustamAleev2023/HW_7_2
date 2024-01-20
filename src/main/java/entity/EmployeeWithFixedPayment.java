package entity;

public class EmployeeWithFixedPayment extends Employee {

    public int salary;
    public int bonus; //премия 20% если отработал в месяц 200 часов. 1 рабочий день - 8 часов


    public EmployeeWithFixedPayment(String name, String salaryType, int salaryPerDay, int days) {
        super(name, salaryType);
        this.salary = salaryPerDay * days;
        if (days * 8 > 200){
            bonus = 20;
        }
    }

    @Override
    public int getSalary() {
        return salary;
    }

    public int getBonus() {
        return bonus;
    }
}
