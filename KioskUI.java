/*
 * @author: Sigurdur Hallur Jonsson
 */
package kiosk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author siggi
 */
public class KioskUI 
{
private Register register;
    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
    private String[] menuItems = {
        "1. List all reading material",
        "2. Add new reading material",
        "3. Find reading material by title",
    };
    
    private String[] readingMaterialItems = {
      "1. Add new book",
        "2. Add new magazine",
        "3. Add new newspaper"
    };

    /**
     * Creates an instance of the ApplicationUI User interface. 
     */
    public KioskUI() 
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
        loadFromDatabase();
    }

    /**
     * Lists all the products/literature in the register
     */
    private void listAllProducts()
    {
        if(!this.register.isCollectionEmpty())
        {
            System.out.println( "\nReading material available:" );
            this.register.printOutAllTitles();
            System.out.println( "" );
        } else {
            System.out.println("There are no reading material in the collection\n\n");
            
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
        boolean quit = false;
        
        while(!quit)
        {
            try
            {
                int selectReadingMaterial = this.showReadingMaterialMenu();
                
                switch(selectReadingMaterial)
                {
                    case 1:
                        ReadingMaterial book = this.newBook();
                        this.register.addToCollection(book);
                        break;
                    case 2:
                        ReadingMaterial magazine = this.newMagazine();
                        this.register.addToCollection(magazine);
                        break;
                    case 3:
                        ReadingMaterial newspaper = this.newNewsPaper();
                        this.register.addToCollection(newspaper);
                        break;
                    case 4:
                        quit = true;
                        break;
                    default:
                }
            } 
            catch(InputMismatchException ime)
            {
                System.out.println("\nERROR: Please provide a number between 1 and " 
                        + this.menuItems.length + "..\n");
            }
        }
    }
    
    private int showReadingMaterialMenu() throws InputMismatchException
    {
        System.out.println("\n*** Add Reading Material ***\n");
        // Display the menu
        for ( String menuItem : readingMaterialItems )
        {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = readingMaterialItems.length + 1;
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
        
        ReadingMaterial book = 
                new Book(name,publisher,published,author,edition);
        
        return (Book) book;
    }
    
    private Magazine newMagazine()
    {
        Scanner newMagazine = new Scanner(System.in);
        
        System.out.print("Enter Magazine name: "); 
        String title = newMagazine.nextLine();
        
        System.out.print("Enter publisher name: ");
        String publisher = newMagazine.nextLine();
        
        System.out.print("Enter date published: ");
        String published = newMagazine.nextLine();
        
        System.out.print("Enter issue: ");
        int issue = newMagazine.nextInt();
        
        ReadingMaterial magazine = 
                new Magazine(title,publisher,published,issue);
        
        return (Magazine) magazine;
    }
    
    private Newspaper newNewsPaper()
    {
        Scanner newNewspaper = new Scanner(System.in);
        
        System.out.print("Enter Newspaper name: "); 
        String title = newNewspaper.nextLine();
        
        System.out.print("Enter publisher name: ");
        String publisher = newNewspaper.nextLine();
        
        System.out.print("Enter date published: ");
        String published = newNewspaper.nextLine();
        
        System.out.print("Enter issue: ");
        int issue = newNewspaper.nextInt();
        
        ReadingMaterial newspaper = 
                new Newspaper(title,publisher,published,issue);
        
        return (Newspaper) newspaper;
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
        System.out.print("Enter title of reading material: ");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        
        ArrayList<ReadingMaterial> materialFound = 
                this.register.findMaterial(title);
        if(materialFound != null)
        {
            printReadingMaterialInfo(materialFound);
        }
        else {
            System.out.println( "Reading material not found! "
                    + "Make sure you spell the title correctly." );
        }
        
    }
    
    private void loadFromDatabase()
    {
        ReadingMaterial rm1 = new Book("Siggi","Vake", "Today","Author",1);
        ReadingMaterial rm2 = new Magazine("Time","GUI", "1-1-2019",1);
        ReadingMaterial rm3 = new Magazine("Time","GUI","1-2-2019",2);
        ReadingMaterial rm4 = new Newspaper("VG","Norge", "1-3-2019",1);
        
        this.register.addToCollection(rm1);
        this.register.addToCollection(rm2);
        this.register.addToCollection(rm3);
        this.register.addToCollection(rm4);
    }
    
    private void printReadingMaterialInfo(ArrayList materialFound)
    {
        Iterator<ReadingMaterial> it = materialFound.iterator();
        
        while(it.hasNext())
        {
            ReadingMaterial rm = it.next();
            if(rm instanceof Book)
            {   
                Book book = (Book) rm;
                printBookInfo(book);
            }
            else if (rm instanceof Magazine)
            {
                Magazine magazine = (Magazine) rm;
                printMagazineInfo(magazine);
                
            }
            else if (rm instanceof Newspaper)
            {
                Newspaper newspaper = (Newspaper) rm;
                printNewspaperInfo(newspaper);
            }
            
            
        } // end of while
    } // end of printReadingMaterial
    
    private void printBookInfo(Book book)
    {
        System.out.println("Title:\t\t"      + book.getTitle());
        System.out.println("Publisher:\t"    + book.getPublisher());
        System.out.println("Published:\t"    + book.getPublished());
        System.out.println("Author:\t\t"     + book.getAuthor());
        System.out.println("Edition:\t\t"    + book.getEdition());
        System.out.println("");
    }
    
    private void printMagazineInfo(Magazine magazine)
    {
        System.out.println("Title:\t\t"      + magazine.getTitle());
        System.out.println("Publisher:\t"    + magazine.getPublisher());
        System.out.println("Published:\t"    + magazine.getPublished());
        System.out.println("Issue:\t\t"      + magazine.getIssue());
        System.out.println("");
    }
    
    private void printNewspaperInfo(Newspaper newspaper)
    {
        System.out.println("Title:\t\t"      + newspaper.getTitle());
        System.out.println("Publisher:\t"    + newspaper.getPublisher());
        System.out.println("Published:\t"    + newspaper.getPublished());
        System.out.println("Issue:\t\t"      + newspaper.getIssue());
        System.out.println("");
    }
    

}
