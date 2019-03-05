
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 * 
 * @author asty
 * @version 1.0
 */
public class ApplicationUI 
{

    private Register register;
    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
    private String[] menuItems = {
        "1. List all books",
        "2. Add new book",
        "3. Find a book by title",
    };

    /**
     * Creates an instance of the ApplicationUI User interface. 
     */
    public ApplicationUI() 
    {
        this.register = new Register();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start() 
    {
        this.init();

        boolean quit = false;

        while (!quit) 
        {
            try 
            {
                int menuSelection = this.showMenu();
                switch (menuSelection) 
                {
                    case 1:
                        this.listAllProducts();
                        break;

                    case 2:
                        this.addNewProduct();
                        break;

                    case 3:
                        this.findProductByName();
                        break;

                    case 4:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            } 
            catch (InputMismatchException ime) 
            {
                System.out.println("\nERROR: Please provide a number between 1 and " 
                        + this.menuItems.length + "..\n");
            }
        }        
        
    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items. 
     * If the user inputs anything else, an InputMismatchException is thrown. 
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    private int showMenu() throws InputMismatchException 
    {
        System.out.println("\n**** Application v0.1 ****\n");
        // Display the menu
        for ( String menuItem : menuItems )
        {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) 
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }
    
    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made privat, since they are only used by the menu ---
    
    /**
     * Initializes the application.
     * Typically you would create the LiteratureRegistrer-instance here
     */
    private void init()
    {
        System.out.println("The Book store is open");
        loadBooksFromDatabase();
    }

    /**
     * Lists all the products/literature in the register
     */
    private void listAllProducts()
    {
        if(!this.register.isCollectionEmpty())
        {
            System.out.println( "\nBooks available:" );
            this.register.printOutAllBookTitles();
            System.out.println( "" );
        } else {
            System.out.println("There are no books in the collection\n\n");
            
        }
    }

    
    /**
     * Add a new product/literature to the register.
     * In this method you have to add code to ask the
     * user for the necessary information you need to 
     * create an instance of the product, which you
     * then send as a parameter to the addNewspaper()-
     * method of the register.
     * Remember to also handle invalid input from the
     * user!!
     */
    private void addNewProduct()
    {
        Book book = newBook();
        
        boolean bookAdded = this.register.addBookToCollection(book);
        if(bookAdded)
        {
            System.out.println("New book \"" + book.getTitle() + "\" was added to collection.");
        }
        else {
            System.out.println( "Someting must have gone wrong.\n"
                    + "Maybe you used invalid edition number.\n"
                    + "Edition must be number higher then zero." );
        }
    }
    
    private Book newBook()
    {
        Scanner newBook = new Scanner(System.in);
        
        System.out.print("Enter books name: "); 
        String name = newBook.nextLine();
        
        System.out.print("Enter authors name: ");
        String author = newBook.nextLine();
        
        System.out.print("Enter publisher name: ");
        String publisher = newBook.nextLine();
        
        System.out.print("Enter date published: ");
        String published = newBook.nextLine();
        
        System.out.print("Enter edition: ");
        int edition = newBook.nextInt();
        
        Book book = new Book(name,author,publisher,published,edition);
        
        return book;
    }
    
    /**
     * Find and display a product based om name (title).
     * As with the addNewProduct()-method, you have to
     * ask the user for the string (name/title/publisher)
     * to search for, and then use this string as input-
     * parameter to the method in the register-object.
     * Then, upon return from the register, you need
     * to print the details of the found item.
     */
    private void findProductByName()
    {
        System.out.print("Enter title of book: ");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        
        Book book = this.register.searchBook(title);
        if(book != null)
        {
            printBooksInfo(book);
        }
        else {
            System.out.println( "Book not found! "
                    + "Make sure you spell the title correctly." );
        }
        
    }
    
    
    /**
     * generates dummie books and adds them to the collection
     */
    private void loadBooksFromDatabase()
    {
        Book dummie1 =  new Book("In the river","Cardi B","Vaka","2017",5);
        Book dummie2 =  new Book("Elevent hour","Lil Wayne","Vaka","2017",5);
        Book dummie3 =  new Book("Mistic mountain","Jay C","Vaka","2017",5);
        Book dummie4 =  new Book("Smell of the flowers","Nicki Minaj","Vaka","2017",5);
        Book dummie5 =  new Book("Go with the flow","Snoope Dog","Vaka","2017",5);
        
        this.register.addBookToCollection( dummie1 );
        this.register.addBookToCollection( dummie2 );
        this.register.addBookToCollection( dummie3 );
        this.register.addBookToCollection( dummie4 );
        this.register.addBookToCollection( dummie5 );
    }
    
    /**
     * prints out all information about book
     * @param book to print out info about
     */
    private void printBooksInfo(Book book)
    {
        System.out.println("**********************");
        System.out.println("Title: \t\t" + book.getTitle());
        System.out.println("Author: \t" + book.getAuthor());
        System.out.println("Publisher: \t" + book.getPublisher());
        System.out.println("Published: \t" + book.getDatePublished());
        System.out.println("Edition: \t" + book.getEdition());
        System.out.println("*********************");
        System.out.println("");
    }
    
}
