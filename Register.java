import java.util.ArrayList;
import java.util.Iterator;
/**
 * Register class, controles collections of books, 
 * magazines and newspapers.
 * @author Gruppe 26
 * @version 2019-02-06
 */
public class Register
{
    private ArrayList<Book> books;
    
    /**
     * Constructor to register, initializes a collection of books
     */
    public Register()
    {
        this.books = new ArrayList<Book>();
    }
    
    /**
     * Adds a book to the book collection.
     * @param book Book to add to collection
     */
    public void addBookToCollection(Book book)
    {
        this.books.add(book);
    }
    
    /**
     * Removes a book from the book collection.
     * @param book Book to remove from collection
     */
    public void removeBookToCollection(Book book)
    {
        this.books.remove(book);
    }
    
    /**
     * Prints out all book titles from the book collection
     */
    public void printOutAllBookTitles()
    {
        for(Book book: this.books)
        {
            System.out.println(book.getTitle());
        }
    }
    
    /**
     * searches for title and checks if it exists in out database
     * @param title Title to search for 
     */
    public void searchBook(String title)
    {
        for(Book book: this.books)
        {
            if(book.getTitle().equalsIgnoreCase(title))
            {
                System.out.println("The book " + book.getTitle() 
                + " was found in our database");
            }
        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}