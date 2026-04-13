package streamproblems;

import java.util.*;
import java.util.stream.Collectors;


public class Day2EmployeeQuery {
        public static void main(String[] args) {
            List<Employee> employees = createEmployees();
            maleandfemale(employees);
            departNames(employees);
            avergeage(employees);
            highestsalary(employees);
            joinedlater(employees);
            workingineachdepth(employees);
            saleachdept(employees);
            youngestemployees(employees);
            mostWorkedemployees(employees);
            namesempeachdept(employees);
            oldfestemployees(employees);

        }

        //Listing the number male and female employess
        private static void maleandfemale(List<Employee> employees) {
            System.out.println("//Male employee //");
            Set<Employee> maleemployees = employees.stream()
                    .filter(employee -> employee.gender().equalsIgnoreCase("male"))
                    .collect(Collectors.toSet());
            maleemployees.forEach(System.out::println);

            System.out.println();
            System.out.println("//Female employee list//");

            Set<Employee> femaleemployee=employees.stream()
                    .filter(employee -> employee.gender().equalsIgnoreCase("female"))
                    .collect(Collectors.toSet());
            femaleemployee.forEach(s-> System.out.println(s));

            System.out.println();
            System.out.println("//Group male and female employees differently//");

            Map<String, List<Employee>> gendergroup=getCollect(employees);
            //Set<String> gender=gendergroup.keySet();
            //gender.forEach(System.out::println);
            for(Map.Entry<String, List<Employee>> entry:gendergroup.entrySet()){
                System.out.println(entry.getKey()+":");
                entry.getValue().stream().forEach(System.out::println);

                System.out.println();
                System.out.print("//Count the number of employees by their gender// ");
                System.out.println();
                Map<String, Long> gendercount=employees.stream()
                        .collect(Collectors.groupingBy(Employee::gender, Collectors.counting()));
                System.out.println(gendercount);
            }
        }
        private static Map<String, List<Employee>> getCollect(List<Employee> employees) {
            return employees.stream().collect(Collectors.groupingBy(Employee::gender));
        }


        /// Print the department whose employess salary is lessthan 2000

        private static void departNames(List<Employee> employees) {
            System.out.println();
            System.out.println("//Print Employee's Department names whose salary > 20000//");
            Set<String> departments= (Set<String>) employees.stream()
                    .filter(employee -> employee.sal()>20000)
                    .map(Employee::department).collect(Collectors.toSet());
            departments.forEach(System.out::println);
        }

        //Print the average age of employees
        private static void avergeage(List<Employee> employees) {
            System.out.println();
            System.out.println("//Average age of employees//");
            Map<String, Double> groupbyage=employees.stream()
                    .collect(Collectors.groupingBy(Employee::gender, Collectors.averagingInt(Employee::age)));
            groupbyage.forEach((keygender,valueage)->System.out.println(keygender+":"+valueage));
            //System.out.println(groupbyage);
        }

        //Print the Highest salary of the employee
        private static void highestsalary(List<Employee> employees){
            System.out.println();
            System.out.println("//List the highest salary of the Employees");
            Optional<Employee> highsalary=employees.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::sal)));
            highsalary.ifPresent(System.out::println);
        }

        //List the employees who joined after the 2016
        private static void joinedlater(List<Employee> employees){
            System.out.println();
            System.out.println("//Employees who joined after the 2016//");
            Set<Integer> joinedlater=employees.stream().filter(employee -> employee.yearosJoin()>2016)
                    .map(Employee::yearosJoin).collect(Collectors.toSet());
            joinedlater.forEach(System.out::println);
        }

        //List the employees who are working in each department
        private static void workingineachdepth(List<Employee> employees){
            System.out.println();
            System.out.println("//Employees who are working in each Department//");
            employees.stream().collect(Collectors.groupingBy(Employee::department, Collectors.counting()))
                    .forEach((dept, count)->System.out.println(dept+":"+count));

        }

        //List the emp who are getting avg sal in each dept
        private static void saleachdept(List<Employee> employees){
            System.out.println();
            System.out.println("//Employees who are getting salary in each department");
            Map<String, Double> avgsaldept=employees.stream()
                    .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::sal)));
            avgsaldept.forEach((dept, sal)->System.out.println(dept+":"+sal));

        }

        //Find the youngest employee in the product evelopment team
        private static void youngestemployees(List<Employee> employees){
            System.out.println();
            Optional<Employee> youngemp=employees.stream()
                    .filter(employee -> employee.department().equalsIgnoreCase("Product Development"))
                    .collect(Collectors.minBy(Comparator.comparing(Employee::age)));
            youngemp.ifPresentOrElse(System.out::println, ()-> System.out.println("No employees found"));
        }

        //Find the minimum working experience in male
        private static void mostWorkedemployees(List<Employee> employees){
            System.out.println();
            Optional<Employee> workingemployees=employees.stream().filter(employee -> employee.gender().equalsIgnoreCase("male"))
                    .collect(Collectors.minBy(Comparator.comparing(Employee::yearosJoin)));
            workingemployees.ifPresentOrElse(System.out::println, ()-> System.out.println("more experience"));

        }

        //find the names of each employee in each depart
        private static void namesempeachdept(List<Employee> employees){
            System.out.println();
            employees.stream().collect(Collectors.groupingBy(Employee::department)).
                    forEach((String dept, List<Employee> employeeList) ->
                            System.out.println(dept+":"+employeeList.stream().map(Employee::name)
                                    .collect(Collectors.joining(","))));
        }

        //Find the oldest employee in list
        private static void oldfestemployees(List<Employee> employees){
            System.out.println();
            employees.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::age)))
                    .ifPresent(employee -> {
                        System.out.println("name:"+employee.name());
                        System.out.println("age:"+employee.age());
                        System.out.println("joining: "+employee.yearosJoin());
                    });
        }


        private static List<Employee> createEmployees() {
            List<Employee> employeeList = new ArrayList<Employee>();

            employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000));
            employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500));
            employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000));
            employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
            employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
            employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
            employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
            employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
            employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
            employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
            employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
            employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
            employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
            employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
            employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
            employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
            employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700));
            return employeeList;


        }
    }



