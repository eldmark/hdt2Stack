import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * Universidad del Valle de Guatemala
 * Autor: Marco Alejandro Díaz Castañeda
 * Carnet: 24229
 * Fecha de inicio: 26/01/2025
 * Fecha de finalización: 27/01/2025
 * Descripción: Implementación de pruebas unitarias para la clase StackVector.
 * 
 */

/**
 * Unit tests for the StackVector class.
 */
public class StackVectorTest {
    private StackVector<Integer> stack;

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    public void setUp() {
        stack = new StackVector<Integer>();
    }

    /**
     * Tests the push method to ensure it correctly adds an element to the stack.
     */
    @Test
    public void testPush() {
        stack.push(1);
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
    }

    /**
     * Tests the pop method to ensure it correctly removes and returns the top
     * element of the stack.
     */
    @Test
    public void testPop() {
        stack.push(1);
        stack.push(2);
        int poppedValue = stack.pop();
        assertEquals(2, poppedValue);
        assertEquals(1, stack.size());
    }

    /**
     * Tests the peek method to ensure it correctly returns the top element of the
     * stack without removing it.
     */
    @Test
    public void testPeek() {
        stack.push(1);
        stack.push(2);
        int peekedValue = stack.peek();
        assertEquals(2, peekedValue);
        assertEquals(2, stack.size());
    }

    /**
     * Tests the size method to ensure it correctly returns the number of elements
     * in the stack.
     */
    @Test
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push(1);
        assertEquals(1, stack.size());
        stack.push(2);
        assertEquals(2, stack.size());
    }

    /**
     * Tests the empty method to ensure it correctly identifies whether the stack is
     * empty.
     */
    @Test
    public void testEmpty() {
        assertTrue(stack.empty());
        stack.push(1);
        assertFalse(stack.empty());
        stack.pop();
        assertTrue(stack.empty());
    }

    /**
     * Tests the pop method to ensure it throws an exception when attempting to pop
     * from an empty stack.
     */
    @Test
    public void testPopEmptyStack() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            stack.pop();
        });
    }

    /**
     * Tests the peek method to ensure it throws an exception when attempting to
     * peek at an empty stack.
     */
    @Test
    public void testPeekEmptyStack() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            stack.peek();
        });
    }

    /**
     * Tests pushing multiple elements and then popping them to ensure stack order
     * is maintained.
     */
    @Test
    public void testPushPopMultiple() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(3, stack.pop());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
        assertTrue(stack.empty());
    }

    /**
     * Tests pushing null elements to ensure the stack handles null values
     * correctly.
     */
    @Test
    public void testPushNull() {
        stack.push(null);
        assertEquals(1, stack.size());
        assertNull(stack.peek());
        assertNull(stack.pop());
        assertTrue(stack.empty());
    }
}
