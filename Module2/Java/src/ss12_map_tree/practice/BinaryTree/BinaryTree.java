package ss12_map_tree.practice.BinaryTree;

public class BinaryTree<E extends Comparable<E>> extends AbstractTree<E> {
    protected TreeNode<E> root;
    protected int size = 0;

    public BinaryTree() {
    }

    public BinaryTree(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert( objects[i] );
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode( e ); /*create a new root*/
        else {
            /*locate the parent node*/
            TreeNode<E> parent = null;
            TreeNode<E> current = root;
            while (current != null) {
                if (e.compareTo( current.element ) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo( current.element ) > 0) {
                    parent = current;
                    current = current.right;
                } else
                    return false; /*Duplicate node not inserted*/
            }
            if (e.compareTo( parent.element ) < 0)
                parent.left = createNewNode( e );
            else
                parent.right = createNewNode( e );
        }
        size++;
        return true; /*element inserted successfully*/
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>( e );
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void inorder() {
        inorder( root );
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder( root.left );
        System.out.println( root.element + " " );
        inorder( root.right );
    }

    public static void main(String[] args) {
        //create a BST
        BinaryTree<String> tree = new BinaryTree<>();
        tree.insert( "George" );
        tree.insert( "Michael" );
        tree.insert( "Tom" );
        tree.insert( "Adam" );
        tree.insert( "Jones" );
        tree.insert( "Peter" );
        tree.insert( "Daniel" );
        //traverse tree
        System.out.println( "Inorder (sorted): " );
        tree.inorder();
        System.out.println( "The number of nodes is: " + tree.getSize() );
    }

}


