/*
 * @author: Sigurdur Hallur Jonsson
 */

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author siggi
 */
public class BookTest {
    
    private Book book;
    
    public BookTest() 
    {
        this.book = new Book("The chase", "The Rock", "Enviro", "2018-02-07",1);
    }

    @Before
    public void setUp()
    {

    }
    
    /**
     * Test of getTitle method, of class Book.
     */
    @Test
    public void testGetTitle() {
        String result = this.book.getTitle();
        assertEquals("The chase", result);
    }

    /**
     * Test of getAuthor method, of class Book.
     */
    @Test
    public void testGetAuthor() {
        String result = book.getAuthor();
        assertEquals("The Rock", result);
    }

    /**
     * Test of getPublisher method, of class Book.
     */
    @Test
    public void testGetPublisher() {
        String result = book.getPublisher();
        assertEquals("Enviro", result);
    }

    /**
     * Test of getDatePublished method, of class Book.
     */
    @Test
    public void testGetDatePublished() {
        String result = book.getDatePublished();
        assertEquals("2018-02-07", result);
    }

    /**
     * Test of getEdition method, of class Book.
     */
    @Test
    public void testGetEdition() {
        int result = book.getEdition();
        assertEquals(1, result);
    }
    
}
