package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using
 * a Linked List structure to allow for unbounded size.
 * <p></p>
 * The {@code isEmpty} and {@code size} methods are provided,
 * on the house.
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {

    Node<T> first;
    int size;

    /**
     * {@inheritDoc}.
     */
    @Override
    public T pop() throws StackUnderflowException {
        // TODO: Implement the pop method, which will be
        //   similar to a removeFirst method for a LinkedList
        //   (a special case of our remove method).
        //   If the list is empty you should throw an exception.
        if (isEmpty()) {
            throw new StackUnderflowException("Stack underflow. Cannot pop from an empty stack.");
        }
        T element = first.element;
        first = first.next;
        size--;
        return element;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public T top() throws StackUnderflowException {
        // TODO: Implement the top method, which will be
        //   similar to a getFirst method for a LinkedList
        //   (a special case of our get method).
        //   If the list is empty you should throw an exception.
        if (isEmpty()) {
            throw new StackUnderflowException("Stack underflow. Cannot pop from an empty stack.");
        }
        return first.element;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public void push(T elem) throws NullPointerException {
        // TODO: Implement the push method, which will be
        //   similar to the addFirst method for a LinkedList.
        //   If elem is null you should throw an exception.
        if (elem == null) {
            throw new NullPointerException("Cannot push null onto the stack");
        }
        Node<T> newNode = new Node<>(elem);
        newNode.next = first;
        first = newNode;
        size++;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * {@inheritDoc}.
     */
    @Override
    public int size() {
        return size;
    }
}
