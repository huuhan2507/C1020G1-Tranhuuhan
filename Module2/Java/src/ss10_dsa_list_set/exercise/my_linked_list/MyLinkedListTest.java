package ss10_dsa_list_set.exercise.my_linked_list;

public class MyLinkedListTest {
    public static class Student {
        private int id;
        private String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Id: " + id + "\t" + "Name: " + name;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Student> studentMyLinkedList= new MyLinkedList<>();
        Student student= new Student(1,"han");
        Student student1= new Student(2,"han1");
        Student student2= new Student(3,"han2");
        Student student3= new Student(4,"han3");
        studentMyLinkedList.addFirst(student);
        studentMyLinkedList.addFirst(student2);
        studentMyLinkedList.addFirst(student3);
        studentMyLinkedList.addFirst(student1);
        for (int i = 0; i <studentMyLinkedList.size() ; i++) {
            System.out.println(studentMyLinkedList.get( i ));
        }

    }
}
