/*
 * @author: Sigurdur Hallur Jonsson
 */
package kiosk;

/**
 *
 * @author siggi
 */
public abstract class Literature extends ReadingMaterial
{
    private String author;
    private int edition;
    
    public Literature(String title, String publisher, String published, String author, int edition)
    {
        super(title, publisher, published);
        if(author == null)
        {
            this.author = "";
        }
        this.author = author;
        validateEdition(edition);
    }
    
    public String getAuthor()
    {
        return this.author;
    }

    
    public int getEdition()
    {
        return this.edition;
    }
    
    private boolean validateEdition(int edition)
    {
        boolean validEdition = true;
        this.edition = edition;
        if(edition < 0)
        {
            validEdition = false;
            this.edition = 0;
        }
        return validEdition;
    }
}
