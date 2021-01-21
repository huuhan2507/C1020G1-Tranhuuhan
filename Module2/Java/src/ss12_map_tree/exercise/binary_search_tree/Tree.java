package ss12_map_tree.exercise.binary_search_tree;

public class Tree<E> {
    protected Tree left;
    protected Tree right;
    protected E element;

    public Tree(E element) {
        this.element = element;
    }
}
