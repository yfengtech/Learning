package tree;

public class Tree<E> {
    private Node<E> root;

    private static class Node<E>{
        private E data;
        public Node<E> firstNode;
        public Node<E> nextSibling;
    }

    public void add(E e){

    }
}
