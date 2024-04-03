package application;

import entities.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        File path = new File("Files\\Salaries.txt");

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();
            while(line != null) {
                String employee[] = line.split(",");
                list.add(new Employee(employee[0], Double.parseDouble(employee[1])));
                line = br.readLine();
            }
            Collections.sort(list);
            for(Employee e : list) {
                System.out.println(e.getName()+", $ "+e.getSalary());
            }
        } catch(IOException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
