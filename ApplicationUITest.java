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
public class ApplicationUITest {
    
    private Register register;
    
    public ApplicationUITest() 
    {
        register = new Register();
        Book b1 = new Book("The chase", "The Rock", "Enviro", "2018-02-07",1);
        Book b2 = new Book("The chase 2", "The Rock", "Enviro", "2018-02-07",1);
        Book b3 = new Book("The chase 3", "The Rock", "Enviro", "2018-02-07",1);
        Book b4 = new Book("The chase 4", "The Rock", "Enviro", "2018-02-07",1);
        
        register.addBookToCollection(b1);
        register.addBookToCollection(b2);
        register.addBookToCollection(b3);
        register.addBookToCollection(b4);
    }

    /**
     * Test of start method, of class ApplicationUI.
     */
    
    @Before
    public void setUp()
    {
        //ApplicationUI app = new ApplicationUI();
        
    }
    
    @Test
    public void testStart() {
        
        
    }
    
    
}
