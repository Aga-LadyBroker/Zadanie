package pl.ladybroker.part2;

import java.util.Scanner;

public class Manager extends Employee {
    private final int teamSize;


    public Manager(String firstname, String lastname, int age, Sex sex, int salary, String[] skills, int teamSize) {
        super(firstname, lastname, age, sex, salary, skills);
        this.teamSize = teamSize;
    }

    public String toString() {
        return "K "+ super.toString() + " " + teamSize;
    }
    public double getTotalSalary() {
        int bonusLevel1 = teamSize / 5;
        double bonus = salary * bonusLevel1 * 0.05;

        return salary + bonus;
    }
    public static Manager read() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj rozmiar zespołu: ");
        int teamSize = scanner.nextInt();

        System.out.print("Podaj imię:      ");
        String firstname = scanner.next();

        System.out.print("Podaj nazwisko: ");
        String lastname = scanner.next();

        System.out.print("Podaj wiek:     ");
        int age = scanner.nextInt();

        System.out.print("Podaj płeć:  ");
        char charSex = scanner.next().toUpperCase().charAt(0);
        Sex sex = charSex == 'K' ? Sex.FEMALE : Sex.MALE;

        System.out.print("Podaj zarobki: ");
        int salary = scanner.nextInt();

        scanner.nextLine();
        System.out.print("Podaj umijetności: ");
        String skillsStr = scanner.nextLine();

        String[] skills = skillsStr.split(",");


        for (int i = 0; i < skills.length; i++) {
            skills[i] = skills[i].trim();
        }

        return new Manager(firstname,lastname,age,sex,salary,skills,teamSize);
    }
}
