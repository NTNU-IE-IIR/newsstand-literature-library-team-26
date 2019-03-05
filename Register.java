import java.util.ArrayList;
import java.util.Iterator;
/**
 * Register class, controls collections of books, 
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
    public boolean addBookToCollection(Book book)
    {
        boolean bookAdded = false;
        if(book.getEdition() > 0)
        {
            this.books.add(book);
            bookAdded = true;
        }    
        return bookAdded;
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
     * if collection is empty return true
     * else if collection has item/s return false
     * @return size of book collection 
     */
    public boolean isCollectionEmpty()
    {
        boolean empty = true;
        if(this.books.size() > 0)
        {
            empty = false;
        }
        
        return empty;
    }
    
    public int getSizeOfCollection()
    {
        return this.books.size();
    }
    
    /**
     * Prints out all book titles from the book collection
     */
    public void printOutAllBookTitles()
    {
        for(Book book: this.books)
        {
            System.out.println("Book title:\t" + book.getTitle());
        }
    }
    
    /**
     * searches for title and checks if it exists in out database
     * @param title Title to search for 
     */
    public Book searchBook(String title)
    {
        Book bookToBeFound = null;
        for(Book book: this.books)
        {
            if(book.getTitle().equalsIgnoreCase(title))
            {
                bookToBeFound = book;
            } 
        }
        return bookToBeFound;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}