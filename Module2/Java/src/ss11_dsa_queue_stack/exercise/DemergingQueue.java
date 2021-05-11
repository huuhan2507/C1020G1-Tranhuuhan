package ss11_dsa_queue_stack.exercise;

import java.util.*;

public class DemergingQueue {
    public static class Employee implements Comparable<Employee> {
        private String name;
        private String gender;
        private String dateOfBirth;

        public Employee(String name, String gender, String dateOfBirth) {
            this.name = name;
            this.gender = gender;
            this.dateOfBirth = dateOfBirth;
        }

        public Employee() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        @Override
        public String toString() {
            return "Name: " + this.getName() + "\t" + " Gender: " + this.getGender() + "\t" + " DateOfBirth: " + this.getDateOfBirth();
        }

        @Override
        public int compareTo(Employee o) {
            return this.getDateOfBirth().compareTo( o.getDateOfBirth() );
        }
    }

    public static void main(String[] args) {
        List<Employee> listEmployee = new ArrayList<>();
        listEmployee.add( new Employee( "Le Thi Hang", "female", "1994/20/09" ) );
        listEmployee.add( new Employee( "Le Loi", "male", "1995/01/02" ) );
        listEmployee.add( new Employee( "Le Phuong thuy", "female", "2004/09/17" ) );
        listEmployee.add( new Employee( "Nguyen Van B", "male", "1987/01/05" ) );
        listEmployee.add( new Employee( "Nguyen Le Thu Trang", "female", "1999/08/15" ) );

        System.out.println( "pre-sort" );
        for (int i = 0; i < listEmployee.size(); i++) {
            System.out.println( listEmployee.get( i ) );
        }

        Collections.sort( listEmployee );

        System.out.println( "sort by date of birth" );
        for (int i = 0; i < listEmployee.size(); i++) {
            System.out.println( listEmployee.get( i ) );
        }

        Deque<Employee> male = new LinkedList<>();
        Deque<Employee> female = new LinkedList<>();
        for (int i = 0; i < listEmployee.size(); i++) {
            if ("female".equals( listEmployee.get( i ).getGender() )) {
                female.add( listEmployee.get( i ) );
            } else {
                male.add( listEmployee.get( i ) );
            }
        }
        int count = 0;
        while (!female.isEmpty()) {
            listEmployee.set( count, female.pop() );
            count++;
        }

        while (!male.isEmpty()) {
            listEmployee.set( count, male.pop() );
            count++;
        }

        System.out.println( "sort by gender" );
        for (int i = 0; i < listEmployee.size(); i++) {
            System.out.println( listEmployee.get( i ) );
        }
    }
}