package org.example;

import java.util.ArrayList;
public class SimpleStack implements Stack {

    private ArrayList<Item> stack;

    /**
     * Crée une pile simple
     */
    public SimpleStack() {
        this.stack = new ArrayList<>();
    }

    /**
     * Tests if this stack is empty
     */
    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    /**
     * Returns the number of items in this stack.
     */
    @Override
    public int getSize() {
        return this.stack.size();
    }

    /**
     * Pushes an item onto the top of this stack.
     * null item is allowed.
     *
     * @param item an item of the stack
     */
    @Override
    public void push(Item item) {
        this.stack.add(item);
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     */
    @Override
    public Item peek() throws EmptyStackException {
        if (this.stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return this.stack.get(this.stack.size()-1);
    }

    /**
     * Removes the object at the top of this stack and returns
     * that object as the value of this function.
     *
     * @throws EmptyStackException if this stack is empty.
     */
    @Override
    public Item pop() throws EmptyStackException {
        Item itemTop;
        if (this.stack.isEmpty()) {
            throw new EmptyStackException();
        }
        itemTop = this.peek();
        this.stack.remove(this.stack.size()-1);
        return itemTop;
    }
}
