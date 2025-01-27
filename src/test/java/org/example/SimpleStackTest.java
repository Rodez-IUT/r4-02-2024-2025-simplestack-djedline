package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest {

    @Test
    @DisplayName("Test the state of a newly created slack")
    public void testCreateEmptyStack() { // Test case

        // When a freshly stack is created
        Stack stack = new SimpleStack();

        // Then… (oracle)
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals( 0, stack.getSize(), "A new stack has no element");
    }

    @Test
    @DisplayName("Test the push one item")
    public void testPushOneitem() throws EmptyStackException {

        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must constain 1 item");
        assertSame( item, stack.peek(),"The pushed item must be is on top of the stack");
    }

    @Test
    @DisplayName("Test the push two items")
    public void testPushTwoItems() throws EmptyStackException {

        // Given an empty stack and two items
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();
        Item item2 = new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // When we add the new item
        stack.push(item2);

        // then...
        assertFalse(stack.isEmpty(), "The stack must be not empty");
        assertEquals(2, stack.getSize(),"The stack must constain 2 items");
        assertSame( item2, stack.peek(),"The pushed item must be on top of the stack");
    }

    @Test
    // @Disabled Permet de ne pas prendre le test en compte
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack()  {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "pop" the stack, should throws an EmptyStackException.
        assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    // @Disabled Permet de ne pas prendre le test en compte
    @DisplayName("Test limit when trying to pop an fill stack")
    public void testPopOnFillStack() throws EmptyStackException {
        // Given an fill stack
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        stack.push(item);

        // When we "pop" the stack, should an same item.
        assertSame( item, stack.pop(),"The pushed item must be on top of the stack");
    }

    @Test
    // @Disabled Permet de ne pas prendre le test en compte
    @DisplayName("Test limit when trying to push after to pop an fill stack")
    public void testPushAfterPopOnFillStack() throws EmptyStackException {
        // Given an fill stack
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();
        Item item2 = new SimpleItem();
        Item beforeItem;

        stack.push(item);
        beforeItem = stack.peek();

        stack.push(item2);
        stack.pop();

        // When we "pop" the stack, should an same item.
        assertSame(beforeItem, stack.peek(),"The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test limit when trying to peek an empty stack")
    public void testPeekOnEmptyStack()  {
        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "peek" the stack, should throws an EmptyStackException.
        assertThrows(EmptyStackException.class, ()->stack.peek(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::peek, "EmptyStackException not thrown");
    }


}
