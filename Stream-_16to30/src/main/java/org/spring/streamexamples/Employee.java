package org.spring.streamexamples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Employee implements Comparable<Employee> {

    int id;
    String name;

    Employee(int id, String name){
        this.id=id;
        this.name=name;
    }

    @Override
    public int compareTo(Employee e){
       return this.id-e.id;
    }

    @Override
    public String toString(){
        return id+" "+name+" ";
    }

    public static void main(String[] args) {
        Employee e=new Employee(10, "Shridevi");
        Employee e1=new Employee(12, "Omkar");
        Employee e2=new Employee(11, "Mahek");
        Employee e3=new Employee(13, "Akshata");
        List<Employee> emp=new ArrayList<>();
        emp.add(e);
        emp.add(e1);
        emp.add(e2);
        emp.add(e3);

        System.out.println(emp);
        Collections.sort(emp);
        System.out.println(emp);
    }
}
