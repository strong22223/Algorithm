package LearningJava;

public class Employee implements Comparable<Employee>, Cloneable {
    int salary;
    CopyArray i;
    String name;

    public int compareTo(Employee other) {

        return Double.compare(this.salary, other.salary);
    }

    public int getSalary() {
        return salary;
    }

    public CopyArray getI() {
        return i;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Employee employee = new Employee();
        employee.salary = 1000;
        employee.i = new CopyArray();
        Employee clone = employee.clone();

        System.out.println(clone.salary + "   " + clone.i.hashCode());
        System.out.println(employee.salary + "   " + employee.i.hashCode());


    }

    @Override
    public Employee clone() throws CloneNotSupportedException {


        return (Employee) super.clone();

    }
}
