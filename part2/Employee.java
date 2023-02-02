package pl.ladybroker.part2;

import java.util.Locale;
import java.util.Scanner;

public abstract class Employee {
    private final String firstname;
    private final String lastname;
    private final int age;
    private final Sex sex;
    protected final int salary;

    protected final String[] skills;



    public Employee(String firstname, String lastname, int age, Sex sex, int salary, String[] skills) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
        this.skills = skills;

    }

    public abstract double getTotalSalary();


    public String[] getSkills() {
        return skills;
    }

    public void print() {
        System.out.println(this);
    }

    public int getSalary() {
        return salary;
    }

    public String toString() {
        char sexChar = sex == Sex.FEMALE ? 'K': 'M';
        String skillsStr = String.join(", ", skills);

       return (firstname + " " + lastname + " " + age + " " + sexChar + " " + getTotalSalary() + " ZŁ [" + skillsStr + "] ");
    }
    public boolean isEqual(Employee otherEmployee) {
        return this.firstname.equalsIgnoreCase(otherEmployee.firstname)
                && this.lastname.equalsIgnoreCase(otherEmployee.lastname)
                && this.age == otherEmployee.age
                && this.sex == otherEmployee.sex
                && this.salary == otherEmployee.salary;

    }
}







