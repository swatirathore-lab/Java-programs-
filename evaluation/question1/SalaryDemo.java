class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public double calculateSalary() {
        return 0;   // a normal person has no salary
    }

    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Faculty extends Person {
    protected int empId;
    protected double basicSalary;

    public Faculty(String name, int age, int empId, double basicSalary) {
        super(name, age);   // constructor chaining
        this.empId = empId;
        this.basicSalary = basicSalary;
    }

    @Override
    public double calculateSalary() {
        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;
        return basicSalary + hra + da;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Employee ID: " + empId + ", Type: Faculty");
    }
}

class Professor extends Faculty {
    private double researchAllowance;

    public Professor(String name, int age, int empId, double basicSalary, double researchAllowance) {
        super(name, age, empId, basicSalary);
        this.researchAllowance = researchAllowance;
    }

    @Override
    public double calculateSalary() {
        // professor gets everything a faculty gets plus the research allowance
        return super.calculateSalary() + researchAllowance;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Research Allowance: " + researchAllowance + " (Professor)");
    }
}

public class SalaryDemo {
    public static void main(String[] args) {
        // parent reference, child objects (runtime polymorphism)
        Person[] people = new Person[3];
        people[0] = new Person("Amit", 25);
        people[1] = new Faculty("Neha", 35, 1001, 40000);
        people[2] = new Professor("Dr. Sharma", 50, 2001, 70000, 15000);

        for (Person p : people) {
            p.display();
            System.out.println("Salary: " + p.calculateSalary());
            System.out.println("-----------------------");
        }
    }
}