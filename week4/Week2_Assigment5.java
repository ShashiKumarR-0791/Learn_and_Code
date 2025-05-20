class Employee {

    private int id;
    private String name;
    private String department;
    private boolean isWorking;

    public Employee(int id, String name, String department, boolean isWorking) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.isWorking = isWorking;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public boolean isWorking() {
        return isWorking;
    }

    public void terminateEmployee() {
        isWorking = false;
    }
}

class EmployeeDatabase {

    public void saveEmployee(Employee employee) {
        System.out.println("Saving employee to database: " + employee.getName());
    }
}

class EmployeeReportGenerator {

    public void printEmployeeDetailReportXML(Employee employee) {
        System.out.println("<employee>\n" +
                "  <id>" + employee.getId() + "</id>\n" +
                "  <name>" + employee.getName() + "</name>\n" +
                "  <department>" + employee.getDepartment() + "</department>\n" +
                "  <isWorking>" + employee.isWorking() + "</isWorking>\n" +
                "</employee>");
    }

    public void printEmployeeDetailReportCSV(Employee employee) {
        System.out.println("ID,Name,Department,Working\n" +
                employee.getId() + "," + employee.getName() + "," + employee.getDepartment() + "," + employee.isWorking());
    }
}

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(1, "Shashi", "Data Science", true);

        EmployeeDatabase database = new EmployeeDatabase();
        database.saveEmployee(employee);

        EmployeeReportGenerator reportGenerator = new EmployeeReportGenerator();
        reportGenerator.printEmployeeDetailReportXML(employee);
        reportGenerator.printEmployeeDetailReportCSV(employee);

        employee.terminateEmployee();
        System.out.println("Employee terminated: " + employee.isWorking());
    }
}
