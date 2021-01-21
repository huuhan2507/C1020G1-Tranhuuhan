package ss12_map_tree.exercise.binary_search_tree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(20);
        tree.insert(10);
        tree.insert(30);
        tree.insert(35);
        tree.insert(15);
        tree.insert(17);
        tree.insert(5);
        tree.insert( 19 );
        tree.print( tree.root );
        System.out.println();
        System.out.println();
        System.out.println( tree.search( tree.root, 5 ) );
    }
}
