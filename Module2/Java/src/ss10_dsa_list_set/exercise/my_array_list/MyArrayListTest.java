package ss10_dsa_list_set.exercise.my_array_list;

public class MyArrayListTest {
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

        public static void main(String[] args) {
            Student student = new Student( 1, "Han" );
            Student student1 = new Student( 2, "Phin" );
            Student student2 = new Student( 3, "Long" );
            Student student3 = new Student( 4, "Nhat" );
            MyArrayList<Student> studentMyArrayList = new MyArrayList<>();
            studentMyArrayList.add( student );
            studentMyArrayList.add( student1 );
            studentMyArrayList.add( student2 );
            studentMyArrayList.add( student3 );
            System.out.println( studentMyArrayList.constant( student1 ) );
            System.out.println(studentMyArrayList.get( 1 ));
            System.out.println(studentMyArrayList.size());
        }
    }
}
