package entity;

public class Employee {
    public String name;
    public String salaryType;
    public int salary;
    public boolean hasChildren;
    public boolean isOffshore;
    public int bonus;

    public Employee(String name, String salaryType) {
        this.name = name;
        this.salaryType = salaryType;
        this.bonus = 0;
    }

    public String getName() {
        return name;
    }

    public boolean isOffshore() {
        return isOffshore;
    }

    public void setOffshore(boolean offshore) {
        isOffshore = offshore;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(String salaryType) {
        this.salaryType = salaryType;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean isHasChildren() {
        return hasChildren;
    }

    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }

    @Override
    public String toString() {
        return name + "\t" + salaryType + "\t\t\t" + this.getSalary();
    }
}
