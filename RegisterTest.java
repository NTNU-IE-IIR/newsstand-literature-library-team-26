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
public class RegisterTest {
    
    private Register register;
    private Book b1;
    private Book b2;
    private Book b3;
    
    public RegisterTest() 
    {
        register = new Register();
    }
    
    @Before
    public void setUp()
    {
        b1 = new Book("Siggi", "Hallur", "Jonsson", "2018",1);
        b2 = new Book("Sveinn", "Hallur", "Jonsson", "2018",1);
        b3 = new Book("Hreinn", "Hallur", "Jonsson", "2018",1);
    }
    /**
     * Test of addBookToCollection method, of class Register.
     */
    @Test
    public void testAddBookToCollection() 
    {
        register.addBookToCollection(b1);
        boolean empty = register.isCollectionEmpty();
        int num = register.getSizeOfCollection();
        assertEquals(false, empty);
        assertEquals(1,num);
    }

    /**
     * Test of removeBookToCollection method, of class Register.
     */
    @Test
    public void testRemoveBookToCollection() 
    {
        register.addBookToCollection(b2);
        register.addBookToCollection(b3);
        register.removeBookToCollection(b3);
        int num = register.getSizeOfCollection();
        assertEquals(1,num);
    }

    /**
     * Test of isCollectionEmpty method, of class Register.
     */
    @Test
    public void testIsCollectionEmpty() {
        boolean empty = register.isCollectionEmpty();
        assertEquals(true, empty);
    }

    /**
     * Test of printOutAllBookTitles method, of class Register.
     */
    @Test
    public void testPrintOutAllBookTitles() {
        register.addBookToCollection(b1);
        String str = register.printOutAllBookTitles();
        assertEquals("Siggi", str);
     
    }

    /**
     * Test of searchBook method, of class Register.
     */
    @Test
    public void testSearchBook() {
        
    }
    
}
