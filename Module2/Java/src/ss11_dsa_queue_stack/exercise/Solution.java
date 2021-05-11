package ss11_dsa_queue_stack.exercise;



public class Solution {
    public static class Queue {
        private Node front;
        private Node rear;

        public Queue(Node front, Node rear) {
            this.front = front;
            this.rear = rear;
        }

        public Queue() {
        }

        public Node getFront() {
            return this.front;
        }

        public void setFront(Node front) {
            this.front = front;
        }

        public Node getRear() {
            return this.rear;
        }

        public void setRear(Node rear) {
            this.rear = rear;
        }
    }

    public class Node {
        private int data;
        private Node link;

        public Node(int data) {
            this.data = data;
        }

        public Node() {
        }

        public int getData() {
            return this.data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLink() {
            return this.link;
        }

        public void setLink(Node link) {
            this.link = link;
        }
    }

    public void enQueue(Queue queue, int data) {
        Node newNode = new Node( data );
        if (queue.getFront() == null) {
            queue.setFront( newNode );
        } else {
            queue.getRear().setLink( newNode );
        }
        queue.setRear( newNode );
        queue.getRear().setLink( queue.getFront() );
    }

    public int deQueue(Queue queue) {
        int data;
        if (queue.getFront() == null) {
            System.out.println( "Queue is empty" );
            return 0;
        } else if (queue.getFront() == queue.getRear()) {
            data = queue.getFront().getData();
            queue.setRear( null );
            queue.setFront( null );
            return data;
        } else {
            data = queue.getFront().getData();
            queue.setFront( queue.getFront().getLink() );
            queue.getRear().setLink( queue.getFront() );
            return data;
        }
    }

    public void displayQueue(Queue queue) {
        Node temp = queue.getFront();
        if (queue.getFront() == null) {
            System.out.println( "Queue is empty!!!" );
        } else {
            while (temp.getLink() != queue.getFront()) {
                System.out.print( temp.getData() + "\t" );
                temp = temp.getLink();
            }
            System.out.print( temp.getData() );
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        Solution solution = new Solution();
        solution.enQueue( queue, 1 );
        solution.enQueue( queue, 2 );
        solution.enQueue( queue, 3 );
        solution.enQueue( queue, 4 );
        solution.enQueue( queue, 5 );
        solution.deQueue( queue );
        solution.displayQueue( queue );
    }
}
