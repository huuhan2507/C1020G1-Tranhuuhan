package ss12_map_tree.practice.hashmap_and_hashset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student student = new Student( "Han", 18, "Phu Yen" );
        Student student1 = new Student( "Hien", 24, "Phu Yen" );
        Student student2 = new Student( "Hau", 20, "Sai Gon" );

        Map<Integer, Student> map = new HashMap<>();
        map.put( 1, student );
        map.put( 2, student1 );
        map.put( 3, student2 );
        for (Map.Entry<Integer, Student> element : map.entrySet()) {
            System.out.println( element.toString() );
        }
        System.out.println( "...........Set" );
        Set<Student> students = new HashSet<>();
        students.add( student );
        students.add( student1 );
        students.add( student2 );
        students.add( student );

        for (Student element : students) {
            System.out.println( element.toString() );
        }
    }
}
