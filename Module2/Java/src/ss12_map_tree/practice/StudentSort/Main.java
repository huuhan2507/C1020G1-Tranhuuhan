package ss12_map_tree.practice.StudentSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student( "Han", 16, "Sai Gon" );
        Student student1 = new Student( "Hien", 21, "Thanh Hoa" );
        Student student2 = new Student( "Hang", 24, "Sai Gon" );

        List<Student> list = new ArrayList<>();
        list.add( student );
        list.add( student1 );
        list.add( student2 );
        System.out.println( "Before List Student: " );
        for (Student st : list) {
            System.out.println( st.toString() );
        }
        Collections.sort( list );
        System.out.println( "After List Student: " );
        for (Student st : list) {
            System.out.println( st.toString() );
        }
        System.out.println("-----------------------------------");
        System.out.println("Before List Student: ");
        for (Student st : list) {
            System.out.println( st.toString() );
        }
        AgeComparator ageComparator= new AgeComparator();
        Collections.sort( list,ageComparator );
        System.out.println("After List Student: ");
        for (Student st : list) {
            System.out.println( st.toString() );
        }
    }
}
