package streamproblems;

public record Employee (int id, String name, int age, String gender, String department, int yearosJoin, double sal) {
    Employee(int id, String name) {
        this(id, name, 0, null, null, 0, 0.0);
    }
}

